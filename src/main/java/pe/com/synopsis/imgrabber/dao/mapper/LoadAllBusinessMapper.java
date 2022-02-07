
package pe.com.synopsis.imgrabber.dao.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import pe.com.synopsis.imgrabber.beans.domain.LoadAllBusiness;

@Component
public class LoadAllBusinessMapper implements RowMapper<LoadAllBusiness>
{

    private static final String BUSINESS_PK_COLUM = "BUSINESS_PK";
    private static final String NAME_COLUM = "NAME";
    private static final String COUNT_ASSIGNED_COLUM = "COUNT_ASSIGNED";
    private static final String ACTIVE_COLUM = "ACTIVE";
    private static final String DATE_COLUM = "DATE";
    private static final String EMAIL_COLUM = "EMAIL";

    @Override
    public LoadAllBusiness mapRow(ResultSet rs, int rowNum) throws SQLException
    {

        LoadAllBusiness loadAllBusiness = new LoadAllBusiness();
        loadAllBusiness.setBusinessPK(rs.getLong(BUSINESS_PK_COLUM));
        loadAllBusiness.setName(rs.getString(NAME_COLUM));
        loadAllBusiness.setCountAssigned(rs.getLong(COUNT_ASSIGNED_COLUM));
        loadAllBusiness.setState(rs.getString(ACTIVE_COLUM));
        loadAllBusiness.setDate(rs.getString(DATE_COLUM));
        loadAllBusiness.setEmail(rs.getString(EMAIL_COLUM));

        return loadAllBusiness;
    }
}
