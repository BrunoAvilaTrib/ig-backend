
package pe.com.synopsis.imgrabber.dao.sp;

import java.sql.Types;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.stereotype.Component;

@Component
public class SPAddTokenForRecoverPassword extends CPStoredProcedure
{

    private static final String SP_NAME = "P_ADD_TOKEN_FOR_RECOVER_PASSWORD";
    public static final String IN_EMAIL = "@emailEntered";
    public static final String IN_TOKEN = "@recoverToken";

    @Autowired
    public SPAddTokenForRecoverPassword(JdbcTemplate jdbcTemplate)
    {
        super(jdbcTemplate, SP_NAME);
    }

    @Override
    public void configSP()
    {
        getSimpleJdbcCall().useInParameterNames(IN_EMAIL, IN_TOKEN).declareParameters(
                new SqlParameter(IN_EMAIL, Types.VARCHAR), new SqlParameter(IN_TOKEN, Types.VARCHAR));

    }

}
