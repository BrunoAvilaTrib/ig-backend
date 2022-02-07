
package pe.com.synopsis.imgrabber.dao.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import pe.com.synopsis.imgrabber.beans.domain.LoadPrivilege;

public class LoadPrivilegesMapper implements RowMapper<LoadPrivilege>
{

    private static final String PRIVILEGE_PK_COLUM = "PRIVILEGE_PK";
    private static final String NAME_COLUM = "NAME";

    @Override
    public LoadPrivilege mapRow(ResultSet rs, int rowNum) throws SQLException
    {
        // TODO Auto-generated method stub

        LoadPrivilege loadPrivilege = new LoadPrivilege();
        loadPrivilege.setPrivilegePk(rs.getLong(PRIVILEGE_PK_COLUM));
        loadPrivilege.setName(rs.getString(NAME_COLUM));
        return loadPrivilege;
    }

}