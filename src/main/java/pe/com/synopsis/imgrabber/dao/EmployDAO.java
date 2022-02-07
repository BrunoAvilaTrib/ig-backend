
package pe.com.synopsis.imgrabber.dao;

import java.util.List;

import pe.com.synopsis.imgrabber.beans.domain.LoadAllEmploy;
import pe.com.synopsis.imgrabber.beans.domain.LoadAllEmployByRole;
import pe.com.synopsis.imgrabber.beans.domain.LoadEmploy;
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

public interface EmployDAO
{

    public List<LoadAllEmployByRole> loadAllEmployByArea(LoadAreaRequest loadAreaRequest, Long loginEmployFK);

    public List<LoadAllEmployByRole> loadAllSupervisorByArea(LoadAreaRequest loadAreaRequest);

    public List<LoadAllEmployByRole> loadAllOfficerBySupervisor(LoadEmployRequest loadEmployRequest);

    public List<LoadAllEmploy> loadAllEmploy(Long loginEmployPK);

    public List<LoadEmploy> loadRoleEmploy(Long loginEmployPK);

    public List<LoadEmploy> loadEmploy(LoadEmployRequest loadEmployRequest);

    public void addAdminEmploy(AddAdminEmployRequest addAdminEmployRequest, Long loginEmployPK);

    public void addSupervisorEmploy(AddSupervisorEmployRequest addSupervisorEmployRequest, Long loginEmployPK);

    public void addOfficerEmploy(AddOfficerEmployRequest addOfficerEmployRequest, Long loginEmployPK);

    public void updateAdminGlobalPassword(UpdateAdminGlobalPasswordRequest updateAdminGlobalPasswordRequest,
            SecurityToken token);

    public void updateAdminBusinessEmploy(UpdateAdminEmployRequest updateAdminEmployRequest, SecurityToken token);

    public void updateSupervisorEmploy(UpdateSupervisorEmployRequest updateSupervisorEmployRequest, Long loginEmployPK);

    public void updateOfficerEmploy(UpdateOfficerEmployRequest updateOfficerEmployRequest, Long loginEmployPK);

    public void defuseOfficerEmploy(DefuseEmployRequest defuseEmployRequest, Long loginEmployPK);

    public List<LoadAllEmployByRole> loadAllSupervisorForDefuse(LoadEmployRequest loadEmployRequest,
            Long loginEmployPK);

    public void changeSupervisor(DefuseSupervisorRequest defuseSupervisorRequest, Long loginEmployPK);

    public void defuseSupervisorEmploy(Long employPK, Long loginEmployPK);

    public void defuseAdminBusinessEmploy(DefuseEmployRequest defuseEmployRequest, Long loginEmployPK);

}
