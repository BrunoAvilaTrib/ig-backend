
package pe.com.synopsis.imgrabber.dao.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Component;

import pe.com.synopsis.imgrabber.beans.domain.LoadGeneralConfig;
import pe.com.synopsis.imgrabber.beans.request.UpdateGeneralConfigRequest;
import pe.com.synopsis.imgrabber.dao.GeneralConfigDAO;
import pe.com.synopsis.imgrabber.dao.sp.SPLoadGeneralConfig;
import pe.com.synopsis.imgrabber.dao.sp.SPUpdateGeneralConfig;
import pe.com.synopsis.imgrabber.enumeration.SPCodeEnum;
import pe.com.synopsis.imgrabber.exception.RulesException;

@SuppressWarnings("unchecked")
@Component
public class GeneralConfigDAOImpl implements GeneralConfigDAO
{

    @Autowired
    private SPLoadGeneralConfig sPLoadGeneralConfig;
    @Autowired
    private SPUpdateGeneralConfig sPUpdateGeneralConfig;

    @Override
    public List<LoadGeneralConfig> loadGeneralConfig()
    {
        SqlParameterSource in = new MapSqlParameterSource();
        Map<String, Object> result = sPLoadGeneralConfig.execute(in);
        String status = (String) result.get(SPLoadGeneralConfig.OUT_STATUS);
        if (!SPCodeEnum.RESULT_OK.isCode(status))
        {

            throw new RulesException(status);

        }
        List<LoadGeneralConfig> genconfig = (List<LoadGeneralConfig>) result.get(SPLoadGeneralConfig.OUT_CURSOR);
        return genconfig;

    }

    @Override
    public void updateGenConfig(UpdateGeneralConfigRequest updateGenConfigRequest)
    {
        SqlParameterSource in = new MapSqlParameterSource()
                .addValue(SPUpdateGeneralConfig.IN_GENERAL_CONFIG_PK, updateGenConfigRequest.getGeneralConfigPk())
                .addValue(SPUpdateGeneralConfig.IN_GENERAL_CONFIG_STATE,
                        updateGenConfigRequest.getInGeneralConfigState());
        Map<String, Object> result = sPUpdateGeneralConfig.execute(in);

        String status = (String) result.get(SPUpdateGeneralConfig.OUT_STATUS);

        if (!SPCodeEnum.RESULT_OK.isCode(status))
        {
            throw new RulesException(status);
        }

    }

}
