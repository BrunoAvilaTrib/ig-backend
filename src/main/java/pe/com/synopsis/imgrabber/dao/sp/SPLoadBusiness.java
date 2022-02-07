
package pe.com.synopsis.imgrabber.dao.sp;

import java.sql.Types;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.SqlOutParameter;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.stereotype.Component;

import pe.com.synopsis.imgrabber.dao.mapper.LoadBusinessMapper;

@Component
public class SPLoadBusiness extends CPStoredProcedure
{

    private static final String SP_NAME = "P_LOAD_BUSINESS";
    public static final String OUT_CURSOR = "@salCursor";
    public static final String OUT_STATUS = "@saltStatus";
    public static final String IN_BUSINESS_PK = "@inBusinessPK";

    @Autowired
    public SPLoadBusiness(JdbcTemplate jdbcTemplate)
    {
        super(jdbcTemplate, SP_NAME);
    }

    @Override
    public void configSP()
    {
        getSimpleJdbcCall()
                .declareParameters(new SqlOutParameter(OUT_STATUS, Types.VARCHAR),
                        new SqlParameter(IN_BUSINESS_PK, Types.BIGINT))
                .returningResultSet(OUT_CURSOR, new LoadBusinessMapper());
    }
}
