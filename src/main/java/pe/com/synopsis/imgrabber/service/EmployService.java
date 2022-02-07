
package pe.com.synopsis.imgrabber.service;

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
import pe.com.synopsis.imgrabber.beans.response.Response;
import pe.com.synopsis.imgrabber.security.SecurityToken;

public interface EmployService
{

    public Response<List<LoadAllEmployByRoleDTO>> loadAllEmployByArea(LoadAreaRequest loadAreaRequest,
            Long loginEmployFK);

    public Response<List<LoadAllEmployByRoleDTO>> loadAllSupervisorByArea(LoadAreaRequest loadAreaRequest);

    public Response<List<LoadAllEmployByRoleDTO>> loadAllOfficerBySupervisor(LoadEmployRequest loadEmployRequest);

    public Response<List<LoadAllEmployDTO>> loadAllEmploy(Long loginEmployPK);

    public Response<LoadEmployDTO> loadRoleEmploy(Long loginEmployPK);

    public Response<LoadEmployDTO> loadEmploy(LoadEmployRequest loadEmployRequest);

    public Response<String> addAdminEmploy(AddAdminEmployRequest addAdminEmployRequest, Long loginEmployPK);

    public Response<String> addSupervisorEmploy(AddSupervisorEmployRequest addSupervisorEmployRequest,
            Long loginEmployPK);

    public Response<String> addOfficerEmploy(AddOfficerEmployRequest addOfficerEmployRequest, Long loginEmployPK);

    public Response<String> updateAdminGlobalPassword(UpdateAdminGlobalPasswordRequest updateAdminGlobalPasswordRequest,
            SecurityToken token);

    public Response<String> updateAdminBusinessEmploy(UpdateAdminEmployRequest updateAdminEmployRequest,
            SecurityToken token);

    public Response<String> updateSupervisorEmploy(UpdateSupervisorEmployRequest updateSupervisorEmployRequest,
            Long loginEmployPK);

    public Response<String> updateOfficerEmploy(UpdateOfficerEmployRequest updateOfficerEmployRequest,
            Long loginEmployPK);

    public Response<String> defuseOfficerEmploy(DefuseEmployRequest defuseEmployRequest, Long loginEmployPK);

    public Response<List<LoadAllEmployByRoleDTO>> loadAllSupervisorForDefuse(LoadEmployRequest loadEmployRequest,
            Long loginEmployPK);

    public Response<String> defuseSupervisorEmploy(DefuseSupervisorRequest defuseSupervisorRequest, Long loginEmployPK);

    public Response<String> defuseAdminBusinessEmploy(DefuseEmployRequest defuseEmployRequest, Long loginEmployPK);
}
