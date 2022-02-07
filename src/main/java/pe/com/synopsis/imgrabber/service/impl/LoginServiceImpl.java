
package pe.com.synopsis.imgrabber.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.com.synopsis.imgrabber.beans.request.LoginRequest;
import pe.com.synopsis.imgrabber.beans.response.ResultResponse;
import pe.com.synopsis.imgrabber.beans.response.LoginResponse;
import pe.com.synopsis.imgrabber.beans.response.Response;
import pe.com.synopsis.imgrabber.beans.response.Status;
import pe.com.synopsis.imgrabber.business.LoginBL;
import pe.com.synopsis.imgrabber.enumeration.StatusEnum;
import pe.com.synopsis.imgrabber.exception.RulesException;
import pe.com.synopsis.imgrabber.security.SecurityToken;
import pe.com.synopsis.imgrabber.service.LoginService;

@Service
public class LoginServiceImpl implements LoginService
{

    private static final Logger logger = LoggerFactory.getLogger(LoginServiceImpl.class);

    @Autowired
    private LoginBL loginBL;

    @Override
    public Response<LoginResponse> login(LoginRequest login)
    {

        Response<LoginResponse> response = new Response<LoginResponse>();
        try
        {
            response = loginBL.validateEmploy(login);
        }
        catch (RulesException ex)
        {
            logger.error(ex.getMessage(), ex);
            response.setStatus(new Status(ex.getErrorcode(), ex.getMessage()));
        }
        catch (Exception ex)
        {
            logger.error(ex.getMessage(), ex);
            response.setStatus(StatusEnum.STATUS_FAIL.create());
        }

        return response;
    }

    @Override
    public Response<Status> logout(SecurityToken token)
    {
        Response<Status> response = new Response<>();
        try
        {
            loginBL.logout(token);
            response.setStatus(StatusEnum.STATUS_SUCCESSFULL.create());

        }
        catch (RulesException e)
        {
            logger.error(e.getMessage(), e);
            response.setStatus(new Status(e.getErrorcode(), e.getMessage()));

        }
        catch (Exception e)
        {
            logger.error(e.getMessage(), e);
            response.setStatus(StatusEnum.STATUS_FAIL.create());
        }
        return response;
    }

    @Override
    public ResultResponse sendEmailForPasswordChange(String requiredEmail)
    {

        ResultResponse response = new ResultResponse();
        try
        {
            loginBL.changeMyPassword(requiredEmail);
            response.setStatus(StatusEnum.STATUS_SUCCESSFULL.create());
        }
        catch (Exception e)
        {
            logger.error(e.getMessage(), e);
            response.setStatus(StatusEnum.STATUS_FAIL.create());
        }
        return response;
    }

}
