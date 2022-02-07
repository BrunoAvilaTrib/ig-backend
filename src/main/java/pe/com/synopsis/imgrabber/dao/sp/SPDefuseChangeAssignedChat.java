
package pe.com.synopsis.imgrabber.dao.sp;

import java.sql.Types;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.SqlOutParameter;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.stereotype.Component;

@Component
public class SPDefuseChangeAssignedChat extends CPStoredProcedure
{

    private static final String SP_NAME = "P_DEFUSE_CHANGE_ASSIGNED_CHAT";
    public static final String OUT_STATUS = "@saltStatus";
    public static final String IN_CHAT_FK = "@inChatFK";

    @Autowired
    public SPDefuseChangeAssignedChat(JdbcTemplate jdbcTemplate)
    {
        super(jdbcTemplate, SP_NAME);
    }

    @Override
    public void configSP()
    {
        getSimpleJdbcCall().useInParameterNames(IN_CHAT_FK).declareParameters(
                new SqlOutParameter(OUT_STATUS, Types.VARCHAR), new SqlParameter(IN_CHAT_FK, Types.BIGINT));
    }

}
