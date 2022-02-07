
package pe.com.synopsis.imgrabber.dao.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import pe.com.synopsis.imgrabber.beans.domain.Resource;

public class ResourceMapper implements RowMapper<Resource>
{
    // iduser, username, password, secret
    private static final String COLUMN_FILE = "FFILE";

    @Override
    public Resource mapRow(ResultSet rs, int rowNum) throws SQLException
    {
        Resource video = new Resource();
        video.setContent(rs.getBytes(COLUMN_FILE));
        return video;
    }

}
