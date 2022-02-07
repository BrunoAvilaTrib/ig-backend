
package pe.com.synopsis.imgrabber.dao.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import pe.com.synopsis.imgrabber.beans.domain.LoadAllEmployByRole;

@Component
public class LoadAllEmployByRoleMapper implements RowMapper<LoadAllEmployByRole>
{

    private static final String EMPLOY_PK_COLUM = "EMPLOY_PK";
    private static final String NAME_EMPLOY_COLUM = "NAME_EMPLOY";

    @Override
    public LoadAllEmployByRole mapRow(ResultSet rs, int rowNum) throws SQLException
    {

        LoadAllEmployByRole loadAllEmployByRole = new LoadAllEmployByRole();
        loadAllEmployByRole.setEmployPK(rs.getLong(EMPLOY_PK_COLUM));
        loadAllEmployByRole.setNameEmploy(rs.getString(NAME_EMPLOY_COLUM));

        return loadAllEmployByRole;
    }
}
