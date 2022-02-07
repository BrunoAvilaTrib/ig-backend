
package pe.com.synopsis.imgrabber.dao.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import pe.com.synopsis.imgrabber.beans.domain.LoadAllExcluidCust;

@Component
public class LoadAllExcluidCustMapper implements RowMapper<LoadAllExcluidCust>
{

    private static final String EXCLUID_CUST_PK = "EXCLUID_CUST_PK";
    private static final String NAME_OPERATOR = "NAME_OPERATOR";
    private static final String EMAIL_OPERATOR = "EMAIL_OPERATOR";
    private static final String PHONE_CUST = "PHONE_CUST";
    private static final String REASON = "REASON";
    private static final String DATE = "DATE";
    private static final String NAME_AREA = "NAME_AREA";
    private static final String SEXO = "SEX";

    @Override
    public LoadAllExcluidCust mapRow(ResultSet rs, int rowNum) throws SQLException
    {

        LoadAllExcluidCust loadAllExcluidCust = new LoadAllExcluidCust();
        loadAllExcluidCust.setExcluidCustPK(rs.getLong(EXCLUID_CUST_PK));
        loadAllExcluidCust.setNameOper(rs.getString(NAME_OPERATOR));
        loadAllExcluidCust.setEmailOper(rs.getString(EMAIL_OPERATOR));
        loadAllExcluidCust.setPhoneCust(rs.getString(PHONE_CUST));
        loadAllExcluidCust.setReason(rs.getString(REASON));
        loadAllExcluidCust.setDate(rs.getString(DATE));
        loadAllExcluidCust.setNameArea(rs.getString(NAME_AREA));
        loadAllExcluidCust.setSexo(rs.getString(SEXO));

        return loadAllExcluidCust;
    }

}
