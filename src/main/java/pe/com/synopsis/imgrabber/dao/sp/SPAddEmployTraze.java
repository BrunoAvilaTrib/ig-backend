
package pe.com.synopsis.imgrabber.dao.sp;

import java.sql.Types;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.SqlOutParameter;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.stereotype.Component;

@Component
public class SPAddEmployTraze extends CPStoredProcedure
{

    private static final String SP_NAME = "P_ADD_EMPLOY_TRAZE";
    public static final String OUT_CURSOR = "salCursor";
    public static final String OUT_STATUS = "@saltStatus";
    public static final String IN_EMPLOY_LOGIN = "@inEmployLogin";
    public static final String IN_OPERATION = "@inEmployTrazeOperation";

    @Autowired
    public SPAddEmployTraze(JdbcTemplate jdbcTemplate)
    {
        super(jdbcTemplate, SP_NAME);
    }

    @Override
    public void configSP()
    {
        getSimpleJdbcCall().useInParameterNames(IN_EMPLOY_LOGIN, IN_OPERATION).declareParameters(
                new SqlOutParameter(OUT_STATUS, Types.VARCHAR), new SqlParameter(IN_EMPLOY_LOGIN, Types.VARCHAR),
                new SqlParameter(IN_OPERATION, Types.VARCHAR));
    }
}