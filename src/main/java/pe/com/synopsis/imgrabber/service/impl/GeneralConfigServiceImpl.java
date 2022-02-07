
package pe.com.synopsis.imgrabber.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.com.synopsis.imgrabber.beans.dto.LoadGeneralConfigDTO;
import pe.com.synopsis.imgrabber.beans.request.UpdateGeneralConfigRequest;
import pe.com.synopsis.imgrabber.beans.response.Response;
import pe.com.synopsis.imgrabber.beans.response.Status;
import pe.com.synopsis.imgrabber.business.GeneralConfigBL;
import pe.com.synopsis.imgrabber.enumeration.StatusEnum;
import pe.com.synopsis.imgrabber.exception.RulesException;
import pe.com.synopsis.imgrabber.service.GeneralConfigService;

@Service
public class GeneralConfigServiceImpl implements GeneralConfigService
{

    private static final Logger logger = LoggerFactory.getLogger(GeneralConfigServiceImpl.class);
    @Autowired
    GeneralConfigBL generalConfigBL;

    @Override
    public Response<List<LoadGeneralConfigDTO>> loadGeneralConfig()
    {
        Response<List<LoadGeneralConfigDTO>> response = new Response<>();

        try
        {

            List<LoadGeneralConfigDTO> data = generalConfigBL.loadGeneralConfig();
            response.setData(data);
            response.setStatus(StatusEnum.STATUS_SUCCESSFULL.create());

        }
        catch (RulesException ex)
        {
            logger.error(ex.getMessage(), ex);
            response.setStatus(new Status(ex.getErrorcode(), ex.getMessage()));
        }
        catch (Exception ex)
        {
            logger.error(ex.getMessage(), ex);
            response.setStatus(StatusEnum.STATUS_FAIL.create());
        }

        return response;

    }

    @Override
    public Response<String> updateGeneralConfig(UpdateGeneralConfigRequest generalConfig)
    {
        Response<String> response = new Response<>();

        try
        {
            generalConfigBL.updateGeneralConfig(generalConfig);
            response.setStatus(StatusEnum.STATUS_SUCCESSFULL.create());

        }
        catch (RulesException ex)
        {
            logger.error(ex.getMessage(), ex);
            response.setStatus(new Status(ex.getErrorcode(), ex.getMessage()));
        }
        catch (Exception ex)
        {
            logger.error(ex.getMessage(), ex);
            response.setStatus(StatusEnum.STATUS_FAIL.create());
        }

        return response;
    }
}
