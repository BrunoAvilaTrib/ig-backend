
package pe.com.synopsis.imgrabber.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.com.synopsis.imgrabber.beans.dto.LoadRoleDTO;
import pe.com.synopsis.imgrabber.beans.response.Response;
import pe.com.synopsis.imgrabber.beans.response.Status;
import pe.com.synopsis.imgrabber.business.RoleBL;
import pe.com.synopsis.imgrabber.enumeration.StatusEnum;
import pe.com.synopsis.imgrabber.exception.RulesException;
import pe.com.synopsis.imgrabber.service.RoleService;

@Service
public class RoleServiceImpl implements RoleService
{

    private static final Logger logger = LoggerFactory.getLogger(RoleServiceImpl.class);

    @Autowired
    private RoleBL roleBL;

    @Override
    public Response<List<LoadRoleDTO>> loadRole(Long loginEmployPK)
    {
        Response<List<LoadRoleDTO>> response = new Response<>();

        try
        {
            List<LoadRoleDTO> data = roleBL.loadRole(loginEmployPK);
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

}
