
package pe.com.synopsis.imgrabber.dao.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import pe.com.synopsis.imgrabber.beans.domain.LoadAllReassignedChats;

@Component
public class LoadAllReassignedChatsMapper implements RowMapper<LoadAllReassignedChats>
{

    private static final String EMPLOY_PK = "EMPLOY_PK";
    private static final String OPERATOR = "OPERATOR";
    private static final String EMAIL_OPERATOR = "EMAIL_OPERATOR";
    private static final String CHATS = "CHATS";
    private static final String DATE = "DATE";
    private static final String AREA = "AREA";
    private static final String SEX = "SEX";

    @Override
    public LoadAllReassignedChats mapRow(ResultSet rs, int rowNum) throws SQLException
    {

        LoadAllReassignedChats loadAllReassignedChats = new LoadAllReassignedChats();
        loadAllReassignedChats.setEmployPK(rs.getLong(EMPLOY_PK));
        loadAllReassignedChats.setOperator(rs.getString(OPERATOR));
        loadAllReassignedChats.setEmailOperator(rs.getString(EMAIL_OPERATOR));
        loadAllReassignedChats.setChats(rs.getLong(CHATS));
        loadAllReassignedChats.setDate(rs.getString(DATE));
        loadAllReassignedChats.setArea(rs.getString(AREA));
        loadAllReassignedChats.setSex(rs.getString(SEX));
        return loadAllReassignedChats;
    }
}
