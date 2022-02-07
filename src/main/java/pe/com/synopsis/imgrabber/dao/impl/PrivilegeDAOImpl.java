
package pe.com.synopsis.imgrabber.dao.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Component;

import pe.com.synopsis.imgrabber.beans.domain.LoadBySupervisorPrivilege;
import pe.com.synopsis.imgrabber.beans.domain.LoadPrivilege;
import pe.com.synopsis.imgrabber.dao.PrivilegeDAO;
import pe.com.synopsis.imgrabber.dao.sp.SPLoadBySupervisorPrivilege;
import pe.com.synopsis.imgrabber.dao.sp.SPLoadPrivilege;
import pe.com.synopsis.imgrabber.enumeration.SPCodeEnum;
import pe.com.synopsis.imgrabber.exception.RulesException;

@SuppressWarnings({ "unused", "unchecked" })

@Component
public class PrivilegeDAOImpl implements PrivilegeDAO
{

    @Autowired
    private SPLoadPrivilege sPLoadPrivileges;

    @Autowired
    private SPLoadBySupervisorPrivilege sPLoadBySupervisorPrivilege;

    @Override
    public List<LoadBySupervisorPrivilege> loadBySupervisorPrivilege(String login)
    {

        SqlParameterSource in = new MapSqlParameterSource().addValue(SPLoadBySupervisorPrivilege.IN_EMPLOY_LOGIN,
                login);

        Map<String, Object> result = sPLoadBySupervisorPrivilege.execute(in);

        String status = (String) result.get(SPLoadBySupervisorPrivilege.OUT_STATUS);

        if (!SPCodeEnum.RESULT_OK.isCode(status))
        {
            throw new RulesException(status);

        }

        List<LoadBySupervisorPrivilege> response = (List<LoadBySupervisorPrivilege>) result
                .get(SPLoadPrivilege.OUT_CURSOR);

        return response;
    }

    @Override
    public List<LoadPrivilege> loadPrivilege()
    {

        SqlParameterSource in = new MapSqlParameterSource();

        Map<String, Object> result = sPLoadPrivileges.execute(in);

        String status = (String) result.get(SPLoadPrivilege.OUT_STATUS);

        if (!SPCodeEnum.RESULT_OK.isCode(status))
        {
            throw new RulesException(status);

        }

        List<LoadPrivilege> response = (List<LoadPrivilege>) result.get(SPLoadPrivilege.OUT_CURSOR);

        return response;
    }

}
