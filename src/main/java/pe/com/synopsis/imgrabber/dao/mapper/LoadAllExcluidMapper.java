
package pe.com.synopsis.imgrabber.dao.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import pe.com.synopsis.imgrabber.beans.domain.LoadAllExcluid;

public class LoadAllExcluidMapper implements RowMapper<LoadAllExcluid>
{

    private static final String COLUMN_EXCLUID_PK = "EXCLUID_PK";
    private static final String COLUMN_MOBILE = "MOBILE";
    private static final String COLUMN_ALIAS = "ALIAS";
    private static final String COLUMN_EMPLOY_FK = "EMPLOY_FK";

    @Override
    public LoadAllExcluid mapRow(ResultSet rs, int rowNum) throws SQLException
    {

        LoadAllExcluid employ = new LoadAllExcluid();
        employ.setExcluidPk(rs.getLong(COLUMN_EXCLUID_PK));
        employ.setMobile(rs.getString(COLUMN_MOBILE));
        employ.setAlias(rs.getString(COLUMN_ALIAS));
        employ.setEmployFk(rs.getLong(COLUMN_EMPLOY_FK));
        return employ;
    }

}
