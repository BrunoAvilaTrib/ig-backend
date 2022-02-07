
package pe.com.synopsis.imgrabber.dao.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import pe.com.synopsis.imgrabber.beans.domain.LoadEmploy;

public class LoadEmployMapper implements RowMapper<LoadEmploy>
{

    private static final String EMPLOY_PK_COLUM = "EMPLOY_PK";
    private static final String NAME_COLUM = "NAME";
    private static final String APEPAT_COLUM = "APEPAT";
    private static final String APEMAT_COLUM = "APEMAT";
    private static final String EMAIL_COLUM = "EMAIL";
    private static final String GENDER_COLUMN = "GENDER";
    private static final String MOBILE_COLUM = "MOBILE";
    private static final String BUSINESS_FK_COLUM = "BUSINESS_FK";
    private static final String AREA_FK_COLUM = "AREA_FK";
    private static final String ROLE_FK_COLUM = "ROLE_FK";
    private static final String SUPERVISOR_FK_COLUM = "SUPERVISOR_FK";

    @Override
    public LoadEmploy mapRow(ResultSet rs, int rowNum) throws SQLException
    {

        LoadEmploy employ = new LoadEmploy();

        employ.setEmployPk(rs.getLong(EMPLOY_PK_COLUM));
        employ.setName(rs.getString(NAME_COLUM));
        employ.setApePat(rs.getString(APEPAT_COLUM));
        employ.setApeMat(rs.getString(APEMAT_COLUM));
        employ.setEmail(rs.getString(EMAIL_COLUM));
        employ.setSex(rs.getString(GENDER_COLUMN));
        employ.setMobile(rs.getString(MOBILE_COLUM));
        employ.setBusinessFK(rs.getLong(BUSINESS_FK_COLUM));
        employ.setAreaFk(rs.getLong(AREA_FK_COLUM));
        employ.setRoleFk(rs.getLong(ROLE_FK_COLUM));
        employ.setEmployFk(rs.getLong(SUPERVISOR_FK_COLUM));

        return employ;
    }

}
