
package pe.com.synopsis.imgrabber.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.com.synopsis.imgrabber.beans.dto.LoadAllEmployByRoleDTO;
import pe.com.synopsis.imgrabber.beans.dto.LoadAllEmployDTO;
import pe.com.synopsis.imgrabber.beans.dto.LoadEmployDTO;
import pe.com.synopsis.imgrabber.beans.request.AddAdminEmployRequest;
import pe.com.synopsis.imgrabber.beans.request.AddOfficerEmployRequest;
import pe.com.synopsis.imgrabber.beans.request.AddSupervisorEmployRequest;
import pe.com.synopsis.imgrabber.beans.request.DefuseEmployRequest;
import pe.com.synopsis.imgrabber.beans.request.DefuseSupervisorRequest;
import pe.com.synopsis.imgrabber.beans.request.LoadAreaRequest;
import pe.com.synopsis.imgrabber.beans.request.LoadEmployRequest;
import pe.com.synopsis.imgrabber.beans.request.UpdateAdminEmployRequest;
import pe.com.synopsis.imgrabber.beans.request.UpdateAdminGlobalPasswordRequest;
import pe.com.synopsis.imgrabber.beans.request.UpdateOfficerEmployRequest;
import pe.com.synopsis.imgrabber.beans.request.UpdateSupervisorEmployRequest;
import pe.com.synopsis.imgrabber.beans.response.Response;
import pe.com.synopsis.imgrabber.beans.response.Status;
import pe.com.synopsis.imgrabber.business.EmployBL;
import pe.com.synopsis.imgrabber.enumeration.StatusEnum;
import pe.com.synopsis.imgrabber.exception.RulesException;
import pe.com.synopsis.imgrabber.security.SecurityToken;
import pe.com.synopsis.imgrabber.service.EmployService;

@Service
public class EmployServiceImpl implements EmployService
{

    private static final Logger Logger = LoggerFactory.getLogger(EmployServiceImpl.class);
    @Autowired
    private EmployBL employBL;

    @Override
    public Response<List<LoadAllEmployByRoleDTO>> loadAllEmployByArea(LoadAreaRequest loadAreaRequest,
            Long loginEmployFK)
    {

        Response<List<LoadAllEmployByRoleDTO>> response = new Response<>();

        try
        {
            List<LoadAllEmployByRoleDTO> lista = employBL.loadAllEmployByArea(loadAreaRequest, loginEmployFK);
            response.setData(lista);
            response.setStatus(StatusEnum.STATUS_SUCCESSFULL.create());

        }
        catch (RulesException e)
        {
            Logger.error(e.getMessage(), e);
            response.setStatus(new Status(e.getErrorcode(), e.getMessage()));

        }
        catch (Exception e)
        {
            Logger.error(e.getMessage(), e);
            response.setStatus(StatusEnum.STATUS_FAIL.create());
        }
        return response;
    }

    @Override
    public Response<List<LoadAllEmployByRoleDTO>> loadAllSupervisorByArea(LoadAreaRequest loadAreaRequest)
    {

        Response<List<LoadAllEmployByRoleDTO>> response = new Response<>();

        try
        {
            List<LoadAllEmployByRoleDTO> lista = employBL.loadAllSupervisorByArea(loadAreaRequest);
            response.setData(lista);
            response.setStatus(StatusEnum.STATUS_SUCCESSFULL.create());

        }
        catch (RulesException e)
        {
            Logger.error(e.getMessage(), e);
            response.setStatus(new Status(e.getErrorcode(), e.getMessage()));

        }
        catch (Exception e)
        {
            Logger.error(e.getMessage(), e);
            response.setStatus(StatusEnum.STATUS_FAIL.create());
        }
        return response;
    }

    @Override
    public Response<List<LoadAllEmployByRoleDTO>> loadAllOfficerBySupervisor(LoadEmployRequest loadEmployRequest)
    {

        Response<List<LoadAllEmployByRoleDTO>> response = new Response<>();

        try
        {
            List<LoadAllEmployByRoleDTO> lista = employBL.loadAllOfficerBySupervisor(loadEmployRequest);
            response.setData(lista);
            response.setStatus(StatusEnum.STATUS_SUCCESSFULL.create());

        }
        catch (RulesException e)
        {
            Logger.error(e.getMessage(), e);
            response.setStatus(new Status(e.getErrorcode(), e.getMessage()));

        }
        catch (Exception e)
        {
            Logger.error(e.getMessage(), e);
            response.setStatus(StatusEnum.STATUS_FAIL.create());
        }
        return response;
    }

    @Override
    public Response<List<LoadAllEmployDTO>> loadAllEmploy(Long loginEmployPK)
    {

        Response<List<LoadAllEmployDTO>> response = new Response<>();
        try
        {

            List<LoadAllEmployDTO> lista = employBL.loadAllEmploy(loginEmployPK);
            response.setData(lista);
            response.setStatus(StatusEnum.STATUS_SUCCESSFULL.create());
        }
        catch (RulesException e)
        {
            Logger.error(e.getMessage(), e);
            response.setStatus(new Status(e.getErrorcode(), e.getMessage()));
        }
        catch (Exception e)
        {
            Logger.error(e.getMessage(), e);
            response.setStatus(StatusEnum.STATUS_FAIL.create());
        }
        return response;
    }

