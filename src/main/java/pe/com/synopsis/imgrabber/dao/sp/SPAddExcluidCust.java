
package pe.com.synopsis.imgrabber.dao.sp;

import java.sql.Types;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.SqlOutParameter;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.stereotype.Component;

@Component
public class SPAddExcluidCust extends CPStoredProcedure
{

    private static final String SP_NAME = "P_ADD_EXCLUID_CUSTOMER";
    public static final String OUT_STATUS = "@saltStatus";
    public static final String IN_LOGIN_EMPLOY_PK = "@inLoginEmployPK";
    public static final String IN_PHONE_CUST = "@inPhoneCust";
    public static final String IN_REASON = "@inReason";

    @Autowired
    public SPAddExcluidCust(JdbcTemplate jdbcTemplate)
    {
        super(jdbcTemplate, SP_NAME);
    }

    @Override
    public void configSP()
    {
        getSimpleJdbcCall().useInParameterNames(IN_LOGIN_EMPLOY_PK, IN_PHONE_CUST, IN_REASON).declareParameters(
                new SqlOutParameter(OUT_STATUS, Types.VARCHAR), new SqlParameter(IN_LOGIN_EMPLOY_PK, Types.BIGINT),
                new SqlParameter(IN_PHONE_CUST, Types.VARCHAR), new SqlParameter(IN_REASON, Types.VARCHAR));
    }
}
