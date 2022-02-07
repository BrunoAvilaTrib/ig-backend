
package pe.com.synopsis.imgrabber.dao.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import pe.com.synopsis.imgrabber.beans.domain.LoadChatsReassignedEmploy;

@Component
public class LoadChatsReassignedEmployMapper implements RowMapper<LoadChatsReassignedEmploy>
{

    private static final String CHAT_PK = "CHAT_PK";
    private static final String CHATMOBILE = "CHATMOBILE";
    private static final String STATE = "STATE";
    private static final String AREA = "AREA";
    private static final String OPERATOR = "OPERATOR";

    @Override
    public LoadChatsReassignedEmploy mapRow(ResultSet rs, int rowNum) throws SQLException
    {

        LoadChatsReassignedEmploy loadChatsReassignedEmploy = new LoadChatsReassignedEmploy();
        loadChatsReassignedEmploy.setChatPK(rs.getLong(CHAT_PK));
        loadChatsReassignedEmploy.setChatmobile(rs.getString(CHATMOBILE));
        loadChatsReassignedEmploy.setState(rs.getString(STATE));
        loadChatsReassignedEmploy.setArea(rs.getString(AREA));
        loadChatsReassignedEmploy.setOperator(rs.getString(OPERATOR));

        return loadChatsReassignedEmploy;
    }
}
