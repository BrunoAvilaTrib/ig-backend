
package pe.com.synopsis.imgrabber.dao.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Component;

import pe.com.synopsis.imgrabber.beans.domain.LoadEmployTraze;
import pe.com.synopsis.imgrabber.beans.request.AddEmployTrazeRequest;
import pe.com.synopsis.imgrabber.dao.EmployTrazeDAO;
import pe.com.synopsis.imgrabber.dao.sp.SPAddEmployTraze;
import pe.com.synopsis.imgrabber.dao.sp.SPLoadEmployTraze;
import pe.com.synopsis.imgrabber.enumeration.SPCodeEnum;
import pe.com.synopsis.imgrabber.exception.RulesException;

@Component
@SuppressWarnings({ "unchecked" })

public class EmployTrazeDAOImpl implements EmployTrazeDAO
{

    @Autowired
    private SPLoadEmployTraze sPLoadEmployTraze;
    @Autowired
    private SPAddEmployTraze sPAddEmployTraze;

    @Override
    public List<LoadEmployTraze> loadEmployTrace()
    {
        SqlParameterSource in = new MapSqlParameterSource();
        Map<String, Object> result = sPLoadEmployTraze.execute(in);
        String status = (String) result.get(SPLoadEmployTraze.OUT_STATUS);
        if (!SPCodeEnum.RESULT_OK.isCode(status))
        {
            throw new RulesException(status);
        }

        List<LoadEmployTraze> traceuser = (List<LoadEmployTraze>) result.get(SPLoadEmployTraze.OUT_CURSOR);

        return traceuser;
    }

    @Override
    public void addEmployTraze(AddEmployTrazeRequest addEmployTrazeRequest, String login)
    {

        SqlParameterSource in = new MapSqlParameterSource().addValue(SPAddEmployTraze.IN_EMPLOY_LOGIN, login)
                .addValue(SPAddEmployTraze.IN_OPERATION, addEmployTrazeRequest.getOperation());
        Map<String, Object> result = sPAddEmployTraze.execute(in);
        String status = (String) result.get(SPAddEmployTraze.OUT_STATUS);
        if (!SPCodeEnum.RESULT_OK.isCode(status))
        {

            throw new RulesException(status);
        }

    }

}
