
package pe.com.synopsis.imgrabber.dao.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import pe.com.synopsis.imgrabber.beans.domain.LoadAllEmploy;

public class LoadAllEmployMapper implements RowMapper<LoadAllEmploy>
{

    private static final String COLUMN_EMPLOY_PK = "EMPLOY_PK";
    private static final String COLUMN_NAME_EMPLOY = "NAME_EMPLOY";
    private static final String COLUMN_NAME_ROLE = "NAME_ROLE";
    private static final String COLUMN_EMAIL = "EMAIL";
    private static final String COLUMN_MOBILE = "MOBILE";
    private static final String COLUMN_NAME_AREA = "NAME_AREA";
    private static final String COLUMN_DATE = "DATE";

    @Override
    public LoadAllEmploy mapRow(ResultSet rs, int rowNum) throws SQLException
    {

        LoadAllEmploy loadAllEmploy = new LoadAllEmploy();
        loadAllEmploy.setEmployPk(rs.getLong(COLUMN_EMPLOY_PK));
        loadAllEmploy.setNameEnploy(rs.getString(COLUMN_NAME_EMPLOY));
        loadAllEmploy.setNameRole(rs.getString(COLUMN_NAME_ROLE));
        loadAllEmploy.setEmail(rs.getString(COLUMN_EMAIL));
        loadAllEmploy.setMobile(rs.getString(COLUMN_MOBILE));
        loadAllEmploy.setNameArea(rs.getString(COLUMN_NAME_AREA));
        loadAllEmploy.setDate(rs.getString(COLUMN_DATE));

        return loadAllEmploy;
    }
}
