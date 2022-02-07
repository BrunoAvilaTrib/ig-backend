
package pe.com.synopsis.imgrabber.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.com.synopsis.imgrabber.beans.dto.LoadEmployTrazeDTO;
import pe.com.synopsis.imgrabber.beans.request.AddEmployTrazeRequest;
import pe.com.synopsis.imgrabber.beans.response.Response;
import pe.com.synopsis.imgrabber.beans.response.Status;
import pe.com.synopsis.imgrabber.business.EmployTrazeBL;
import pe.com.synopsis.imgrabber.enumeration.StatusEnum;
import pe.com.synopsis.imgrabber.exception.RulesException;
import pe.com.synopsis.imgrabber.service.EmployTrazeService;

@Service
public class EmployTrazeServiceImpl implements EmployTrazeService
{

    @Autowired
    private EmployTrazeBL traceUserBL;
    private static Logger logger = LoggerFactory.getLogger(EmployTrazeServiceImpl.class);

    @Override
    public Response<List<LoadEmployTrazeDTO>> loadEmployTrace()
    {

        Response<List<LoadEmployTrazeDTO>> response = new Response<>();
        try
        {
            response.setData(traceUserBL.loadEmployTrace());
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
    public Response<String> addEmployTraze(AddEmployTrazeRequest employTrazeRequest, String login)
    {

        Response<String> response = new Response<>();
        try
        {
            traceUserBL.addEmployTraze(employTrazeRequest, login);
            response.setStatus(StatusEnum.STATUS_SUCCESSFULL.create());

        }
        catch (RulesException e)
        {
            logger.error(e.getMessage());
            response.setStatus(new Status(e.getErrorcode(), e.getMessage()));

        }
        catch (Exception e)
        {

            response.setStatus(StatusEnum.STATUS_FAIL.create());
        }

        return response;
    }

}
