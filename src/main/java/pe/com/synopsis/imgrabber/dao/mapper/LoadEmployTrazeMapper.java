
package pe.com.synopsis.imgrabber.dao.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import pe.com.synopsis.imgrabber.beans.domain.LoadEmployTraze;

public class LoadEmployTrazeMapper implements RowMapper<LoadEmployTraze>
{

    private static final String EMPLOY_TRAZE_PK_COLUM = "EMPLOY_TRAZE_PK";
    private static final String LOGIN_COLUM = "LOGIN";
    private static final String NAME_EMPLOY_COLUM = "NAME_EMPLOY";
    private static final String DATE_COLUM = "DATE";
    private static final String TIME_COLUM = "TIME";
    private static final String OPERATION_COLUM = "OPERATION";

    private static final String ANEXO_AREA_COLUM = "ANEXO_AREA";
    private static final String NAME_AREA_COLUM = "NAME_AREA";

    @Override
    public LoadEmployTraze mapRow(ResultSet rs, int rowNum) throws SQLException
    {

        LoadEmployTraze loadEmployTraze = new LoadEmployTraze();
        loadEmployTraze.setEmployTrazePk(rs.getLong(EMPLOY_TRAZE_PK_COLUM));
        loadEmployTraze.setLogin(rs.getString(LOGIN_COLUM));
        loadEmployTraze.setNameEmploy(rs.getString(NAME_EMPLOY_COLUM));
        loadEmployTraze.setDate(rs.getDate(DATE_COLUM));
        loadEmployTraze.setTime(rs.getTime(TIME_COLUM));
        loadEmployTraze.setOperation(rs.getString(OPERATION_COLUM));
        loadEmployTraze.setAreaAnexo(rs.getString(ANEXO_AREA_COLUM));
        loadEmployTraze.setAreaName(rs.getString(NAME_AREA_COLUM));

        return loadEmployTraze;
    }

}
