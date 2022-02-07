
package pe.com.synopsis.imgrabber.dao.sp;

import java.sql.Types;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.SqlOutParameter;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.stereotype.Component;

@Component
public class SPUpdateAdminGlobalPassword extends CPStoredProcedure
{

    private static final String SP_NAME = "P_UPDATE_ADMIN_GLOBAL_PASSWORD";
    public static final String OUT_STATUS = "@saltStatus";
    public static final String IN_PASSWORD = "@inPassword";
    public static final String IN_EMPLOY_PK = "@inEmployPK";
    public static final String IN_LOGIN_EMPLOY_PK = "@inLoginEmployPK";

    @Autowired
    public SPUpdateAdminGlobalPassword(JdbcTemplate jdbcTemplate)
    {
        super(jdbcTemplate, SP_NAME);
    }

    @Override
    public void configSP()
    {
        getSimpleJdbcCall().useInParameterNames(IN_PASSWORD, IN_EMPLOY_PK, IN_LOGIN_EMPLOY_PK).declareParameters(
                new SqlOutParameter(OUT_STATUS, Types.VARCHAR), new SqlParameter(IN_PASSWORD, Types.VARCHAR),
                new SqlParameter(IN_EMPLOY_PK, Types.BIGINT), new SqlParameter(IN_LOGIN_EMPLOY_PK, Types.BIGINT));
    }
}
