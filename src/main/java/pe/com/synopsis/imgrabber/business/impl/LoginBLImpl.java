
package pe.com.synopsis.imgrabber.business.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import pe.com.synopsis.imgrabber.beans.dto.RoleDTO;
import pe.com.synopsis.imgrabber.beans.request.LoginRequest;
import pe.com.synopsis.imgrabber.beans.response.LoginResponse;
import pe.com.synopsis.imgrabber.beans.response.Response;
import pe.com.synopsis.imgrabber.business.LoginBL;
import pe.com.synopsis.imgrabber.dao.BusinessDAO;
import pe.com.synopsis.imgrabber.dao.LoginDAO;
import pe.com.synopsis.imgrabber.dao.ValidTokenAndStatusDAO;
import pe.com.synopsis.imgrabber.enumeration.PropsEnum;
import pe.com.synopsis.imgrabber.enumeration.StatusEnum;
import pe.com.synopsis.imgrabber.exception.LoginAttemptException;
import pe.com.synopsis.imgrabber.security.JwtTokenProvider;
import pe.com.synopsis.imgrabber.security.SecurityRequest;
import pe.com.synopsis.imgrabber.security.SecurityToken;

@Component
public class LoginBLImpl implements LoginBL
{

    private static final Logger logger = LoggerFactory.getLogger(LoginBLImpl.class);

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtTokenProvider tokenProvider;

    @Autowired
    private Environment env;

    @Autowired
    private BusinessDAO businessDAO;

    @Autowired
    private ValidTokenAndStatusDAO validTokenAndStatusDAO;

    @Autowired
    private LoginDAO loginDao;

    @Autowired
    private JavaMailSender emailSender;

    @Override
    public Response<LoginResponse> validateEmploy(LoginRequest login) throws Exception
    {
        Response<LoginResponse> response = new Response<LoginResponse>();
        try
        {
            SecurityToken authentication = (SecurityToken) authenticationManager
                    .authenticate(new SecurityRequest(login.getEmail(), login.getPassword(), login));

            SecurityContextHolder.getContext().setAuthentication(authentication);
            LoginResponse lr = new LoginResponse();
            String jwt = tokenProvider.generateToken(authentication);
            RoleDTO role = authentication.getUserInfo().getRole().get(0);

            lr.setSessionId(String.format("%s %s", PropsEnum.JWT_PREFIX.getString(env), jwt));
            lr.setEmail(login.getEmail());
            lr.setRole(role);
            lr.setEmploy(authentication.getUserInfo().getNameEmploy());

            if ("F".equals(authentication.getUserInfo().getIsGlobalAdmin()))
            {
                lr.setBussines(businessDAO.getNameBusiness(login.getEmail()));
            }

            response.setData(lr);
            response.setStatus(StatusEnum.STATUS_SUCCESSFULL.create());
        }
        catch (LoginAttemptException e)
        {
            response.setStatus(e.getStatus());
        }
        catch (Exception e)
        {
            logger.error(e.getMessage(), e);
            response.setStatus(StatusEnum.STATUS_FAIL.create());
        }

        return response;
    }

    @Override
    public void logout(SecurityToken token)
    {
        validTokenAndStatusDAO.deleteTokenEmploy(token);
    }

    @Override
    public void changeMyPassword(String requiredEmail)
    {
        loginDao.validateEmail(requiredEmail);
        String generatedToken = loginDao.generateToken(requiredEmail);

        SimpleMailMessage message = new SimpleMailMessage();

        message.setFrom("noreply@synopsis.com");
        message.setTo(requiredEmail);
        message.setSubject("Password Reset");
        message.setText("click on the following link for your password reset " + "(here goes the link)"
                + "and use this token to validate your password reset " + generatedToken);
        emailSender.send(message);
    }

}
