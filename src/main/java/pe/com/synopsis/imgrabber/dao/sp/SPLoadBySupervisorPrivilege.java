
package pe.com.synopsis.imgrabber.dao.sp;

import java.sql.Types;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.SqlOutParameter;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.stereotype.Component;

import pe.com.synopsis.imgrabber.dao.mapper.LoadBySupervisorPrivilegeMapper;

@Component
public class SPLoadBySupervisorPrivilege extends CPStoredProcedure
{

    private static final String SP_NAME = "P_LOAD_BY_SUPERVISOR_PRIVILEGE";
    // PARAMETROS
    public static final String OUT_CURSOR = "salCursor";
    public static final String OUT_STATUS = "saltStatus";
    public static final String IN_EMPLOY_LOGIN = "@inEmployLogin";

    @Autowired
    public SPLoadBySupervisorPrivilege(JdbcTemplate jdbcTemplate)
    {
        super(jdbcTemplate, SP_NAME);
    }

    @Override
    public void configSP()
    {
        getSimpleJdbcCall().useInParameterNames(IN_EMPLOY_LOGIN)
                .declareParameters(new SqlOutParameter(OUT_STATUS, Types.VARCHAR),
                        new SqlParameter(IN_EMPLOY_LOGIN, Types.VARCHAR))
                .returningResultSet(OUT_CURSOR, new LoadBySupervisorPrivilegeMapper());
    }

}
