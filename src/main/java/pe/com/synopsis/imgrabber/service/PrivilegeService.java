
package pe.com.synopsis.imgrabber.service;

import java.util.List;

import pe.com.synopsis.imgrabber.beans.dto.LoadBySupervisorPrivilegeDTO;
import pe.com.synopsis.imgrabber.beans.dto.LoadPrivilegeDTO;
import pe.com.synopsis.imgrabber.beans.response.Response;

public interface PrivilegeService
{

    public Response<List<LoadBySupervisorPrivilegeDTO>> loadBySupervisorPrivilege(String login);

    public Response<List<LoadPrivilegeDTO>> loadPrivilege();

}
