
package pe.com.synopsis.imgrabber.dao.sp;

import java.sql.Types;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.SqlOutParameter;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.stereotype.Component;

@Component
public class SPUpdateEmployConfig extends CPStoredProcedure
{

    public static final String SP_NAME = "P_UPDATE_EMPLOY_CONFIG";

    // params
    public static final String OUT_STATUS = "saltStatus";
    public static final String SP_IN_CONFIG_PK = "inConfigPk";
    public static final String SP_IN_EMPLOY_PK = "inEmployPk";
    public static final String SP_IN_STATE = "inState";

    public SPUpdateEmployConfig(JdbcTemplate jdbcTemplate)
    {
        super(jdbcTemplate, SP_NAME);
        // TODO Auto-generated constructor stub
    }

    @Override
    public void configSP()
    {

        getSimpleJdbcCall().useInParameterNames(SP_IN_CONFIG_PK, SP_IN_EMPLOY_PK, SP_IN_STATE).declareParameters(
                new SqlOutParameter(OUT_STATUS, Types.VARCHAR), new SqlParameter(SP_IN_CONFIG_PK, Types.BIGINT),
                new SqlParameter(SP_IN_EMPLOY_PK, Types.BIGINT), new SqlParameter(SP_IN_STATE, Types.VARCHAR));
        // TODO Auto-generated method stub

    }

}
