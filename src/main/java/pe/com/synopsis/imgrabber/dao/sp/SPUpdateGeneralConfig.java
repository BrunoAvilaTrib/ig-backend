
package pe.com.synopsis.imgrabber.dao.sp;

import java.sql.Types;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.SqlOutParameter;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.stereotype.Component;

@Component
public class SPUpdateGeneralConfig extends CPStoredProcedure
{

    private static final String SP_NAME = "P_UPDATE_GENERAL_CONFIG";
    // �RAMAS
    public static final String OUT_STATUS = "saltStatus";
    public static final String IN_GENERAL_CONFIG_PK = "inGeneralConfigPk";
    public static final String IN_GENERAL_CONFIG_STATE = "inGeneralConfigState";

    @Autowired
    public SPUpdateGeneralConfig(JdbcTemplate jdbcTemplate)
    {
        super(jdbcTemplate, SP_NAME);
        // TODO Auto-generated constructor stub
    }

    @Override
    public void configSP()
    {

        getSimpleJdbcCall().useInParameterNames(IN_GENERAL_CONFIG_PK, IN_GENERAL_CONFIG_STATE).declareParameters(
                new SqlOutParameter(OUT_STATUS, Types.VARCHAR), new SqlParameter(IN_GENERAL_CONFIG_PK, Types.BIGINT),
                new SqlParameter(IN_GENERAL_CONFIG_STATE, Types.VARCHAR));

    }

}
