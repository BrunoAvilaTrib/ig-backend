
package pe.com.synopsis.imgrabber.dao.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import pe.com.synopsis.imgrabber.beans.domain.Header;

@Component
public class HeaderMapper implements RowMapper<Header>
{

    private static final String COLUM_HEADER = "HEADER";
    private static final String COLUM_PATH_ROUTE = "PATH_RUTE";
    private static final String COLUM_PATH_IMG = "PATH_IMG";
    private static final String COLUM_PATH_IMG_B = "PATH_IMG_B";

    @Override
    public Header mapRow(ResultSet rs, int rowNum) throws SQLException
    {
        Header header = new Header();
        header.setHeader(rs.getString(COLUM_HEADER));
        header.setPath(rs.getString(COLUM_PATH_ROUTE));
        header.setPathImg(rs.getString(COLUM_PATH_IMG));
        header.setPathImgB(rs.getString(COLUM_PATH_IMG_B));
        return header;
    }

}
