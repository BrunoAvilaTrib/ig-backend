
package pe.com.synopsis.imgrabber.dao.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import pe.com.synopsis.imgrabber.beans.domain.LoadRole;

public class LoadRoleMapper implements RowMapper<LoadRole>
{

    private static final String ROLE_PK_COLUM = "ROLE_PK";
    private static final String NAME_COLUM = "NAME";

    @Override
    public LoadRole mapRow(ResultSet rs, int rowNum) throws SQLException
    {

        LoadRole loadRole = new LoadRole();
        loadRole.setRolePk(rs.getLong(ROLE_PK_COLUM));
        loadRole.setName(rs.getString(NAME_COLUM));

        return loadRole;
    }

}
