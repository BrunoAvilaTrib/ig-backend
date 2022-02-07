
package pe.com.synopsis.imgrabber.dao.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Component;

import pe.com.synopsis.imgrabber.beans.domain.Header;
import pe.com.synopsis.imgrabber.dao.HeaderDAO;
import pe.com.synopsis.imgrabber.dao.sp.SPLoadHeader;
import pe.com.synopsis.imgrabber.enumeration.SPCodeEnum;
import pe.com.synopsis.imgrabber.exception.RulesException;

@Component
@SuppressWarnings("unchecked")
public class HeaderDAOImpl implements HeaderDAO
{

    @Autowired
    SPLoadHeader sPLoadHeader;

    @Override
    public List<Header> loadHeader(String email)
    {
        SqlParameterSource in = new MapSqlParameterSource().addValue(SPLoadHeader.IN_EMAIL, email);

        Map<String, Object> result = sPLoadHeader.execute(in);
        String status = (String) result.get(SPLoadHeader.OUT_STATUS);

        if (!SPCodeEnum.RESULT_OK.isCode(status))
        {
            throw new RulesException(status);
        }

        List<Header> cabeceras = (List<Header>) result.get(SPLoadHeader.OUT_CURSOR);

        return cabeceras;
    }

}
