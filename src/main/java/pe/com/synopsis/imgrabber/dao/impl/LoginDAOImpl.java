
package pe.com.synopsis.imgrabber.dao.impl;

import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import pe.com.synopsis.imgrabber.beans.domain.LoadRole;
import pe.com.synopsis.imgrabber.beans.domain.ValidateEmploy;
import pe.com.synopsis.imgrabber.converter.LoadAuthoritiesConverter;
import pe.com.synopsis.imgrabber.dao.LoginDAO;
import pe.com.synopsis.imgrabber.dao.sp.SPAddTokenForRecoverPassword;
import pe.com.synopsis.imgrabber.dao.sp.SPLoadRoleEmploy;
import pe.com.synopsis.imgrabber.dao.sp.SPValidateEmail;
import pe.com.synopsis.imgrabber.dao.sp.SPValidateEmploy;
import pe.com.synopsis.imgrabber.dao.sp.SP_AddCount;
import pe.com.synopsis.imgrabber.enumeration.SPCodeEnum;
import pe.com.synopsis.imgrabber.exception.LoginAttemptException;
import pe.com.synopsis.imgrabber.exception.LoginLockoutException;
import pe.com.synopsis.imgrabber.exception.LoginNotFoundException;
import pe.com.synopsis.imgrabber.exception.RulesException;
import pe.com.synopsis.imgrabber.support.MessageInventory;

@Component
@SuppressWarnings({ "unused", "unchecked" })
public class LoginDAOImpl implements LoginDAO
{

    private static final Logger logger = LoggerFactory.getLogger(LoginDAOImpl.class);

    private static final Integer MAX_ATTEMPTS = 3;

    private static final Integer MAX_MINUTES_ATTEMPT = 10080;

    @Autowired
    private LoadAuthoritiesConverter rolesconverter;

    @Autowired
    private SPLoadRoleEmploy spLoadRoleEmploy;

    @Autowired
    private SPValidateEmploy spValidateUser;

    @Autowired
    private MessageInventory messageInventory;

    @Autowired
    private PasswordEncoder bCryptPasswordEncoder;

    @Autowired
    private SP_AddCount sP_AddCount;

    @Autowired
    private SPValidateEmail spValidateEmail;

    @Autowired
    private SPAddTokenForRecoverPassword spAddTokenForRecoverPassword;

