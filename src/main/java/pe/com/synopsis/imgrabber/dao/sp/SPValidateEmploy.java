
package pe.com.synopsis.imgrabber.dao.sp;

import java.sql.Types;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.SqlOutParameter;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.stereotype.Component;

@Component
public class SPValidateEmploy extends CPStoredProcedure
{

    private static final String SP_NAME = "P_VALIDATE_EMPLOY";
    public static final String OUT_STATUS = "@saltStatus";
    public static final String OUT_PASSWORD = "@outPassword";
    public static final String OUT_EMPLOY_PK = "@outEmployPK";
    public static final String OUT_IS_GLOBAL_ADMIN = "@outIsGlobalAdmin";
    public static final String OUT_NAME_EMPLOY = "@outNameEmploy";
    public static final String OUT_SEX = "@outSex";
    public static final String IN_EMAIL = "@inEmail";
    public static final String IN_MAX_DELAY_ATTEMP = "@inMaxDelayAttempt";

    @Autowired
    public SPValidateEmploy(JdbcTemplate jdbcTemplate)
    {
        super(jdbcTemplate, SP_NAME);
    }

    @Override
    public void configSP()
    {
        getSimpleJdbcCall().useInParameterNames(IN_EMAIL, IN_MAX_DELAY_ATTEMP).declareParameters(
                new SqlOutParameter(OUT_STATUS, Types.VARCHAR), new SqlOutParameter(OUT_PASSWORD, Types.VARCHAR),
                new SqlOutParameter(OUT_EMPLOY_PK, Types.BIGINT),
                new SqlOutParameter(OUT_IS_GLOBAL_ADMIN, Types.VARCHAR),
                new SqlOutParameter(OUT_NAME_EMPLOY, Types.VARCHAR), new SqlOutParameter(OUT_SEX, Types.VARCHAR),
                new SqlParameter(IN_EMAIL, Types.VARCHAR), new SqlParameter(IN_MAX_DELAY_ATTEMP, Types.INTEGER));
    }
}