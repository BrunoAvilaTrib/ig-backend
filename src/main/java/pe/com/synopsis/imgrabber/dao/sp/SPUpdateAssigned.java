
package pe.com.synopsis.imgrabber.dao.sp;

import java.sql.Types;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.SqlOutParameter;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.stereotype.Component;

@Component
public class SPUpdateAssigned extends CPStoredProcedure
{

    private static final String SP_NAME = "P_UPDATE_ASSIGNED";
    public static final String OUT_STATUS = "@saltStatus";
    public static final String IN_CHAT_FK = "@inChatFK";
    public static final String IN_EMPLOY_FK = "@inEmployFK";

    @Autowired
    public SPUpdateAssigned(JdbcTemplate jdbcTemplate)
    {
        super(jdbcTemplate, SP_NAME);
    }

    @Override
    public void configSP()
    {
        getSimpleJdbcCall().useInParameterNames(IN_CHAT_FK, IN_EMPLOY_FK).declareParameters(
                new SqlOutParameter(OUT_STATUS, Types.VARCHAR), new SqlParameter(IN_CHAT_FK, Types.BIGINT),
                new SqlParameter(IN_EMPLOY_FK, Types.BIGINT));
    }
}
