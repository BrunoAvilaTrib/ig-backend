
package pe.com.synopsis.imgrabber.dao.sp;

import java.sql.Types;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.SqlOutParameter;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.stereotype.Component;

@Component
public class SPAddExcluid extends CPStoredProcedure
{

    private static final String SP_NAME = "P_ADD_EXCLUID";
    public static final String OUT_STATUS = "saltStatus";
    public static final String IN_MOBILE = "@inExcluidMobile";
    public static final String IN_ALIAS = "@inExcluidAlias";
    public static final String IN_EMPLOY_FK = "@inEmployFK";

    @Autowired
    public SPAddExcluid(JdbcTemplate jdbcTemplate)
    {
        super(jdbcTemplate, SP_NAME);
    }

    @Override
    public void configSP()
    {
        getSimpleJdbcCall().useInParameterNames(IN_MOBILE, IN_ALIAS, IN_EMPLOY_FK).declareParameters(
                new SqlOutParameter(OUT_STATUS, Types.VARCHAR), new SqlParameter(IN_MOBILE, Types.VARCHAR),
                new SqlParameter(IN_ALIAS, Types.VARCHAR), new SqlParameter(IN_EMPLOY_FK, Types.VARCHAR));
    }

}
