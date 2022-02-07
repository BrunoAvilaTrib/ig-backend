
package pe.com.synopsis.imgrabber.dao.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import pe.com.synopsis.imgrabber.beans.domain.LoadArea;

@Component
public class LoadAreaMapper implements RowMapper<LoadArea>
{

    private static final String AREA_PK_COLUM = "AREA_PK";
    private static final String NAME_COLUM = "NAME";
    private static final String COMMENT_COLUM = "COMMENT";
    private static final String ACTIVE_COLUM = "ACTIVE";

    @Override
    public LoadArea mapRow(ResultSet rs, int rowNum) throws SQLException
    {

        LoadArea loadArea = new LoadArea();
        loadArea.setAreaPk(rs.getLong(AREA_PK_COLUM));
        loadArea.setName(rs.getString(NAME_COLUM));
        loadArea.setComment(rs.getString(COMMENT_COLUM));
        loadArea.setActive(rs.getLong(ACTIVE_COLUM));
        return loadArea;
    }
}