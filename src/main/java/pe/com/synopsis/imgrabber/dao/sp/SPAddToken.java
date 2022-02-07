
package pe.com.synopsis.imgrabber.dao.sp;

import java.sql.Types;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.SqlOutParameter;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.stereotype.Component;

@Component
public class SPAddToken extends CPStoredProcedure
{

    private static final String SP_NAME = "P_ADD_TOKEN_EMPLOY";
    public static final String OUT_STATUS = "@saltStatus";
    public static final String IN_TOKEN = "@inEmploytoken";
    public static final String IN_LOGIN_EMAIL = "@inLoginEmail";

    @Autowired
    public SPAddToken(JdbcTemplate jdbcTemplate)
    {
        super(jdbcTemplate, SP_NAME);
    }

    @Override
    public void configSP()
    {
        getSimpleJdbcCall().useInParameterNames(IN_TOKEN, IN_LOGIN_EMAIL).declareParameters(
                new SqlOutParameter(OUT_STATUS, Types.VARCHAR), new SqlParameter(IN_TOKEN, Types.VARCHAR),
                new SqlParameter(IN_LOGIN_EMAIL, Types.VARCHAR));
    }

}
