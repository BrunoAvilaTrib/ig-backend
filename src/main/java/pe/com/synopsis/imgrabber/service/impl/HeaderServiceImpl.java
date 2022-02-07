
package pe.com.synopsis.imgrabber.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.com.synopsis.imgrabber.beans.dto.HeaderDTO;
import pe.com.synopsis.imgrabber.beans.response.Response;
import pe.com.synopsis.imgrabber.beans.response.Status;
import pe.com.synopsis.imgrabber.business.HeaderBL;
import pe.com.synopsis.imgrabber.enumeration.StatusEnum;
import pe.com.synopsis.imgrabber.exception.RulesException;
import pe.com.synopsis.imgrabber.service.HeaderService;

@Service
public class HeaderServiceImpl implements HeaderService
{

    private static final Logger logger = LoggerFactory.getLogger(HeaderServiceImpl.class);

    @Autowired
    private HeaderBL headerBL;

    @Override
    public Response<List<HeaderDTO>> loadHeader(String email)
    {

        Response<List<HeaderDTO>> response = new Response<>();
        try
        {
            response.setData(headerBL.loadHeader(email));
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
