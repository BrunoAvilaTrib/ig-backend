
package pe.com.synopsis.imgrabber.dao.sp;

import java.sql.Types;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.SqlOutParameter;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.stereotype.Component;

@Component
public class SPAddBusiness extends CPStoredProcedure
{

    private static final String SP_NAME = "P_ADD_BUSINESS";
    public static final String OUT_STATUS = "@saltStatus";
    public static final String IN_NAME = "@inName";
    public static final String IN_RUC = "@inRuc";
    public static final String IN_EMAIL = "@inEmail";

    @Autowired
    public SPAddBusiness(JdbcTemplate jdbcTemplate)
    {
        super(jdbcTemplate, SP_NAME);
    }

    @Override
    public void configSP()
    {
        getSimpleJdbcCall().useInParameterNames(IN_NAME, IN_RUC, IN_EMAIL).declareParameters(
                new SqlOutParameter(OUT_STATUS, Types.VARCHAR), new SqlParameter(IN_NAME, Types.VARCHAR),
                new SqlParameter(IN_RUC, Types.VARCHAR), new SqlParameter(IN_EMAIL, Types.VARCHAR));
    }
}