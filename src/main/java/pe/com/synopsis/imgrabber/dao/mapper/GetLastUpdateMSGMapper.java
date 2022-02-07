
package pe.com.synopsis.imgrabber.dao.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import pe.com.synopsis.imgrabber.beans.domain.GetLastUpdateMSG;

@Component
public class GetLastUpdateMSGMapper implements RowMapper<GetLastUpdateMSG>
{

    private static final String MSGHASH = "MSGHASH";
    private static final String MSGDATETIME = "MSGDATETIME";
    private static final String MSGDATE = "MSGDATE";
    private static final String MSGHOUR = "MSGHOUR";

    @Override
    public GetLastUpdateMSG mapRow(ResultSet rs, int rowNum) throws SQLException
    {

        GetLastUpdateMSG getLastUpdateMSG = new GetLastUpdateMSG();
        getLastUpdateMSG.setMsgHash(rs.getString(MSGHASH));
        getLastUpdateMSG.setMsgDateTime(rs.getString(MSGDATETIME));
        getLastUpdateMSG.setMsgDate(rs.getString(MSGDATE));
        getLastUpdateMSG.setMsgHour(rs.getString(MSGHOUR));

        return getLastUpdateMSG;
    }
}
