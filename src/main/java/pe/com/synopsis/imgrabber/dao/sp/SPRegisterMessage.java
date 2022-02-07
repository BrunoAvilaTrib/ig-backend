
package pe.com.synopsis.imgrabber.dao.sp;

import java.sql.Types;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.SqlOutParameter;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.stereotype.Component;

@Component
public class SPRegisterMessage extends CPStoredProcedure
{

    private static final String SP_NAME = "P_REGISTER_MESSAGE";
    public static final String OUT_STATUS = "@saltStatus";
    public static final String IN_CHAT_FK = "@inChatFK";
    public static final String IN_EMPLOY_FK = "@inEmployFK";
    public static final String IN_TO_USER = "@pToUser";
    public static final String IN_TO_ALIAS = "@pToAlias";
    public static final String IN_MSG_TEXT = "@pMsgText";
    public static final String IN_MSG_DATE = "@pMsgDate";
    public static final String IN_MSG_HOUR = "@pMsgHour";
    public static final String IN_HASH_MSG = "@pHashMsg";
    public static final String IN_MODE_MSG = "@pModeMsg";
    public static final String IN_FILE_HASH = "@pFileHash";
    public static final String IN_FILE_NAME = "@pFileName";
    public static final String IN_FILE_EXT = "@pFileExt";
    public static final String IN_FILE_SIZE = "@pFileSize";
    public static final String IN_FILE_IMAGE = "@pFileImage";

    @Autowired
    public SPRegisterMessage(JdbcTemplate jdbcTemplate)
    {
        super(jdbcTemplate, SP_NAME);
    }

    @Override
    public void configSP()
    {
        getSimpleJdbcCall()
                .useInParameterNames(IN_CHAT_FK, IN_EMPLOY_FK, IN_TO_USER, IN_TO_ALIAS, IN_MSG_TEXT, IN_MSG_DATE,
                        IN_MSG_HOUR, IN_HASH_MSG, IN_MODE_MSG, IN_FILE_HASH, IN_FILE_NAME, IN_FILE_EXT, IN_FILE_SIZE,
                        IN_FILE_IMAGE)
                .declareParameters(new SqlOutParameter(OUT_STATUS, Types.VARCHAR),
                        new SqlParameter(IN_CHAT_FK, Types.BIGINT), new SqlParameter(IN_EMPLOY_FK, Types.BIGINT),
                        new SqlParameter(IN_TO_USER, Types.VARCHAR), new SqlParameter(IN_TO_ALIAS, Types.VARCHAR),
                        new SqlParameter(IN_MSG_TEXT, Types.VARCHAR), new SqlParameter(IN_MSG_DATE, Types.VARCHAR),
                        new SqlParameter(IN_MSG_HOUR, Types.VARCHAR), new SqlParameter(IN_HASH_MSG, Types.VARCHAR),
                        new SqlParameter(IN_MODE_MSG, Types.VARCHAR), new SqlParameter(IN_FILE_HASH, Types.VARCHAR),
                        new SqlParameter(IN_FILE_NAME, Types.VARCHAR), new SqlParameter(IN_FILE_EXT, Types.VARCHAR),
                        new SqlParameter(IN_FILE_SIZE, Types.VARCHAR), new SqlParameter(IN_FILE_IMAGE, Types.VARCHAR));
    }
}
