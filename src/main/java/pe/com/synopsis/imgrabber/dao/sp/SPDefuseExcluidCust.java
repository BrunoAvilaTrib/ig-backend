
package pe.com.synopsis.imgrabber.dao.sp;

import java.sql.Types;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.SqlOutParameter;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.stereotype.Component;

@Component
public class SPDefuseExcluidCust extends CPStoredProcedure
{

    private static final String SP_NAME = "P_DEFUSE_EXCLUID_CUSTOMER";
    public static final String OUT_STATUS = "@saltStatus";
    public static final String IN_EXCLUID_CUST_PK = "@inExcluidCustPK";

    @Autowired
    public SPDefuseExcluidCust(JdbcTemplate jdbcTemplate)
    {
        super(jdbcTemplate, SP_NAME);
    }

    @Override
    public void configSP()
    {

        getSimpleJdbcCall().useInParameterNames(IN_EXCLUID_CUST_PK).declareParameters(
                new SqlOutParameter(OUT_STATUS, Types.VARCHAR), new SqlParameter(IN_EXCLUID_CUST_PK, Types.BIGINT));
    }
}
