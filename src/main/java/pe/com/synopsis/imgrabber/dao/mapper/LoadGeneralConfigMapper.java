
package pe.com.synopsis.imgrabber.dao.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import pe.com.synopsis.imgrabber.beans.domain.LoadGeneralConfig;

public class LoadGeneralConfigMapper implements RowMapper<LoadGeneralConfig>
{

    private static final String COLUMN_GENERAL_CONFIG_PK = "GENERAL_CONFIG_PK";
    private static final String COLUMN_NAME = "NAME";
    private static final String COLUMN_STATE = "STATE";

    @Override
    public LoadGeneralConfig mapRow(ResultSet rs, int rowNum) throws SQLException
    {

        LoadGeneralConfig loadGeneralConfig = new LoadGeneralConfig();
        loadGeneralConfig.setGeneralConfigPk(rs.getLong(COLUMN_GENERAL_CONFIG_PK));
        loadGeneralConfig.setName(rs.getString(COLUMN_NAME));
        loadGeneralConfig.setState(rs.getString(COLUMN_STATE));
        return loadGeneralConfig;
    }

}
