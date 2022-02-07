
package pe.com.synopsis.imgrabber.dao.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import pe.com.synopsis.imgrabber.beans.domain.LoadEmployConfig;

public class LoadEmployConfigMapper implements RowMapper<LoadEmployConfig>
{

    private static final String CONFIG_PK_COLUM = "CONFIG_FK";
    private static final String EMPLOY_FK_COLUM = "EMPLOY_FK";
    private static final String NAME_COLUM = "NAME";
    private static final String ADVANCE_CONFIG_COLUM = "ADVANCE_CONFIG";
    private static final String STATE_COLUM = "STATE";

    @Override
    public LoadEmployConfig mapRow(ResultSet rs, int rowNum) throws SQLException
    {

        LoadEmployConfig loademployconfig = new LoadEmployConfig();
        loademployconfig.setConfigFk(rs.getLong(CONFIG_PK_COLUM));
        loademployconfig.setEmployFk(rs.getLong(EMPLOY_FK_COLUM));
        loademployconfig.setName(rs.getString(NAME_COLUM));
        loademployconfig.setAdvanceConfig(rs.getString(ADVANCE_CONFIG_COLUM));
        loademployconfig.setState(rs.getString(STATE_COLUM));

        return loademployconfig;
    }

}
