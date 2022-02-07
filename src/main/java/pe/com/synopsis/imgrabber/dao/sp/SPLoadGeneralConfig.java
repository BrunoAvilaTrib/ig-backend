
package pe.com.synopsis.imgrabber.dao.sp;

import java.sql.Types;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.SqlOutParameter;
import org.springframework.stereotype.Component;

import pe.com.synopsis.imgrabber.dao.mapper.LoadGeneralConfigMapper;

@Component
public class SPLoadGeneralConfig extends CPStoredProcedure
{

    private static final String SP_NAME = "P_LOAD_GENERAL_CONFIG";
    // PARAMETROS
    public static final String OUT_CURSOR = "salCursor";
    public static final String OUT_STATUS = "saltStatus";

    @Autowired
    public SPLoadGeneralConfig(JdbcTemplate jdbcTemplate)
    {
        super(jdbcTemplate, SP_NAME);
        // TODO Auto-generated constructor stub
    }

    @Override
    public void configSP()
    {
        // TODO Auto-generated method stub

        getSimpleJdbcCall().declareParameters(new SqlOutParameter(OUT_STATUS, Types.VARCHAR))
                .returningResultSet(OUT_CURSOR, new LoadGeneralConfigMapper());

    }

}
