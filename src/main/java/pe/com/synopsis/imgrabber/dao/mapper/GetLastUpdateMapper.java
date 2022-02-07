
package pe.com.synopsis.imgrabber.dao.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import pe.com.synopsis.imgrabber.beans.domain.GetLastUpdate;

@Component
public class GetLastUpdateMapper implements RowMapper<GetLastUpdate>
{

    private static final String CHAT_PK = "CHAT_PK";
    private static final String LASTUPDATE = "LASTUPDATE";

    @Override
    public GetLastUpdate mapRow(ResultSet rs, int rowNum) throws SQLException
    {

        GetLastUpdate getLastUpdate = new GetLastUpdate();
        getLastUpdate.setChatPK(rs.getLong(CHAT_PK));
        getLastUpdate.setLastUpdate(rs.getString(LASTUPDATE));

        return getLastUpdate;
    }

}