    @Override
    public Response<LoadEmployDTO> loadRoleEmploy(Long loginEmployPK)
    {

        Response<LoadEmployDTO> response = new Response<>();
        try
        {

            List<LoadEmployDTO> lista = employBL.loadRoleEmploy(loginEmployPK);
            response.setData(lista.get(0));
            response.setStatus(StatusEnum.STATUS_SUCCESSFULL.create());
        }
        catch (RulesException e)
        {
            Logger.error(e.getMessage(), e);
            response.setStatus(new Status(e.getErrorcode(), e.getMessage()));
        }
        catch (Exception e)
        {
            Logger.error(e.getMessage(), e);
            response.setStatus(StatusEnum.STATUS_FAIL.create());
        }
        return response;
    }

    @Override
    public Response<LoadEmployDTO> loadEmploy(LoadEmployRequest loadEmployRequest)
    {
        Response<LoadEmployDTO> response = new Response<>();

        try
        {
            List<LoadEmployDTO> lista = employBL.loadEmploy(loadEmployRequest);

            response.setData(lista.get(0));
            response.setStatus(StatusEnum.STATUS_SUCCESSFULL.create());

        }
        catch (RulesException e)
        {
            Logger.error(e.getMessage(), e);
            response.setStatus(new Status(e.getErrorcode(), e.getMessage()));

        }
        catch (Exception e)
        {
            Logger.error(e.getMessage(), e);
            response.setStatus(StatusEnum.STATUS_FAIL.create());
        }
        return response;
    }

    @Override
    public Response<String> addAdminEmploy(AddAdminEmployRequest addAdminEmployRequest, Long loginEmployPK)
    {
        Response<String> response = new Response<>();

        try
        {
            employBL.addAdminEmploy(addAdminEmployRequest, loginEmployPK);
            response.setStatus(StatusEnum.STATUS_SUCCESSFULL.create());
        }
        catch (RulesException e)
        {
            Logger.error(e.getMessage(), e);
            response.setStatus(new Status(e.getErrorcode(), e.getMessage()));
        }
        catch (Exception e)
        {
            Logger.error(e.getMessage(), e);
            response.setStatus(StatusEnum.STATUS_FAIL.create());
        }
        return response;
    }

    @Override
    public Response<String> addSupervisorEmploy(AddSupervisorEmployRequest addSupervisorEmployRequest,
            Long loginEmployPK)
    {
        Response<String> response = new Response<>();

        try
        {
            employBL.addSupervisorEmploy(addSupervisorEmployRequest, loginEmployPK);
            response.setStatus(StatusEnum.STATUS_SUCCESSFULL.create());
        }
        catch (RulesException e)
        {
            Logger.error(e.getMessage(), e);
            response.setStatus(new Status(e.getErrorcode(), e.getMessage()));
        }
        catch (Exception e)
        {
            Logger.error(e.getMessage(), e);
            response.setStatus(StatusEnum.STATUS_FAIL.create());
        }
        return response;
    }

    @Override
    public Response<String> addOfficerEmploy(AddOfficerEmployRequest addOfficerEmployRequest, Long loginEmployPK)
    {
        Response<String> response = new Response<>();

        try
        {
            employBL.addOfficerEmploy(addOfficerEmployRequest, loginEmployPK);
            response.setStatus(StatusEnum.STATUS_SUCCESSFULL.create());
        }
        catch (RulesException e)
        {
            
            response.setStatus(new Status(e.getErrorcode(), e.getMessage()));
        }
        catch (Exception e)
        {
          
            response.setStatus(StatusEnum.STATUS_FAIL.create());
        }
        return response;
    }

    @Override
    public Response<String> updateAdminGlobalPassword(UpdateAdminGlobalPasswordRequest updateAdminGlobalPasswordRequest,
            SecurityToken token)
    {
        Response<String> response = new Response<>();

        try
        {
            employBL.updateAdminGlobalPassword(updateAdminGlobalPasswordRequest, token);
            response.setStatus(StatusEnum.STATUS_SUCCESSFULL.create());
        }
        catch (RulesException e)
        {
            Logger.error(e.getMessage(), e);
            response.setStatus(new Status(e.getErrorcode(), e.getMessage()));
        }
        catch (Exception e)
        {
            Logger.error(e.getMessage(), e);
            response.setStatus(StatusEnum.STATUS_FAIL.create());
        }
        return response;
    }