    @Override
    public ValidateEmploy login(String email, String password)
    {

        SqlParameterSource in = new MapSqlParameterSource().addValue(SPValidateEmploy.IN_EMAIL, email)
                .addValue(SPValidateEmploy.IN_MAX_DELAY_ATTEMP, MAX_MINUTES_ATTEMPT);

        Map<String, Object> result = spValidateUser.execute(in);
        String status = (String) result.get(SPValidateEmploy.OUT_STATUS);

        ValidateEmploy validateEmploy = new ValidateEmploy();
        validateEmploy.setEmail(email);
        validateEmploy.setEmployPk((Long) (result.get(SPValidateEmploy.OUT_EMPLOY_PK)));
        validateEmploy.setIsGlobalAdmin((String) (result.get(SPValidateEmploy.OUT_IS_GLOBAL_ADMIN)));
        validateEmploy.setNameEmploy((String) (result.get(SPValidateEmploy.OUT_NAME_EMPLOY)));
        validateEmploy.setSex((String) (result.get(SPValidateEmploy.OUT_SEX)));
        validateEmploy.setAccountNonLocked(true);

        if (SPCodeEnum.USER_NOT_EXIST.isCode(status))
        {
            throw new LoginNotFoundException(SPCodeEnum.USER_NOT_EXIST, validateEmploy);

        }
        else if (SPCodeEnum.USER_LOCKOUT.isCode(status))
        {
            validateEmploy.setAccountNonLocked(false);
            throw new LoginLockoutException(SPCodeEnum.USER_LOCKOUT, validateEmploy);

        }
        else if (SPCodeEnum.LOGER_DESBLOCK.isCode(status))
        {
            throw new LoginAttemptException(SPCodeEnum.LOGER_DESBLOCK, validateEmploy);

        }
        else if (SPCodeEnum.EMPLOYEE_ON_VACATION.isCode(status))
        {
            throw new LoginAttemptException(SPCodeEnum.EMPLOYEE_ON_VACATION, validateEmploy);

        }
        else if (SPCodeEnum.INACTIVE_BUSINESS.isCode(status))
        {
            throw new LoginAttemptException(SPCodeEnum.INACTIVE_BUSINESS, validateEmploy);

        }
        else if (SPCodeEnum.RESULT_OK.isCode(status))
        {
            boolean isPasswordMatches = bCryptPasswordEncoder.matches(password,
                    (String) result.get(SPValidateEmploy.OUT_PASSWORD));

            if (!isPasswordMatches)
            {
                SqlParameterSource in3 = new MapSqlParameterSource().addValue(SP_AddCount.IN_LOGIN_EMAIL, email)
                        .addValue(SP_AddCount.IN_VALUE, "error").addValue(SP_AddCount.IN_ATTEMPS, MAX_ATTEMPTS);

                Map<String, Object> result3 = sP_AddCount.execute(in3);
                String newstatus = (String) result3.get(SP_AddCount.OUT_STATUS);

                if (SPCodeEnum.USER_MAX_ATTEMPT.isCode(newstatus))
                {
                    throw new LoginLockoutException(SPCodeEnum.USER_MAX_ATTEMPT, validateEmploy);
                }
                if (SPCodeEnum.LOGIN_ATTEMPT.isCode(newstatus))
                {
                    throw new LoginAttemptException(SPCodeEnum.LOGIN_ATTEMPT, validateEmploy);
                }

            }
            else
            {
                SqlParameterSource in3 = new MapSqlParameterSource().addValue(SP_AddCount.IN_LOGIN_EMAIL, email)
                        .addValue(SP_AddCount.IN_VALUE, "123").addValue(SP_AddCount.IN_ATTEMPS, MAX_ATTEMPTS);

                Map<String, Object> result4 = sP_AddCount.execute(in3);
                String newstatus = (String) result4.get(SP_AddCount.OUT_STATUS);

                try
                {
                    SqlParameterSource in2 = new MapSqlParameterSource().addValue(SPLoadRoleEmploy.IN_LOGIN_EMAIL,
                            email);

                    Map<String, Object> result2 = spLoadRoleEmploy.execute(in2);
                    List<LoadRole> roles = (List<LoadRole>) result2.get(SPLoadRoleEmploy.OUT_CURSOR);
                    validateEmploy.setCredentialsNonExpired(roles);
                }
                catch (Exception e)
                {
                    logger.error("Error en loginDAO");
                }
            }

            return validateEmploy;

        }
        else
        {
            throw new LoginNotFoundException(SPCodeEnum.ERROR_PROCESS, null);
        }

    }

    @Override
    public void validateEmail(String requiredEmail) throws RulesException
    {
        try
        {
            SqlParameterSource in = new MapSqlParameterSource().addValue(SPValidateEmail.IN_EMAIL, requiredEmail);
            Map<String, Object> result = spValidateEmail.execute(in);
            String status = (String) result.get(SPValidateEmail.OUT_STATUS);
            if (!SPCodeEnum.RESULT_OK.isCode(status))
            {
                throw new RulesException(status);
            }
        }
        catch (EmptyResultDataAccessException e)
        {
            logger.error("error ubicando el email");
        }
    }

    @Override
    public String generateToken(String requiredEmail)
    {
        String token = UUID.randomUUID().toString();
        /**
         * SqlParameterSource in = new MapSqlParameterSource() .addValue(SPAddTokenForRecoverPassword.IN_EMAIL,
         * requiredEmail) .addValue(SPAddTokenForRecoverPassword.IN_TOKEN, token);
         * spAddTokenForRecoverPassword.execute(in);
         **/
        return token;
    }

}