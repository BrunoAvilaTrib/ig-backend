
package pe.com.synopsis.imgrabber.dao.impl;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Component;

import pe.com.synopsis.imgrabber.beans.domain.LoadAllExcluidCust;
import pe.com.synopsis.imgrabber.beans.request.AddExcluidCustRequest;
import pe.com.synopsis.imgrabber.beans.request.DefuseExcluidCustRequest;
import pe.com.synopsis.imgrabber.dao.ExcluidCustDAO;
import pe.com.synopsis.imgrabber.dao.sp.SPAddExcluidCust;
import pe.com.synopsis.imgrabber.dao.sp.SPDefuseExcluidCust;
import pe.com.synopsis.imgrabber.dao.sp.SPLoadAllExcluidCust;
import pe.com.synopsis.imgrabber.enumeration.SPCodeEnum;
import pe.com.synopsis.imgrabber.exception.RulesException;

@Component
@SuppressWarnings({ "unchecked", "unused" })
public class ExcluidCustDAOImpl implements ExcluidCustDAO
{

    private static final Logger logger = LoggerFactory.getLogger(ExcluidCustDAOImpl.class);

    @Autowired
    private SPLoadAllExcluidCust sPLoadAllExcluidCust;

    @Autowired
    private SPDefuseExcluidCust sPDefuseExcluidCust;

    @Autowired
    private SPAddExcluidCust sPAddExcluidCust;

    @Override
    public List<LoadAllExcluidCust> loadAllExcluidCust(Long loginEmployFK)
    {

        SqlParameterSource in = new MapSqlParameterSource().addValue(SPAddExcluidCust.IN_LOGIN_EMPLOY_PK,
                loginEmployFK);
        Map<String, Object> result = sPLoadAllExcluidCust.execute(in);
        String status = (String) result.get(SPLoadAllExcluidCust.OUT_STATUS);

        if (!SPCodeEnum.RESULT_OK.isCode(status))
        {
            throw new RulesException(status);
        }

        List<LoadAllExcluidCust> traceuser = (List<LoadAllExcluidCust>) result.get(SPLoadAllExcluidCust.OUT_CURSOR);
        return traceuser;
    }

    @Override
    public void defuseExcluidCust(DefuseExcluidCustRequest defuseExcluidCustRequest)
    {

        SqlParameterSource in = new MapSqlParameterSource().addValue(SPDefuseExcluidCust.IN_EXCLUID_CUST_PK,
                defuseExcluidCustRequest.getExcluidCustPK());

        Map<String, Object> result = sPDefuseExcluidCust.execute(in);
        String status = (String) result.get(SPDefuseExcluidCust.OUT_STATUS);

        if (!SPCodeEnum.RESULT_OK.isCode(status))
        {
            throw new RulesException(status);
        }
    }

    @Override
    public void addExcluidCust(AddExcluidCustRequest addExcluidCustRequest, Long loginEmployFK)
    {

        SqlParameterSource in = new MapSqlParameterSource().addValue(SPAddExcluidCust.IN_LOGIN_EMPLOY_PK, loginEmployFK)
                .addValue(SPAddExcluidCust.IN_PHONE_CUST, addExcluidCustRequest.getPhoneCust())
                .addValue(SPAddExcluidCust.IN_REASON, addExcluidCustRequest.getReason());

        Map<String, Object> result = sPAddExcluidCust.execute(in);
        String status = (String) result.get(SPAddExcluidCust.OUT_STATUS);

        if (!SPCodeEnum.RESULT_OK.isCode(status))
        {
            throw new RulesException(status);
        }
    }
}
