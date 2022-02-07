
package pe.com.synopsis.imgrabber.dao.sp;

import java.sql.Types;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.SqlOutParameter;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.stereotype.Component;

@Component
public class SPAddExcluidEmploy extends CPStoredProcedure
{

    private static final String SP_NAME = "P_ADD_EXCLUID_EMPLOY";
    public static final String OUT_STATUS = "@saltStatus";
    public static final String IN_START_DATE = "@inStartDate";
    public static final String IN_END_DATE = "@inEndDate";
    public static final String IN_EMPLOY_FK = "@inEmployFk";
    public static final String IN_REASON = "@inReason";

    @Autowired
    public SPAddExcluidEmploy(JdbcTemplate jdbcTemplate)
    {
        super(jdbcTemplate, SP_NAME);
    }

    @Override
    public void configSP()
    {
        getSimpleJdbcCall().useInParameterNames(IN_START_DATE, IN_END_DATE, IN_EMPLOY_FK, IN_REASON).declareParameters(
                new SqlOutParameter(OUT_STATUS, Types.VARCHAR), new SqlParameter(IN_START_DATE, Types.VARCHAR),
                new SqlParameter(IN_END_DATE, Types.VARCHAR), new SqlParameter(IN_EMPLOY_FK, Types.BIGINT),
                new SqlParameter(IN_REASON, Types.VARCHAR));
    }
}