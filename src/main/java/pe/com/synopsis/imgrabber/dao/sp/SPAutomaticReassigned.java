
package pe.com.synopsis.imgrabber.dao.sp;

import java.sql.Types;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.SqlOutParameter;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.stereotype.Component;

@Component
public class SPAutomaticReassigned extends CPStoredProcedure
{

    private static final String SP_NAME = "P_AUTOMATIC_REASSIGNED";
    public static final String OUT_STATUS = "@saltStatus";
    public static final String IN_EMPLOY_FK = "@inEmployPK";
    public static final String IN_DATE = "@inDate";

    @Autowired
    public SPAutomaticReassigned(JdbcTemplate jdbcTemplate)
    {
        super(jdbcTemplate, SP_NAME);
    }

    @Override
    public void configSP()
    {
        getSimpleJdbcCall().useInParameterNames(IN_EMPLOY_FK, IN_DATE).declareParameters(
                new SqlOutParameter(OUT_STATUS, Types.VARCHAR), new SqlParameter(IN_EMPLOY_FK, Types.BIGINT),
                new SqlParameter(IN_DATE, Types.VARCHAR));
    }

}
