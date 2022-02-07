
package pe.com.synopsis.imgrabber.dao.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Component;

import pe.com.synopsis.imgrabber.beans.domain.LoadRole;
import pe.com.synopsis.imgrabber.dao.RoleDAO;
import pe.com.synopsis.imgrabber.dao.sp.SPLoadRole;
import pe.com.synopsis.imgrabber.enumeration.SPCodeEnum;
import pe.com.synopsis.imgrabber.exception.RulesException;

@Component
@SuppressWarnings({ "unchecked" })
public class RoleDAOImpl implements RoleDAO
{

    @Autowired
    SPLoadRole sSPLoadRole;

    @Override
    public List<LoadRole> loadRole(Long loginEmployPK)
    {

        SqlParameterSource in = new MapSqlParameterSource().addValue(SPLoadRole.IN_LOGIN_EMPLOY_PK, loginEmployPK);

        Map<String, Object> result = sSPLoadRole.execute(in);
        String status = (String) result.get(SPLoadRole.OUT_STATUS);

        if (!SPCodeEnum.RESULT_OK.isCode(status))
        {
            throw new RulesException(status);
        }

        List<LoadRole> loadRole = (List<LoadRole>) result.get(SPLoadRole.OUT_CURSOR);
        return loadRole;
    }
}
