
package pe.com.synopsis.imgrabber.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.com.synopsis.imgrabber.beans.dto.LoadAllExcluidDTO;
import pe.com.synopsis.imgrabber.beans.request.LoadAllExcluidRequest;
import pe.com.synopsis.imgrabber.beans.response.Response;
import pe.com.synopsis.imgrabber.beans.response.Status;
import pe.com.synopsis.imgrabber.business.ExcluidBL;
import pe.com.synopsis.imgrabber.enumeration.StatusEnum;
import pe.com.synopsis.imgrabber.exception.RulesException;
import pe.com.synopsis.imgrabber.service.ExcluidService;

@Service
public class ExcluidServiceImpl implements ExcluidService
{

    private static final Logger logger = LoggerFactory.getLogger(ChatServiceImpl.class);

    @Autowired
    ExcluidBL excluidbl;

    @Override
    public Response<LoadAllExcluidDTO> loadAllExcluid(LoadAllExcluidRequest loadAllExcluidRequest)
    {

        Response<LoadAllExcluidDTO> response = new Response<>();
        try
        {
            List<LoadAllExcluidDTO> list = excluidbl.loadAllExcluid(loadAllExcluidRequest);
            response.setData(list.get(0));

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
