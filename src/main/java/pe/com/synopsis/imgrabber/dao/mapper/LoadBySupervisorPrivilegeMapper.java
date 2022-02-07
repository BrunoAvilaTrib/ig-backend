
package pe.com.synopsis.imgrabber.dao.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import pe.com.synopsis.imgrabber.beans.domain.LoadBySupervisorPrivilege;

public class LoadBySupervisorPrivilegeMapper implements RowMapper<LoadBySupervisorPrivilege>
{

    private static final String COLUMN_EMPLOY_PK = "EMPLOY_PK";
    private static final String COLUMN_PRIVILEGE_PK = "PRIVILEGE_PK";
    private static final String COLUMN_NAME = "NAME";
    private static final String COLUMN_STATE = "STATE";

    @Override
    public LoadBySupervisorPrivilege mapRow(ResultSet rs, int rowNum) throws SQLException
    {

        LoadBySupervisorPrivilege employ = new LoadBySupervisorPrivilege();
        employ.setEmployPk(rs.getLong(COLUMN_EMPLOY_PK));
        employ.setPrivilegePk(rs.getLong(COLUMN_PRIVILEGE_PK));
        employ.setName(rs.getString(COLUMN_NAME));
        employ.setState(rs.getString(COLUMN_STATE));
        return employ;
    }

}
