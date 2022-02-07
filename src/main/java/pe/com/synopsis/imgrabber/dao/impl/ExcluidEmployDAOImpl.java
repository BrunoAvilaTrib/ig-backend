
package pe.com.synopsis.imgrabber.dao.impl;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Component;

import pe.com.synopsis.imgrabber.beans.domain.LoadAllExcluidEmploy;
import pe.com.synopsis.imgrabber.beans.domain.LoadExcluidEmploy;
import pe.com.synopsis.imgrabber.beans.request.AddExcluidEmployRequest;
import pe.com.synopsis.imgrabber.beans.request.DefuseExcluidEmployRequest;
import pe.com.synopsis.imgrabber.beans.request.LoadExcluidEmployRequest;
import pe.com.synopsis.imgrabber.beans.request.UpdateExcluidEmployRequest;
import pe.com.synopsis.imgrabber.dao.ExcluidEmployDAO;
import pe.com.synopsis.imgrabber.dao.sp.SPAddExcluidEmploy;
import pe.com.synopsis.imgrabber.dao.sp.SPDefuseExcluidEmploy;
import pe.com.synopsis.imgrabber.dao.sp.SPLoadAllExcluidEmploy;
import pe.com.synopsis.imgrabber.dao.sp.SPLoadExcluidEmploy;
import pe.com.synopsis.imgrabber.dao.sp.SPUpdateExcluidEmploy;
import pe.com.synopsis.imgrabber.enumeration.SPCodeEnum;
import pe.com.synopsis.imgrabber.exception.RulesException;

@Component
@SuppressWarnings({ "unchecked", "unused" })
public class ExcluidEmployDAOImpl implements ExcluidEmployDAO
{

    private static final Logger logger = LoggerFactory.getLogger(ExcluidEmployDAOImpl.class);

    @Autowired
    private SPAddExcluidEmploy sPAddExcluidEmploy;

    @Autowired
    private SPUpdateExcluidEmploy sPUpdateExcluidEmploy;

    @Autowired
    private SPDefuseExcluidEmploy sPDefuseExcluidEmploy;

    @Autowired
    private SPLoadAllExcluidEmploy sPLoadAllExcluidEmploy;

    @Autowired
    private SPLoadExcluidEmploy sPLoadExcluidEmploy;

    @Override
    public void addExcluidEmploy(AddExcluidEmployRequest addExcluidEmployRequest)
    {

        SqlParameterSource in = new MapSqlParameterSource()
                .addValue(SPAddExcluidEmploy.IN_START_DATE, addExcluidEmployRequest.getStartDate())
                .addValue(SPAddExcluidEmploy.IN_END_DATE, addExcluidEmployRequest.getEndDate())
                .addValue(SPAddExcluidEmploy.IN_EMPLOY_FK, addExcluidEmployRequest.getEmployFk())
                .addValue(SPAddExcluidEmploy.IN_REASON, addExcluidEmployRequest.getReason());

        Map<String, Object> result = sPAddExcluidEmploy.execute(in);
        String status = (String) result.get(SPAddExcluidEmploy.OUT_STATUS);

        if (!SPCodeEnum.RESULT_OK.isCode(status))
        {
            throw new RulesException(status);
        }

    }

    @Override
    public void updateExcluidEmploy(UpdateExcluidEmployRequest updateExcluidEmployRequest)
    {

        SqlParameterSource in = new MapSqlParameterSource()
                .addValue(SPUpdateExcluidEmploy.IN_EXCLUID_EMPLOY_PK, updateExcluidEmployRequest.getExcluidEmployPk())
                .addValue(SPUpdateExcluidEmploy.IN_START_DATE, updateExcluidEmployRequest.getStartDate())
                .addValue(SPUpdateExcluidEmploy.IN_END_DATE, updateExcluidEmployRequest.getEndDate())
                .addValue(SPUpdateExcluidEmploy.IN_EMPLOY_FK, updateExcluidEmployRequest.getEmployFk());

        Map<String, Object> result = sPUpdateExcluidEmploy.execute(in);
        String status = (String) result.get(SPUpdateExcluidEmploy.OUT_STATUS);

        if (!SPCodeEnum.RESULT_OK.isCode(status))
        {
            throw new RulesException(status);
        }
    }

    @Override
    public void defuseExcluidEmploy(DefuseExcluidEmployRequest defuseExcluidEmployRequest)
    {

        SqlParameterSource in = new MapSqlParameterSource().addValue(SPDefuseExcluidEmploy.IN_EXCLUID_EMPLOY_PK,
                defuseExcluidEmployRequest.getExcluidEmployPk());

        Map<String, Object> result = sPDefuseExcluidEmploy.execute(in);
        String status = (String) result.get(SPDefuseExcluidEmploy.OUT_STATUS);

        if (!SPCodeEnum.RESULT_OK.isCode(status))
        {
            throw new RulesException(status);
        }
    }

    @Override
    public List<LoadAllExcluidEmploy> loadAllExcluidEmploy(Long loginEmployFK)
    {

        SqlParameterSource in = new MapSqlParameterSource().addValue(SPLoadAllExcluidEmploy.IN_LOGIN_EMPLOY_PK,
                loginEmployFK);

        Map<String, Object> result = sPLoadAllExcluidEmploy.execute(in);
        String status = (String) result.get(SPLoadAllExcluidEmploy.OUT_STATUS);

        if (!SPCodeEnum.RESULT_OK.isCode(status))
        {
            throw new RulesException(status);
        }

        List<LoadAllExcluidEmploy> traceuser = (List<LoadAllExcluidEmploy>) result
                .get(SPLoadAllExcluidEmploy.OUT_CURSOR);
        return traceuser;
    }

    @Override
    public List<LoadExcluidEmploy> loadExcluidEmploy(LoadExcluidEmployRequest LoadExcluidEmployRequest)
    {

        SqlParameterSource in = new MapSqlParameterSource().addValue(SPLoadExcluidEmploy.IN_EXCLUID_EMPLOY_PK,
                LoadExcluidEmployRequest.getExcluidEmployPK());

        Map<String, Object> result = sPLoadExcluidEmploy.execute(in);
        String status = (String) result.get(SPLoadExcluidEmploy.OUT_STATUS);

        if (!SPCodeEnum.RESULT_OK.isCode(status))
        {
            throw new RulesException(status);
        }

        List<LoadExcluidEmploy> traceuser = (List<LoadExcluidEmploy>) result.get(SPLoadExcluidEmploy.OUT_CURSOR);
        return traceuser;
    }
}