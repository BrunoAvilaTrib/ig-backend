
package pe.com.synopsis.imgrabber.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.com.synopsis.imgrabber.beans.dto.LoadEmployConfigDTO;
import pe.com.synopsis.imgrabber.beans.request.LoadEmployConfigRequest;
import pe.com.synopsis.imgrabber.beans.request.UpdateEmployConfigRequest;
import pe.com.synopsis.imgrabber.beans.response.Response;
import pe.com.synopsis.imgrabber.beans.response.Status;
import pe.com.synopsis.imgrabber.business.ConfigBL;
import pe.com.synopsis.imgrabber.enumeration.StatusEnum;
import pe.com.synopsis.imgrabber.exception.RulesException;
import pe.com.synopsis.imgrabber.service.ConfigService;

@Service
public class ConfigServiceImpl implements ConfigService
{

    private static final Logger logger = LoggerFactory.getLogger(ChatServiceImpl.class);

    @Autowired
    private ConfigBL configBL;

    @Override
    public Response<String> updateEmployConfig(UpdateEmployConfigRequest employConfigRequest)
    {

        Response<String> response = new Response<>();

        try
        {

            configBL.updateEmployConfig(employConfigRequest);
            response.setStatus(StatusEnum.STATUS_SUCCESSFULL.create());
        }
        catch (RulesException e)
        {

            logger.error(e.getMessage(), e);
            response.setStatus(new Status(e.getErrorcode(), e.getMessage()));
        }
        catch (Exception e)
        {

            logger.error(e.getMessage(), e);
            response.setStatus(StatusEnum.STATUS_FAIL.create());
        }

        return response;
    }

    @Override
    public Response<LoadEmployConfigDTO> loadEmployConfig(LoadEmployConfigRequest loadConfigRequest)
    {

        Response<LoadEmployConfigDTO> response = new Response<>();

        try
        {

            List<LoadEmployConfigDTO> data = configBL.loadEmployConfig(loadConfigRequest);
            response.setData(data.get(0));
            response.setStatus(StatusEnum.STATUS_SUCCESSFULL.create());

        }
        catch (RulesException e)
        {

            logger.error(e.getMessage(), e);
            response.setStatus(new Status(e.getErrorcode(), e.getMessage()));
        }
        catch (Exception e)
        {

            logger.error(e.getMessage(), e);
            response.setStatus(StatusEnum.STATUS_FAIL.create());
        }

        return response;
    }

}
