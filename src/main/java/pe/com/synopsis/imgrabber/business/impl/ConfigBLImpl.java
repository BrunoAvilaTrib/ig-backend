
package pe.com.synopsis.imgrabber.business.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import pe.com.synopsis.imgrabber.beans.domain.LoadEmployConfig;
import pe.com.synopsis.imgrabber.beans.dto.LoadEmployConfigDTO;
import pe.com.synopsis.imgrabber.beans.request.LoadEmployConfigRequest;
import pe.com.synopsis.imgrabber.beans.request.UpdateEmployConfigRequest;
import pe.com.synopsis.imgrabber.business.ConfigBL;
import pe.com.synopsis.imgrabber.converter.LoadEmployConfigConverter;
import pe.com.synopsis.imgrabber.dao.ConfigDAO;

@Component
public class ConfigBLImpl implements ConfigBL
{

    @Autowired
    private ConfigDAO configDAO;
    @Autowired
    private LoadEmployConfigConverter loadEmployConfigConverter;

    @Override
    public void updateEmployConfig(UpdateEmployConfigRequest employConfigRequest)
    {

        configDAO.updateEmployConfig(employConfigRequest);
    }

    @Override
    public List<LoadEmployConfigDTO> loadEmployConfig(LoadEmployConfigRequest loadConfigRequest)
    {

        List<LoadEmployConfig> resultado = configDAO.loadEmployConfig(loadConfigRequest);

        return loadEmployConfigConverter.convert(resultado);
    }

}
