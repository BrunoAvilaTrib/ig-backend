
package pe.com.synopsis.imgrabber.business.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import pe.com.synopsis.imgrabber.beans.domain.LoadGeneralConfig;
import pe.com.synopsis.imgrabber.beans.dto.LoadGeneralConfigDTO;
import pe.com.synopsis.imgrabber.beans.request.UpdateGeneralConfigRequest;
import pe.com.synopsis.imgrabber.business.GeneralConfigBL;
import pe.com.synopsis.imgrabber.converter.LoadGeneralConfigConverter;
import pe.com.synopsis.imgrabber.dao.GeneralConfigDAO;

@Component
public class GeneralConfigImpl implements GeneralConfigBL
{

    @Autowired
    GeneralConfigDAO generalConfigDAO;
    @Autowired
    LoadGeneralConfigConverter loadGeneralConfigConverter;

    @Override
    public List<LoadGeneralConfigDTO> loadGeneralConfig()
    {

        List<LoadGeneralConfig> result = generalConfigDAO.loadGeneralConfig();
        return loadGeneralConfigConverter.convert(result);
    }

    @Override
    public void updateGeneralConfig(UpdateGeneralConfigRequest updateGenConfigRequest)
    {

        generalConfigDAO.updateGenConfig(updateGenConfigRequest);
    }

}
