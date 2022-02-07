
package pe.com.synopsis.imgrabber.dao.impl;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Component;

import pe.com.synopsis.imgrabber.beans.domain.LoadAllExcluid;
import pe.com.synopsis.imgrabber.beans.request.AddExcluidRequest;
import pe.com.synopsis.imgrabber.dao.ExcluidDAO;
import pe.com.synopsis.imgrabber.dao.sp.SPAddExcluid;
import pe.com.synopsis.imgrabber.dao.sp.SPDeleteExcluid;
import pe.com.synopsis.imgrabber.dao.sp.SPLoadAllExcluid;
import pe.com.synopsis.imgrabber.enumeration.SPCodeEnum;
import pe.com.synopsis.imgrabber.exception.RulesException;
import pe.com.synopsis.imgrabber.service.impl.ChatServiceImpl;

@Component
@SuppressWarnings({ "unchecked", "unused" })
public class ExcluidDAOImpl implements ExcluidDAO
{

    private static final Logger logger = LoggerFactory.getLogger(ChatServiceImpl.class);

    @Autowired
    private SPLoadAllExcluid sPLoadAllExcluid;

    @Autowired
    private SPAddExcluid sPAddExcluid;

    @Autowired
    private SPDeleteExcluid sPdeleteExcluid;

    @Override
    public void addExcluid(AddExcluidRequest addExcluidRequest, Long employPK)
    {
        SqlParameterSource in = new MapSqlParameterSource()
                .addValue(SPAddExcluid.IN_MOBILE, addExcluidRequest.getMobile())
                .addValue(SPAddExcluid.IN_ALIAS, addExcluidRequest.getAlias())
                .addValue(SPAddExcluid.IN_EMPLOY_FK, employPK);

        Map<String, Object> result = sPAddExcluid.execute(in);
        String status = (String) result.get(SPAddExcluid.OUT_STATUS);

        if (!SPCodeEnum.RESULT_OK.isCode(status))
        {
            throw new RulesException(status);
        }
    }

    @Override
    public void deleteExcluid(Long employPK)
    {
        SqlParameterSource in = new MapSqlParameterSource().addValue(SPDeleteExcluid.IN_EMPLOY_FK, employPK);

        Map<String, Object> result = sPdeleteExcluid.execute(in);
        String status = (String) result.get(SPDeleteExcluid.OUT_STATUS);

        if (!SPCodeEnum.RESULT_OK.isCode(status))
        {
            throw new RulesException(status);
        }
    }

    @Override
    public List<LoadAllExcluid> loadAllExcluid(Long loginEmployPK)
    {

        SqlParameterSource in = new MapSqlParameterSource().addValue(SPLoadAllExcluid.IN_EMPLOY_PK, loginEmployPK);

        Map<String, Object> result = sPLoadAllExcluid.execute(in);
        String status = (String) result.get(SPLoadAllExcluid.OUT_STATUS);

        if (!SPCodeEnum.RESULT_OK.isCode(status))
        {
            throw new RulesException(status);
        }
        List<LoadAllExcluid> list = (List<LoadAllExcluid>) result.get(SPLoadAllExcluid.OUT_CURSOR);
        return list;
    }

}
