
package pe.com.synopsis.imgrabber.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.com.synopsis.imgrabber.beans.dto.LoadAllBusinessByRoleDTO;
import pe.com.synopsis.imgrabber.beans.dto.LoadAllBusinessDTO;
import pe.com.synopsis.imgrabber.beans.dto.LoadBusinessDTO;
import pe.com.synopsis.imgrabber.beans.request.AddBusinessRequest;
import pe.com.synopsis.imgrabber.beans.request.LoadBusinessRequest;
import pe.com.synopsis.imgrabber.beans.request.UpdateBusinessRequest;
import pe.com.synopsis.imgrabber.beans.response.Response;
import pe.com.synopsis.imgrabber.beans.response.Status;
import pe.com.synopsis.imgrabber.business.BusinessBL;
import pe.com.synopsis.imgrabber.enumeration.StatusEnum;
import pe.com.synopsis.imgrabber.exception.RulesException;
import pe.com.synopsis.imgrabber.service.BusinessService;

@Service
public class BusinessServiceImpl implements BusinessService
{

    private static final Logger logger = LoggerFactory.getLogger(BusinessServiceImpl.class);
    @Autowired
    private BusinessBL businessBL;

    @Override
    public Response<String> updateBusiness(UpdateBusinessRequest updateBusinessRequest)
    {

        Response<String> response = new Response<>();

        try
        {
            businessBL.updateBusiness(updateBusinessRequest);
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
    public Response<String> addBusiness(AddBusinessRequest addBusinessRequest)
    {
        Response<String> response = new Response<>();

        try
        {
            businessBL.addBusiness(addBusinessRequest);
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
    public Response<List<LoadAllBusinessByRoleDTO>> loadAllBusinessByRole(Long loginEmployFK)
    {
        Response<List<LoadAllBusinessByRoleDTO>> response = new Response<>();

        try
        {
            List<LoadAllBusinessByRoleDTO> data = businessBL.loadAllBusinessByRol(loginEmployFK);
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
    public Response<List<LoadAllBusinessDTO>> loadAllBusiness()
    {
        Response<List<LoadAllBusinessDTO>> response = new Response<>();

        try
        {
            List<LoadAllBusinessDTO> data = businessBL.loadAllBusiness();
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
    public Response<LoadBusinessDTO> loadBusiness(LoadBusinessRequest loadBusinessRequest)
    {
        Response<LoadBusinessDTO> response = new Response<>();

        try
        {
            List<LoadBusinessDTO> data = businessBL.loadBusiness(loadBusinessRequest);
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
