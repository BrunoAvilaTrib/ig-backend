
package pe.com.synopsis.imgrabber.dao.sp;

import java.sql.Types;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.SqlOutParameter;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.stereotype.Component;

@Component
public class SP_AddCount extends CPStoredProcedure
{

    private static final String SPNAME = "P_ADD_COUNT";
    public static final String OUT_STATUS = "@salStatus";
    public static final String IN_LOGIN_EMAIL = "@inLoginEmail";
    public static final String IN_VALUE = "@inValue";
    public static final String IN_ATTEMPS = "@inMaxAttempts";

    @Autowired
    public SP_AddCount(JdbcTemplate jdbcTemplate)
    {
        super(jdbcTemplate, SPNAME);
    }

    @Override
    public void configSP()
    {
        getSimpleJdbcCall().useInParameterNames(IN_LOGIN_EMAIL, IN_VALUE, IN_ATTEMPS).declareParameters(
                new SqlOutParameter(OUT_STATUS, Types.VARCHAR), new SqlParameter(IN_LOGIN_EMAIL, Types.VARCHAR),
                new SqlParameter(IN_VALUE, Types.VARCHAR), new SqlParameter(IN_ATTEMPS, Types.INTEGER));
    }
}
