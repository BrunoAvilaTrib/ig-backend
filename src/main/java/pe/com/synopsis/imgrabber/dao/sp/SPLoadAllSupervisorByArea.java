
package pe.com.synopsis.imgrabber.dao.sp;

import java.sql.Types;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.SqlOutParameter;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.stereotype.Component;

import pe.com.synopsis.imgrabber.dao.mapper.LoadAllEmployByRoleMapper;

@Component
public class SPLoadAllSupervisorByArea extends CPStoredProcedure
{

    private static final String SP_NAME = "P_LOAD_ALL_SUPERVISOR_BY_AREA";
    public static final String OUT_CURSOR = "@salCursor";
    public static final String OUT_STATUS = "@saltStatus";
    public static final String IN_AREA_FK = "@inAreaFk";

    @Autowired
    public SPLoadAllSupervisorByArea(JdbcTemplate jdbcTemplate)
    {
        super(jdbcTemplate, SP_NAME);
    }

    @Override
    public void configSP()
    {
        getSimpleJdbcCall().useInParameterNames(IN_AREA_FK)
                .declareParameters(new SqlOutParameter(OUT_STATUS, Types.VARCHAR),
                        new SqlParameter(IN_AREA_FK, Types.BIGINT))
                .returningResultSet(OUT_CURSOR, new LoadAllEmployByRoleMapper());
    }
}
