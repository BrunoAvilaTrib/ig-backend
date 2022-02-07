
package pe.com.synopsis.imgrabber.dao.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import pe.com.synopsis.imgrabber.beans.domain.UploadAssigned;

public class UploadAssignedMapper implements RowMapper<UploadAssigned>
{

    private static final String CHAT_PK_COLUM = "CHAT_FK";
    private static final String ROLE_NAME_EMPLOY = "NAME_EMPLOY";
    private static final String ROLE_NAME_AREA = "NAME_AREA";

    @Override
    public UploadAssigned mapRow(ResultSet rs, int rowNum) throws SQLException
    {

        UploadAssigned uploadAssigned = new UploadAssigned();
        uploadAssigned.setNameEmploy(rs.getString(ROLE_NAME_EMPLOY));
        uploadAssigned.setNameArea(rs.getString(ROLE_NAME_AREA));
        uploadAssigned.setIdchat(rs.getLong(CHAT_PK_COLUM));

        return uploadAssigned;
    }
}
