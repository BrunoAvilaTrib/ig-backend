
package pe.com.synopsis.imgrabber.dao.sp;

import java.sql.Types;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.SqlOutParameter;
import org.springframework.stereotype.Component;

import pe.com.synopsis.imgrabber.dao.mapper.LoadPrivilegesMapper;

@Component
public class SPLoadPrivilege extends CPStoredProcedure
{

    private static final String NAME = "P_LOAD_PRIVILEGE";
    // paramas
    public static final String OUT_STATUS = "saltStatus";
    public static final String OUT_CURSOR = "salCursor";

    @Autowired
    public SPLoadPrivilege(JdbcTemplate jdbcTemplate)
    {

        super(jdbcTemplate, NAME);
    }

    @Override
    public void configSP()
    {

        getSimpleJdbcCall().declareParameters(new SqlOutParameter(OUT_STATUS, Types.VARCHAR))
                .returningResultSet(OUT_CURSOR, new LoadPrivilegesMapper());

    }

}
