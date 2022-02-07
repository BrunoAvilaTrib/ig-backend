
package pe.com.synopsis.imgrabber.business;

import java.util.List;

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
import pe.com.synopsis.imgrabber.security.SecurityToken;

public interface EmployBL
{

    public List<LoadAllEmployByRoleDTO> loadAllEmployByArea(LoadAreaRequest loadAreaRequest, Long loginEmployFK);

    public List<LoadAllEmployByRoleDTO> loadAllSupervisorByArea(LoadAreaRequest loadAreaRequest);

    public List<LoadAllEmployByRoleDTO> loadAllOfficerBySupervisor(LoadEmployRequest loadEmployRequest);

    public List<LoadAllEmployDTO> loadAllEmploy(Long loginEmploPK);

    public List<LoadEmployDTO> loadRoleEmploy(Long loginEmployPK);

    public List<LoadEmployDTO> loadEmploy(LoadEmployRequest LoadEmployRequest);

    public void addAdminEmploy(AddAdminEmployRequest addAdminEmployRequest, Long loginEmployPK);

    public void addSupervisorEmploy(AddSupervisorEmployRequest addSupervisorEmployRequest, Long loginEmployPK);

    public void addOfficerEmploy(AddOfficerEmployRequest addOfficerEmployRequest, Long loginEmployPK);

    public void updateAdminGlobalPassword(UpdateAdminGlobalPasswordRequest updateAdminGlobalPasswordRequest,
            SecurityToken token);

    public void updateAdminBusinessEmploy(UpdateAdminEmployRequest updateAdminEmployRequest, SecurityToken token);

    public void updateSupervisorEmploy(UpdateSupervisorEmployRequest updateSupervisorEmployRequest, Long loginEmployPK);

    public void updateOfficerEmploy(UpdateOfficerEmployRequest updateOfficerEmployRequest, Long loginEmployPK);

    public void defuseOfficerEmploy(DefuseEmployRequest defuseEmployRequest, Long loginEmployPK);

    public List<LoadAllEmployByRoleDTO> loadAllSupervisorForDefuse(LoadEmployRequest loadEmployRequest,
            Long loginEmployPK);

    public void defuseSupervisorEmploy(DefuseSupervisorRequest defuseSupervisorRequest, Long loginEmployPK);

    public void defuseAdminBusinessEmploy(DefuseEmployRequest defuseEmployRequest, Long loginEmployPK);
}
