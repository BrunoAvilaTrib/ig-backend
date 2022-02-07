
package pe.com.synopsis.imgrabber.dao.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import pe.com.synopsis.imgrabber.beans.domain.Page;

public class PagesMapper implements RowMapper<Page>
{
    private static final String COLUMN_MSGDATETIME = "MSGDATETIME";

    @Override
    public Page mapRow(ResultSet rs, int rowNum) throws SQLException
    {
        Page contact = new Page();
        contact.setDate(rs.getDate(COLUMN_MSGDATETIME));
        return contact;
    }

}
