
package pe.com.synopsis.imgrabber.dao.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import pe.com.synopsis.imgrabber.beans.domain.LoadExcluidEmploy;

public class LoadExcluidEmployMapper implements RowMapper<LoadExcluidEmploy>
{
    private static final String EXCLUID_EMPLOY_PK = "EXCLUID_EMPLOY_PK";
    private static final String EMPLOY_FK = "EMPLOY_FK";
    private static final String START_DATE = "START_DATE";
    private static final String END_DATE = "END_DATE";
    private static final String AREA_FK = "AREA_FK";
    private static final String NAME_AREA = "NAME_AREA";
    private static final String NAME_EMPLOY = "NAME_EMPLOY";

    @Override
    public LoadExcluidEmploy mapRow(ResultSet rs, int rowNum) throws SQLException
    {

        LoadExcluidEmploy loadExcluidEmploy = new LoadExcluidEmploy();
        loadExcluidEmploy.setExcluidEmployPK(rs.getLong(EXCLUID_EMPLOY_PK));
        loadExcluidEmploy.setAreaFK(rs.getLong(AREA_FK));
        loadExcluidEmploy.setEmployFK(rs.getLong(EMPLOY_FK));
        loadExcluidEmploy.setStartDate(rs.getString(START_DATE));
        loadExcluidEmploy.setEndDate(rs.getString(END_DATE));
        loadExcluidEmploy.setNameArea(rs.getString(NAME_AREA));
        loadExcluidEmploy.setNameEmploy(rs.getString(NAME_EMPLOY));

        return loadExcluidEmploy;
    }

}
