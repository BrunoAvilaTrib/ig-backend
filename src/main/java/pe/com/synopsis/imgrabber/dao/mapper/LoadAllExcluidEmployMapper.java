
package pe.com.synopsis.imgrabber.dao.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import pe.com.synopsis.imgrabber.beans.domain.LoadAllExcluidEmploy;

public class LoadAllExcluidEmployMapper implements RowMapper<LoadAllExcluidEmploy>
{

    private static final String EXCLUID_EMPLOY_PK = "EXCLUID_EMPLOY_PK";
    private static final String AREA_FK = "AREA_FK";
    private static final String EMPLOY_FK = "EMPLOY_FK";
    private static final String START_DATE = "START_DATE";
    private static final String END_DATE = "END_DATE";
    private static final String NAME_AREA = "NAME_AREA";
    private static final String NAME_EMPLOY = "NAME_EMPLOY";

    @Override
    public LoadAllExcluidEmploy mapRow(ResultSet rs, int rowNum) throws SQLException
    {

        LoadAllExcluidEmploy loadAllExcluidEmploy = new LoadAllExcluidEmploy();
        loadAllExcluidEmploy.setExcluidEmployPK(rs.getLong(EXCLUID_EMPLOY_PK));
        loadAllExcluidEmploy.setAreaFK(rs.getLong(AREA_FK));
        loadAllExcluidEmploy.setEmployFK(rs.getLong(EMPLOY_FK));
        loadAllExcluidEmploy.setStartDate(rs.getString(START_DATE));
        loadAllExcluidEmploy.setEndDate(rs.getString(END_DATE));
        loadAllExcluidEmploy.setNameArea(rs.getString(NAME_AREA));
        loadAllExcluidEmploy.setNameEmploy(rs.getString(NAME_EMPLOY));

        return loadAllExcluidEmploy;
    }
}
