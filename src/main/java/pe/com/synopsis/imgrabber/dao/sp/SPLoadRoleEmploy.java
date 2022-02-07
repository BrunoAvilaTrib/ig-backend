
package pe.com.synopsis.imgrabber.dao.sp;

import java.sql.Types;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.SqlOutParameter;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.stereotype.Component;

import pe.com.synopsis.imgrabber.dao.mapper.LoadRoleMapper;

@Component
public class SPLoadRoleEmploy extends CPStoredProcedure
{

    private static final String SP_NAME = "P_LOAD_ROLE_LOGIN";
    public static final String OUT_CURSOR = "@salCursor";
    public static final String OUT_STATUS = "@saltStatus";
    public static final String IN_LOGIN_EMAIL = "@inLoginEmail";

    @Autowired
    public SPLoadRoleEmploy(JdbcTemplate jdbcTemplate)
    {

        super(jdbcTemplate, SP_NAME);
    }

    @Override
    public void configSP()
    {
        getSimpleJdbcCall().useInParameterNames(IN_LOGIN_EMAIL)
                .declareParameters(new SqlOutParameter(OUT_STATUS, Types.VARCHAR),
                        new SqlParameter(IN_LOGIN_EMAIL, Types.VARCHAR))
                .returningResultSet(OUT_CURSOR, new LoadRoleMapper());
    }
}
