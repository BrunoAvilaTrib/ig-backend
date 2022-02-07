
package pe.com.synopsis.imgrabber.dao.sp;

import java.sql.Types;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.SqlOutParameter;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.stereotype.Component;

import pe.com.synopsis.imgrabber.dao.mapper.GetLastUpdateMSGMapper;

@Component
public class SPGetLastUpdateMSG extends CPStoredProcedure
{

    private static final String SP_NAME = "P_GET_LAST_UPDATEMSG";
    public static final String OUT_STATUS = "@saltStatus";
    public static final String OUT_CURSOR = "@salCursor";
    public static final String IN_OFFI_PHONE = "@pOffiPhone";
    public static final String IN_CUST_PHONE = "@pCustPhone";
    public static final String IN_CUST_NAME = "@pCustName";

    @Autowired
    public SPGetLastUpdateMSG(JdbcTemplate jdbcTemplate)
    {
        super(jdbcTemplate, SP_NAME);
    }

    @Override
    public void configSP()
    {
        getSimpleJdbcCall()
                .declareParameters(new SqlOutParameter(OUT_STATUS, Types.VARCHAR),
                        new SqlParameter(IN_OFFI_PHONE, Types.VARCHAR), new SqlParameter(IN_CUST_PHONE, Types.VARCHAR),
                        new SqlParameter(IN_CUST_NAME, Types.VARCHAR))
                .returningResultSet(OUT_CURSOR, new GetLastUpdateMSGMapper());

    }
}