    @Override
    public Response<String> updateAdminBusinessEmploy(UpdateAdminEmployRequest updateAdminEmployRequest,
            SecurityToken token)
    {
        Response<String> response = new Response<>();

        try
        {
            employBL.updateAdminBusinessEmploy(updateAdminEmployRequest, token);
            response.setStatus(StatusEnum.STATUS_SUCCESSFULL.create());
        }
        catch (RulesException e)
        {
            Logger.error(e.getMessage(), e);
            response.setStatus(new Status(e.getErrorcode(), e.getMessage()));
        }
        catch (Exception e)
        {
            Logger.error(e.getMessage(), e);
            response.setStatus(StatusEnum.STATUS_FAIL.create());
        }
        return response;
    }

    @Override
    public Response<String> updateSupervisorEmploy(UpdateSupervisorEmployRequest updateSupervisorEmployRequest,
            Long loginEmployPK)
    {
        Response<String> response = new Response<>();

        try
        {
            employBL.updateSupervisorEmploy(updateSupervisorEmployRequest, loginEmployPK);
            response.setStatus(StatusEnum.STATUS_SUCCESSFULL.create());
        }
        catch (RulesException e)
        {
            Logger.error(e.getMessage(), e);
            response.setStatus(new Status(e.getErrorcode(), e.getMessage()));
        }
        catch (Exception e)
        {
            Logger.error(e.getMessage(), e);
            response.setStatus(StatusEnum.STATUS_FAIL.create());
        }
        return response;
    }

    @Override
    public Response<String> updateOfficerEmploy(UpdateOfficerEmployRequest updateOfficerEmployRequest,
            Long loginEmployPK)
    {
        Response<String> response = new Response<>();

        try
        {
            employBL.updateOfficerEmploy(updateOfficerEmployRequest, loginEmployPK);
            response.setStatus(StatusEnum.STATUS_SUCCESSFULL.create());
        }
        catch (RulesException e)
        {
            
            response.setStatus(new Status(e.getErrorcode(), e.getMessage()));
        }
        catch (Exception e)
        {
            
            response.setStatus(StatusEnum.STATUS_FAIL.create());
        }
        return response;
    }

    @Override
    public Response<String> defuseOfficerEmploy(DefuseEmployRequest defuseEmployRequest, Long loginEmployPK)
    {
        Response<String> response = new Response<>();

        try
        {
            employBL.defuseOfficerEmploy(defuseEmployRequest, loginEmployPK);
            response.setStatus(StatusEnum.STATUS_SUCCESSFULL.create());
        }
        catch (RulesException e)
        {
            Logger.error(e.getMessage(), e);
            response.setStatus(new Status(e.getErrorcode(), e.getMessage()));
        }
        catch (Exception e)
        {
            Logger.error(e.getMessage(), e);
            response.setStatus(StatusEnum.STATUS_FAIL.create());
        }
        return response;
    }

    @Override
    public Response<List<LoadAllEmployByRoleDTO>> loadAllSupervisorForDefuse(LoadEmployRequest loadEmployRequest,
            Long loginEmployPK)
    {

        Response<List<LoadAllEmployByRoleDTO>> response = new Response<>();

        try
        {
            List<LoadAllEmployByRoleDTO> lista = employBL.loadAllSupervisorForDefuse(loadEmployRequest, loginEmployPK);
            response.setData(lista);
            response.setStatus(StatusEnum.STATUS_SUCCESSFULL.create());

        }
        catch (RulesException e)
        {
            Logger.error(e.getMessage(), e);
            response.setStatus(new Status(e.getErrorcode(), e.getMessage()));

        }
        catch (Exception e)
        {
            Logger.error(e.getMessage(), e);
            response.setStatus(StatusEnum.STATUS_FAIL.create());
        }
        return response;
    }

    @Override
    public Response<String> defuseSupervisorEmploy(DefuseSupervisorRequest defuseSupervisorRequest, Long loginEmployPK)
    {
        Response<String> response = new Response<>();

        try
        {
            employBL.defuseSupervisorEmploy(defuseSupervisorRequest, loginEmployPK);
            response.setStatus(StatusEnum.STATUS_SUCCESSFULL.create());
        }
        catch (RulesException e)
        {
            Logger.error(e.getMessage(), e);
            response.setStatus(new Status(e.getErrorcode(), e.getMessage()));
        }
        catch (Exception e)
        {
            Logger.error(e.getMessage(), e);
            response.setStatus(StatusEnum.STATUS_FAIL.create());
        }
        return response;
    }

    @Override
    public Response<String> defuseAdminBusinessEmploy(DefuseEmployRequest defuseEmployRequest, Long loginEmployPK)
    {
        Response<String> response = new Response<>();

        try
        {
            employBL.defuseAdminBusinessEmploy(defuseEmployRequest, loginEmployPK);
            response.setStatus(StatusEnum.STATUS_SUCCESSFULL.create());
        }
        catch (RulesException e)
        {
            Logger.error(e.getMessage(), e);
            response.setStatus(new Status(e.getErrorcode(), e.getMessage()));
        }
        catch (Exception e)
        {
            Logger.error(e.getMessage(), e);
            response.setStatus(StatusEnum.STATUS_FAIL.create());
        }
        return response;
    }
}
