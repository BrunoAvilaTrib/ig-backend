
package pe.com.synopsis.imgrabber.dao.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import pe.com.synopsis.imgrabber.beans.domain.LoadNavegation;

public class LoadNavegationMapper implements RowMapper<LoadNavegation>
{

    private static final String NAVEGATION_PK_COLUM = "NAVEGATION_PK";
    private static final String NAME_NAVEGATION_COLUM = "NAME_NAVEGATION";
    private static final String SUBMENU_PK_COLUM = "SUBMENU_PK";
    private static final String NAME_SUBMENU_COLUM = "NAME_SUBMENU";
    private static final String PATH_RUTE_COLUM = "PATH_RUTE";

    @Override
    public LoadNavegation mapRow(ResultSet rs, int rowNum) throws SQLException
    {

        LoadNavegation loadNavegation = new LoadNavegation();
        loadNavegation.setNavegationPk(rs.getLong(NAVEGATION_PK_COLUM));
        loadNavegation.setNameNavegation(rs.getString(NAME_NAVEGATION_COLUM));
        loadNavegation.setSubmenuPk(rs.getLong(SUBMENU_PK_COLUM));
        loadNavegation.setNameSubmenu(rs.getString(NAME_SUBMENU_COLUM));
        loadNavegation.setPathRute(rs.getString(PATH_RUTE_COLUM));
        return loadNavegation;
    }

}
