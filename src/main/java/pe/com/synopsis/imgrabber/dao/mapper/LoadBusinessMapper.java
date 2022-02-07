
package pe.com.synopsis.imgrabber.dao.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import pe.com.synopsis.imgrabber.beans.domain.LoadBusiness;

@Component
public class LoadBusinessMapper implements RowMapper<LoadBusiness>
{

    private static final String BUSINESS_PK_COLUM = "BUSINESS_PK";
    private static final String NAME_COLUM = "NAME";
    private static final String STATE_COLUM = "STATE";
    private static final String RUC_COLUM = "RUC";
    private static final String EMAIL_COLUM = "EMAIL";

    @Override
    public LoadBusiness mapRow(ResultSet rs, int rowNum) throws SQLException
    {

        LoadBusiness loadBusiness = new LoadBusiness();
        loadBusiness.setBusinessPK(rs.getLong(BUSINESS_PK_COLUM));
        loadBusiness.setName(rs.getString(NAME_COLUM));
        loadBusiness.setState(rs.getString(STATE_COLUM));
        loadBusiness.setRuc(rs.getString(RUC_COLUM));
        loadBusiness.setEmail(rs.getString(EMAIL_COLUM));

        return loadBusiness;
    }
}
