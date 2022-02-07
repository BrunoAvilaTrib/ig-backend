
package pe.com.synopsis.imgrabber.dao.sp;

import java.sql.Types;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.SqlOutParameter;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.stereotype.Component;

@Component
public class SPValidateEmail extends CPStoredProcedure
{

    private static final String SP_NAME = "P_VALIDATE_EMAIL";
    public static final String IN_EMAIL = "@emailEntered";
    public static final String OUT_STATUS = "@saltStatus";

    @Autowired
    public SPValidateEmail(JdbcTemplate jdbcTemplate)
    {
        super(jdbcTemplate, SP_NAME);
    }

    @Override
    public void configSP()
    {
        getSimpleJdbcCall().useInParameterNames(IN_EMAIL).declareParameters(new SqlParameter(IN_EMAIL, Types.VARCHAR),
                new SqlOutParameter(OUT_STATUS, Types.VARCHAR));
    }

}
