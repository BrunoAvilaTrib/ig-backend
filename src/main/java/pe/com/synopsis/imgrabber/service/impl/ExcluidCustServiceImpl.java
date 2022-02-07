
package pe.com.synopsis.imgrabber.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.com.synopsis.imgrabber.beans.dto.LoadAllExcluidCustDTO;
import pe.com.synopsis.imgrabber.beans.request.AddExcluidCustRequest;
import pe.com.synopsis.imgrabber.beans.request.DefuseExcluidCustRequest;
import pe.com.synopsis.imgrabber.beans.response.Response;
import pe.com.synopsis.imgrabber.beans.response.Status;
import pe.com.synopsis.imgrabber.business.ExcluidCustBL;
import pe.com.synopsis.imgrabber.enumeration.StatusEnum;
import pe.com.synopsis.imgrabber.exception.RulesException;
import pe.com.synopsis.imgrabber.service.ExcluidCustService;

@Service
public class ExcluidCustServiceImpl implements ExcluidCustService
{

    private static Logger logger = LoggerFactory.getLogger(ExcluidCustServiceImpl.class);

    @Autowired
    private ExcluidCustBL excluidCustBL;

    @Override
    public Response<List<LoadAllExcluidCustDTO>> loadAllExcluidCust(Long loginEmployFK)
    {
        Response<List<LoadAllExcluidCustDTO>> response = new Response<>();

        try
        {
            response.setData(excluidCustBL.loadAllExcluidCust(loginEmployFK));
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
    public Response<String> defuseExcluidCust(DefuseExcluidCustRequest defuseExcluidCustRequest)
    {
        Response<String> response = new Response<>();

        try
        {
            excluidCustBL.defuseExcluidCust(defuseExcluidCustRequest);
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
    public Response<String> addExcluidCust(AddExcluidCustRequest addExcluidCustRequest, Long loginEmployFK)
    {
        Response<String> response = new Response<>();

        try
        {
            excluidCustBL.addExcluidCust(addExcluidCustRequest, loginEmployFK);
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
