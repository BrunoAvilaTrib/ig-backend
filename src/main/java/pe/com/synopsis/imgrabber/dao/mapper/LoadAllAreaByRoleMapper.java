
package pe.com.synopsis.imgrabber.dao.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import pe.com.synopsis.imgrabber.beans.domain.LoadAllAreaByRole;

@Component
public class LoadAllAreaByRoleMapper implements RowMapper<LoadAllAreaByRole>
{

    private static final String AREA_PK_COLUM = "AREA_PK";
    private static final String NAME_COLUM = "NAME";

    @Override
    public LoadAllAreaByRole mapRow(ResultSet rs, int rowNum) throws SQLException
    {

        LoadAllAreaByRole loadAllAreaByRole = new LoadAllAreaByRole();
        loadAllAreaByRole.setAreaPK(rs.getLong(AREA_PK_COLUM));
        loadAllAreaByRole.setName(rs.getString(NAME_COLUM));

        return loadAllAreaByRole;
    }
}
