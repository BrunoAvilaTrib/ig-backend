
package pe.com.synopsis.imgrabber.dao.impl;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Component;

import pe.com.synopsis.imgrabber.beans.domain.LoadEmployConfig;
import pe.com.synopsis.imgrabber.beans.request.LoadEmployConfigRequest;
import pe.com.synopsis.imgrabber.beans.request.UpdateEmployConfigRequest;
import pe.com.synopsis.imgrabber.dao.ConfigDAO;
import pe.com.synopsis.imgrabber.dao.sp.SPLoadEmployConfig;
import pe.com.synopsis.imgrabber.dao.sp.SPUpdateEmployConfig;
import pe.com.synopsis.imgrabber.enumeration.SPCodeEnum;
import pe.com.synopsis.imgrabber.exception.RulesException;

@SuppressWarnings("unchecked")
@Component
public class ConfigDAOImpl implements ConfigDAO
{

    @SuppressWarnings("unused")
    private static final Logger logger = LoggerFactory.getLogger(ConfigDAOImpl.class);

    @Autowired
    private SPUpdateEmployConfig sPUpdateConfig;
    @Autowired
    private SPLoadEmployConfig sPLoadConfig;

    @Override
    public void updateEmployConfig(UpdateEmployConfigRequest employConfig)
    {

        SqlParameterSource in = new MapSqlParameterSource()
                .addValue(SPUpdateEmployConfig.SP_IN_CONFIG_PK, employConfig.getConfigPk())
                .addValue(SPUpdateEmployConfig.SP_IN_EMPLOY_PK, employConfig.getEmployPk())
                .addValue(SPUpdateEmployConfig.SP_IN_STATE, employConfig.getState());

        Map<String, Object> result = sPUpdateConfig.execute(in);
        String status = (String) result.get(SPUpdateEmployConfig.OUT_STATUS);
        if (!SPCodeEnum.RESULT_OK.isCode(status))
        {
            throw new RulesException(status);
        }

    }

    @Override
    public List<LoadEmployConfig> loadEmployConfig(LoadEmployConfigRequest loadConfigRequest)
    {

        SqlParameterSource in = new MapSqlParameterSource().addValue(SPLoadEmployConfig.IN_EMPLOY_PK,
                loadConfigRequest.getEmployPk());
        Map<String, Object> result = sPLoadConfig.execute(in);
        String status = (String) result.get(SPLoadEmployConfig.OUT_STATUS);

        if (!SPCodeEnum.RESULT_OK.isCode(status))
        {
            throw new RulesException(status);
        }

        List<LoadEmployConfig> lista = (List<LoadEmployConfig>) result.get(SPLoadEmployConfig.OUT_CURSOR);

        return lista;
    }

}
