
package pe.com.synopsis.imgrabber.dao.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import pe.com.synopsis.imgrabber.beans.domain.LoadAllBusinessByRole;

@Component
public class LoadAllBusinessByRoleMapper implements RowMapper<LoadAllBusinessByRole>
{

    private static final String BUSINESS_PK_COLUM = "BUSINESS_PK";
    private static final String NAME_BUSINESS = "NAME";

    @Override
    public LoadAllBusinessByRole mapRow(ResultSet rs, int rowNum) throws SQLException
    {

        LoadAllBusinessByRole loadAllBusinessByRole = new LoadAllBusinessByRole();
        loadAllBusinessByRole.setBusinessPK(rs.getLong(BUSINESS_PK_COLUM));
        loadAllBusinessByRole.setName(rs.getString(NAME_BUSINESS));

        return loadAllBusinessByRole;
    }
}
