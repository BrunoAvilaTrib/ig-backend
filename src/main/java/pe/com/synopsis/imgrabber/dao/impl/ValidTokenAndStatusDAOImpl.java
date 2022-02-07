
package pe.com.synopsis.imgrabber.dao.impl;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Component;

import pe.com.synopsis.imgrabber.dao.ValidTokenAndStatusDAO;
import pe.com.synopsis.imgrabber.dao.sp.SPAddToken;
import pe.com.synopsis.imgrabber.dao.sp.SPDeleteTokenEmploy;
import pe.com.synopsis.imgrabber.dao.sp.SPValidateUserStatusAndToken;
import pe.com.synopsis.imgrabber.enumeration.SPCodeEnum;
import pe.com.synopsis.imgrabber.exception.RulesException;
import pe.com.synopsis.imgrabber.security.SecurityToken;
import pe.com.synopsis.imgrabber.security.UserInfo;

@Component
public class ValidTokenAndStatusDAOImpl implements ValidTokenAndStatusDAO
{

    @SuppressWarnings("unused")
    private static final Logger logger = LoggerFactory.getLogger(ValidTokenAndStatusDAOImpl.class);

    @Autowired
    private SPValidateUserStatusAndToken sPValidateUserStatusAndToken;

    @Autowired
    private SPAddToken sPAddToken;

    @Autowired
    private SPDeleteTokenEmploy sPDeleteTokenEmploy;

    @Override
    public String devolverStatus(UserInfo userinfo, String token)
    {

        SqlParameterSource in = new MapSqlParameterSource().addValue(SPValidateUserStatusAndToken.IN_TOKEN, token)
                .addValue(SPValidateUserStatusAndToken.IN_LOGIN_EMAIL, (userinfo.getEmail()));

        Map<String, Object> result = sPValidateUserStatusAndToken.execute(in);
        String value = (String) result.get(SPValidateUserStatusAndToken.OUT_STATUS);

        return value;
    }

    @Override
    public void addToken(UserInfo userinfo, String authToken)
    {

        SqlParameterSource in = new MapSqlParameterSource().addValue(SPAddToken.IN_TOKEN, authToken)
                .addValue(SPAddToken.IN_LOGIN_EMAIL, (userinfo.getEmail()));

        sPAddToken.execute(in);

    }

    @Override
    public void deleteTokenEmploy(SecurityToken token)
    {

        SqlParameterSource in = new MapSqlParameterSource().addValue(SPDeleteTokenEmploy.IN_LOGIN_EMAIL,
                token.getUserInfo().getEmail());

        Map<String, Object> result = sPDeleteTokenEmploy.execute(in);
        String status = (String) result.get(SPDeleteTokenEmploy.OUT_STATUS);

        if (!SPCodeEnum.RESULT_OK.isCode(status))
        {
            throw new RulesException(status);
        }
    }

}
