
package pe.com.synopsis.imgrabber.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import pe.com.synopsis.imgrabber.beans.dto.LoadBySupervisorPrivilegeDTO;
import pe.com.synopsis.imgrabber.beans.dto.LoadPrivilegeDTO;
import pe.com.synopsis.imgrabber.beans.response.Response;
import pe.com.synopsis.imgrabber.beans.response.Status;
import pe.com.synopsis.imgrabber.business.PrivilegesBL;
import pe.com.synopsis.imgrabber.enumeration.StatusEnum;
import pe.com.synopsis.imgrabber.exception.RulesException;
import pe.com.synopsis.imgrabber.service.PrivilegeService;

@Component
public class PrivilegeServiceImpl implements PrivilegeService
{

    private static final Logger logger = LoggerFactory.getLogger(PrivilegeServiceImpl.class);
    @Autowired
    private PrivilegesBL privilegesBL;

    @Override
    public Response<List<LoadBySupervisorPrivilegeDTO>> loadBySupervisorPrivilege(String login)
    {

        Response<List<LoadBySupervisorPrivilegeDTO>> response = new Response<>();

        try
        {
            response.setData(privilegesBL.loadBySupervisorPrivilege(login));
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
    public Response<List<LoadPrivilegeDTO>> loadPrivilege()
    {

        Response<List<LoadPrivilegeDTO>> response = new Response<List<LoadPrivilegeDTO>>();

        try
        {
            response.setData(privilegesBL.loadPrivilege());
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
