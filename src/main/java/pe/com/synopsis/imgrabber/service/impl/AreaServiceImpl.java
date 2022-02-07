
package pe.com.synopsis.imgrabber.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.com.synopsis.imgrabber.beans.dto.LoadAllAreaByRoleDTO;
import pe.com.synopsis.imgrabber.beans.dto.LoadAllAreaDTO;
import pe.com.synopsis.imgrabber.beans.dto.LoadAreaDTO;
import pe.com.synopsis.imgrabber.beans.request.AddAreaRequest;
import pe.com.synopsis.imgrabber.beans.request.DefuseAreaRequest;
import pe.com.synopsis.imgrabber.beans.request.LoadAreaRequest;
import pe.com.synopsis.imgrabber.beans.request.UpdateAreaRequest;
import pe.com.synopsis.imgrabber.beans.response.Response;
import pe.com.synopsis.imgrabber.beans.response.Status;
import pe.com.synopsis.imgrabber.business.AreaBL;
import pe.com.synopsis.imgrabber.enumeration.StatusEnum;
import pe.com.synopsis.imgrabber.exception.RulesException;
import pe.com.synopsis.imgrabber.service.AreaService;

@Service
public class AreaServiceImpl implements AreaService
{

    private static final Logger logger = LoggerFactory.getLogger(ChatServiceImpl.class);

    @Autowired
    private AreaBL areaBL;

    @Override
    public Response<String> updateArea(UpdateAreaRequest updateAreaRequest)
    {

        Response<String> response = new Response<>();

        try
        {
            areaBL.updateArea(updateAreaRequest);
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
    public Response<String> addArea(AddAreaRequest addAreaRequest)
    {
        Response<String> response = new Response<>();

        try
        {
            areaBL.addArea(addAreaRequest);
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
    public Response<String> defuseArea(DefuseAreaRequest defuseAreaRequest)
    {
        Response<String> response = new Response<>();

        try
        {
            areaBL.defuseArea(defuseAreaRequest);
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
    public Response<List<LoadAllAreaDTO>> loadAllArea(Long loginEmployFK)
    {
        Response<List<LoadAllAreaDTO>> response = new Response<>();

        try
        {
            List<LoadAllAreaDTO> data = areaBL.loadAllArea(loginEmployFK);
            response.setData(data);
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
    public Response<List<LoadAllAreaByRoleDTO>> loadAllAreaByRole(Long loginEmployFK)
    {
        Response<List<LoadAllAreaByRoleDTO>> response = new Response<>();

        try
        {
            List<LoadAllAreaByRoleDTO> data = areaBL.loadAllAreaByRole(loginEmployFK);
            response.setData(data);
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
    public Response<LoadAreaDTO> loadArea(LoadAreaRequest loadAreaRequest)
    {
        Response<LoadAreaDTO> response = new Response<>();

        try
        {
            List<LoadAreaDTO> data = areaBL.loadArea(loadAreaRequest);
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
