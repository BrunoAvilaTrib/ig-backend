
package pe.com.synopsis.imgrabber.dao.sp;

import java.sql.Types;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.SqlOutParameter;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.stereotype.Component;

import pe.com.synopsis.imgrabber.dao.mapper.LoadAllExcluidMapper;

@Component
public class SPLoadAllExcluid extends CPStoredProcedure
{

    private static final String SP_NAME = "P_LOAD_ALL_EXCLUID";
    public static final String OUT_CURSOR = "@salCursor";
    public static final String OUT_STATUS = "@saltStatus";
    public static final String IN_EMPLOY_PK = "@inEmployPK";

    @Autowired
    public SPLoadAllExcluid(JdbcTemplate jdbcTemplate)
    {
        super(jdbcTemplate, SP_NAME);
    }

    @Override
    public void configSP()
    {
        getSimpleJdbcCall().useInParameterNames(IN_EMPLOY_PK)
                .declareParameters(new SqlOutParameter(OUT_STATUS, Types.VARCHAR),
                        new SqlParameter(IN_EMPLOY_PK, Types.BIGINT))
                .returningResultSet(OUT_CURSOR, new LoadAllExcluidMapper());
    }
}