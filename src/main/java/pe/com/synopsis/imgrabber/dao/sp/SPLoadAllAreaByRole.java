
package pe.com.synopsis.imgrabber.dao.sp;

import java.sql.Types;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.SqlOutParameter;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.stereotype.Component;

import pe.com.synopsis.imgrabber.dao.mapper.LoadAllAreaByRoleMapper;

@Component
public class SPLoadAllAreaByRole extends CPStoredProcedure
{

    private static final String SP_NAME = "P_LOAD_ALL_AREA_BY_ROLE";
    public static final String OUT_CURSOR = "@salCursor";
    public static final String OUT_STATUS = "@saltStatus";
    public static final String IN_LOGIN_EMPLOY_PK = "@inLoginEmployPK";

    @Autowired
    public SPLoadAllAreaByRole(JdbcTemplate jdbcTemplate)
    {
        super(jdbcTemplate, SP_NAME);
    }

    @Override
    public void configSP()
    {
        getSimpleJdbcCall().useInParameterNames(IN_LOGIN_EMPLOY_PK)
                .declareParameters(new SqlOutParameter(OUT_STATUS, Types.VARCHAR),
                        new SqlParameter(IN_LOGIN_EMPLOY_PK, Types.BIGINT))
                .returningResultSet(OUT_CURSOR, new LoadAllAreaByRoleMapper());
    }
}
