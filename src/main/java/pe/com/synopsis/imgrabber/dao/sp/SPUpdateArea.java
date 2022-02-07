
package pe.com.synopsis.imgrabber.dao.sp;

import java.sql.Types;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.SqlOutParameter;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.stereotype.Component;

@Component
public class SPUpdateArea extends CPStoredProcedure
{

    private static final String SP_NAME = "P_UPDATE_AREA";
    public static final String OUT_CURSOR = "@salCursor";
    public static final String OUT_STATUS = "@saltStatus";
    public static final String IN_AREA_PK = "@inAreaPk";
    public static final String IN_AREA_NAME = "@inAreaName";
    public static final String IN_AREA_COMMENT = "@inAreaComment";
    public static final String IN_AREA_SUPPORT = "@inAreaState";

    @Autowired
    public SPUpdateArea(JdbcTemplate jdbcTemplate)
    {
        super(jdbcTemplate, SP_NAME);
    }

    @Override
    public void configSP()
    {
        getSimpleJdbcCall().useInParameterNames(IN_AREA_PK, IN_AREA_NAME, IN_AREA_COMMENT, IN_AREA_SUPPORT)
                .declareParameters(new SqlOutParameter(OUT_STATUS, Types.VARCHAR),
                        new SqlParameter(IN_AREA_PK, Types.BIGINT), new SqlParameter(IN_AREA_NAME, Types.VARCHAR),
                        new SqlParameter(IN_AREA_COMMENT, Types.VARCHAR),
                        new SqlParameter(IN_AREA_SUPPORT, Types.VARCHAR));
    }
}
