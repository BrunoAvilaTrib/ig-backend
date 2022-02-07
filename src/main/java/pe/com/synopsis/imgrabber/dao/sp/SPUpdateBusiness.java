
package pe.com.synopsis.imgrabber.dao.sp;

import java.sql.Types;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.SqlOutParameter;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.stereotype.Component;

@Component
public class SPUpdateBusiness extends CPStoredProcedure
{

    private static final String SP_NAME = "P_UPDATE_BUSINESS";
    public static final String OUT_STATUS = "@saltStatus";
    public static final String IN_BUSINESS_PK = "@inBusinessPK";
    public static final String IN_NAME = "@inName";
    public static final String IN_RUC = "@inRuc";
    public static final String IN_STATE = "@inState";

    @Autowired
    public SPUpdateBusiness(JdbcTemplate jdbcTemplate)
    {
        super(jdbcTemplate, SP_NAME);
    }

    @Override
    public void configSP()
    {
        getSimpleJdbcCall().useInParameterNames(IN_BUSINESS_PK, IN_NAME, IN_RUC, IN_STATE).declareParameters(
                new SqlOutParameter(OUT_STATUS, Types.VARCHAR), new SqlParameter(IN_BUSINESS_PK, Types.BIGINT),
                new SqlParameter(IN_NAME, Types.VARCHAR), new SqlParameter(IN_RUC, Types.VARCHAR),
                new SqlParameter(IN_STATE, Types.VARCHAR));
    }
}