
package pe.com.synopsis.imgrabber.dao.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import pe.com.synopsis.imgrabber.beans.domain.LoadAllArea;

@Component
public class LoadAllAreaMapper implements RowMapper<LoadAllArea>
{

    private static final String AREA_PK_COLUM = "AREA_PK";
    private static final String NAME_AREA_COLUM = "NAME_AREA";
    private static final String COUNT_ASSIGNED_COLUM = "COUNT_ASSIGNED";
   // private static final String SUPPORT_COLUM = "SUPPORT";
    private static final String DATE_COLUM = "DATE";
    private static final String NAME_BUSINESS_COLUM = "NAME_BUSINESS";

    @Override
    public LoadAllArea mapRow(ResultSet rs, int rowNum) throws SQLException
    {

        LoadAllArea loadAllArea = new LoadAllArea();
        loadAllArea.setAreaPk(rs.getLong(AREA_PK_COLUM));
        loadAllArea.setNameArea(rs.getString(NAME_AREA_COLUM));
        loadAllArea.setCountAssigned(rs.getLong(COUNT_ASSIGNED_COLUM));
     //   loadAllArea.setSupport(rs.getString(SUPPORT_COLUM));
        loadAllArea.setDate(rs.getString(DATE_COLUM));
        loadAllArea.setNameBusiness(rs.getString(NAME_BUSINESS_COLUM));

        return loadAllArea;
    }
}