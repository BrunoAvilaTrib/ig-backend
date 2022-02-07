
package pe.com.synopsis.imgrabber.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.com.synopsis.imgrabber.beans.dto.LoadAllExcluidEmployDTO;
import pe.com.synopsis.imgrabber.beans.dto.LoadExcluidEmployDTO;
import pe.com.synopsis.imgrabber.beans.request.AddExcluidEmployRequest;
import pe.com.synopsis.imgrabber.beans.request.DefuseExcluidEmployRequest;
import pe.com.synopsis.imgrabber.beans.request.LoadExcluidEmployRequest;
import pe.com.synopsis.imgrabber.beans.request.UpdateExcluidEmployRequest;
import pe.com.synopsis.imgrabber.beans.response.Response;
import pe.com.synopsis.imgrabber.beans.response.Status;
import pe.com.synopsis.imgrabber.business.ExcluidEmployBL;
import pe.com.synopsis.imgrabber.enumeration.StatusEnum;
import pe.com.synopsis.imgrabber.exception.RulesException;
import pe.com.synopsis.imgrabber.service.ExcluidEmployService;

@Service
public class ExcluidEmployServiceImpl implements ExcluidEmployService
{

    private static Logger logger = LoggerFactory.getLogger(ExcluidEmployServiceImpl.class);

    @Autowired
    private ExcluidEmployBL excluidEmployBL;

    @Override
    public Response<String> updateExcluidEmploy(UpdateExcluidEmployRequest updateExcluidEmployRequest)
    {
        Response<String> response = new Response<>();

        try
        {
            excluidEmployBL.updateExcluidEmploy(updateExcluidEmployRequest);
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
    public Response<String> addExcluidEmploy(AddExcluidEmployRequest addExcluidEmployRequest)
    {
        Response<String> response = new Response<>();

        try
        {
            excluidEmployBL.addExcluidEmploy(addExcluidEmployRequest);
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
    public Response<String> defuseExcluidEmploy(DefuseExcluidEmployRequest defuseExcluidEmployRequest)
    {
        Response<String> response = new Response<>();

        try
        {
            excluidEmployBL.defuseExcluidEmploy(defuseExcluidEmployRequest);
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
    public Response<List<LoadAllExcluidEmployDTO>> loadAllExcluidEmploy(Long loginEmployFK)
    {
        Response<List<LoadAllExcluidEmployDTO>> response = new Response<>();

        try
        {
            response.setData(excluidEmployBL.loadAllExcluidEmploy(loginEmployFK));
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
    public Response<LoadExcluidEmployDTO> loadExcluidEmploy(LoadExcluidEmployRequest loadExcluidEmployRequest)
    {
        Response<LoadExcluidEmployDTO> response = new Response<>();

        try
        {
            List<LoadExcluidEmployDTO> lista = excluidEmployBL.loadExcluidEmploy(loadExcluidEmployRequest);

            response.setData(lista.get(0));
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
