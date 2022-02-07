
package pe.com.synopsis.imgrabber.dao.sp;

import java.sql.Types;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.SqlOutParameter;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.stereotype.Component;

@Component
public class SPUploadPhoto extends CPStoredProcedure
{

    private static final String SP_NAME = "P_UPLOAD_PHOTO";
    public static final String OUT_STATUS = "@saltStatus";
    public static final String IN_ID_CHAT = "@pIdChat";
    public static final String IN_PHOTO = "@pPhoto";
    public static final String IN_MODE = "@pMode";

    @Autowired
    public SPUploadPhoto(JdbcTemplate jdbcTemplate)
    {
        super(jdbcTemplate, SP_NAME);
    }

    @Override
    public void configSP()
    {
        getSimpleJdbcCall().useInParameterNames(IN_ID_CHAT, IN_PHOTO, IN_MODE).declareParameters(
                new SqlOutParameter(OUT_STATUS, Types.VARCHAR), new SqlParameter(IN_ID_CHAT, Types.BIGINT),
                new SqlParameter(IN_PHOTO, Types.VARCHAR), new SqlParameter(IN_MODE, Types.INTEGER));
    }
}
