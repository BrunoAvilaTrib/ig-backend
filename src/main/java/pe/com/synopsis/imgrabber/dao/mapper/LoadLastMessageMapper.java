
package pe.com.synopsis.imgrabber.dao.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import pe.com.synopsis.imgrabber.beans.domain.LastMessage;

public class LoadLastMessageMapper implements RowMapper<LastMessage>
{
    private static final String COLUMN_MSGTEXT = "MSGTEXT";

    @Override
    public LastMessage mapRow(ResultSet rs, int rowNum) throws SQLException
    {
        LastMessage lastMessage = new LastMessage();
        lastMessage.setLastMessage(rs.getString(COLUMN_MSGTEXT));

        return lastMessage;
    }

}
