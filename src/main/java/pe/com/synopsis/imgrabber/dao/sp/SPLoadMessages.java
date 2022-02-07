
package pe.com.synopsis.imgrabber.dao.sp;

import java.sql.Types;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.SqlOutParameter;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.stereotype.Component;

import pe.com.synopsis.imgrabber.dao.mapper.MessageMapper;

@Component
public class SPLoadMessages extends CPStoredProcedure
{

    private static final String SP_NAME = "P_LOAD_MESSAGES";

    @Autowired
    private Environment env;

    public static final String OUT_CURSOR = "@salCursor";
    public static final String OUT_STATUS = "@saltStatus";
    public static final String IN_CHATID = "@inChatPk";
    public static final String IN_PAGE = "@inPage";

    @Autowired
    public SPLoadMessages(JdbcTemplate jdbcTemplate)
    {
        super(jdbcTemplate, SP_NAME);
    }

    @Override
    public void configSP()
    {
        getSimpleJdbcCall().useInParameterNames(IN_CHATID, IN_PAGE)
                .declareParameters(new SqlOutParameter(OUT_STATUS, Types.VARCHAR),
                        new SqlParameter(IN_CHATID, Types.BIGINT), new SqlParameter(IN_PAGE, Types.VARCHAR))
                .returningResultSet(OUT_CURSOR, new MessageMapper(env.getProperty("PATH_CDN")));
    }

}
