
package pe.com.synopsis.imgrabber.business.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import pe.com.synopsis.imgrabber.beans.domain.LoadAllEmploy;
import pe.com.synopsis.imgrabber.beans.domain.LoadAllEmployByRole;
import pe.com.synopsis.imgrabber.beans.domain.LoadEmploy;
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
import pe.com.synopsis.imgrabber.business.EmployBL;
import pe.com.synopsis.imgrabber.converter.LoadAllEmployByRoleConverter;
import pe.com.synopsis.imgrabber.converter.LoadAllEmploysConverter;
import pe.com.synopsis.imgrabber.converter.LoadEmployConverter;
import pe.com.synopsis.imgrabber.dao.EmployDAO;
import pe.com.synopsis.imgrabber.security.SecurityToken;

@Component
public class EmployBLImpl implements EmployBL
{

    @Autowired
    private EmployDAO employDAO;

    @Autowired
    private LoadAllEmployByRoleConverter loadAllEmployByRoleConverter;

    @Autowired
    private LoadAllEmploysConverter loadAllEmploysConverter;

    @Autowired
    private LoadEmployConverter loadEmployConverter;

    @Override
    public List<LoadAllEmployByRoleDTO> loadAllEmployByArea(LoadAreaRequest loadAreaRequest, Long loginEmployFK)
    {
        List<LoadAllEmployByRole> resultado = employDAO.loadAllEmployByArea(loadAreaRequest, loginEmployFK);
        return loadAllEmployByRoleConverter.convert(resultado);
    }

    @Override
    public List<LoadAllEmployByRoleDTO> loadAllSupervisorByArea(LoadAreaRequest loadAreaRequest)
    {
        List<LoadAllEmployByRole> resultado = employDAO.loadAllSupervisorByArea(loadAreaRequest);
        return loadAllEmployByRoleConverter.convert(resultado);
    }

    @Override
    public List<LoadAllEmployByRoleDTO> loadAllOfficerBySupervisor(LoadEmployRequest loadEmployRequest)
    {
        List<LoadAllEmployByRole> resultado = employDAO.loadAllOfficerBySupervisor(loadEmployRequest);
        return loadAllEmployByRoleConverter.convert(resultado);
    }

    @Override
    public List<LoadAllEmployDTO> loadAllEmploy(Long loginEmploPK)
    {
        List<LoadAllEmploy> employees = employDAO.loadAllEmploy(loginEmploPK);
        return loadAllEmploysConverter.convert(employees);
    }

    @Override
    public List<LoadEmployDTO> loadRoleEmploy(Long loginEmploPK)
    {
        List<LoadEmploy> resultado = employDAO.loadRoleEmploy(loginEmploPK);
        return loadEmployConverter.convert(resultado);
    }

    @Override
    public List<LoadEmployDTO> loadEmploy(LoadEmployRequest LoadEmployRequest)
    {
        List<LoadEmploy> response = employDAO.loadEmploy(LoadEmployRequest);
        return loadEmployConverter.convert(response);
    }

    @Override
    public void addAdminEmploy(AddAdminEmployRequest addAdminEmployRequest, Long loginEmployPK)
    {
        employDAO.addAdminEmploy(addAdminEmployRequest, loginEmployPK);
    }

    @Override
    public void addSupervisorEmploy(AddSupervisorEmployRequest addSupervisorEmployRequest, Long loginEmployPK)
    {
        employDAO.addSupervisorEmploy(addSupervisorEmployRequest, loginEmployPK);
    }

    @Override
    public void addOfficerEmploy(AddOfficerEmployRequest addOfficerEmployRequest, Long loginEmployPK)
    {
        employDAO.addOfficerEmploy(addOfficerEmployRequest, loginEmployPK);
    }

    @Override
    public void updateAdminGlobalPassword(UpdateAdminGlobalPasswordRequest updateAdminGlobalPasswordRequest,
            SecurityToken token)
    {
        employDAO.updateAdminGlobalPassword(updateAdminGlobalPasswordRequest, token);
    }

    @Override
    public void updateAdminBusinessEmploy(UpdateAdminEmployRequest updateAdminEmployRequest, SecurityToken token)
    {
        employDAO.updateAdminBusinessEmploy(updateAdminEmployRequest, token);
    }

    @Override
    public void updateSupervisorEmploy(UpdateSupervisorEmployRequest updateSupervisorEmployRequest, Long loginEmployPK)
    {
        employDAO.updateSupervisorEmploy(updateSupervisorEmployRequest, loginEmployPK);
    }

    @Override
    public void updateOfficerEmploy(UpdateOfficerEmployRequest updateOfficerEmployRequest, Long loginEmployPK)
    {
        employDAO.updateOfficerEmploy(updateOfficerEmployRequest, loginEmployPK);
    }

    @Override
    public void defuseOfficerEmploy(DefuseEmployRequest defuseEmployRequest, Long loginEmployPK)
    {
        employDAO.defuseOfficerEmploy(defuseEmployRequest, loginEmployPK);
    }

    @Override
    public List<LoadAllEmployByRoleDTO> loadAllSupervisorForDefuse(LoadEmployRequest loadEmployRequest,
            Long loginEmployPK)
    {
        List<LoadAllEmployByRole> resultado = employDAO.loadAllSupervisorForDefuse(loadEmployRequest, loginEmployPK);
        return loadAllEmployByRoleConverter.convert(resultado);
    }

    @Override
    public void defuseSupervisorEmploy(DefuseSupervisorRequest defuseSupervisorRequest, Long loginEmployPK)
    {
        employDAO.changeSupervisor(defuseSupervisorRequest, loginEmployPK);
    }

    @Override
    public void defuseAdminBusinessEmploy(DefuseEmployRequest defuseEmployRequest, Long loginEmployPK)
    {
        employDAO.defuseAdminBusinessEmploy(defuseEmployRequest, loginEmployPK);
    }
}
