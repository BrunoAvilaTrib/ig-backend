
package pe.com.synopsis.imgrabber.dao.sp;

import java.sql.Types;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.SqlOutParameter;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.stereotype.Component;

@Component
public class SPLoadBusinessLogin extends CPStoredProcedure
{

    private static final String SP_NAME = "P_LOAD_BUSINESS_LOGIN";
    public static final String OUT_STATUS = "@saltStatus";
    public static final String OUT_NAME_BUSINESS = "@outNameBusiness";
    public static final String IN_LOGIN_EMAIL = "@inLoginEmail";

    @Autowired
    public SPLoadBusinessLogin(JdbcTemplate jdbcTemplate)
    {
        super(jdbcTemplate, SP_NAME);
    }

    @Override
    public void configSP()
    {
        getSimpleJdbcCall().useInParameterNames(IN_LOGIN_EMAIL).declareParameters(
                new SqlOutParameter(OUT_STATUS, Types.VARCHAR), new SqlOutParameter(OUT_NAME_BUSINESS, Types.VARCHAR),
                new SqlParameter(IN_LOGIN_EMAIL, Types.VARCHAR));
    }
}