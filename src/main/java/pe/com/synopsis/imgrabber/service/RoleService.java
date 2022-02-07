
package pe.com.synopsis.imgrabber.service;

import java.util.List;

import pe.com.synopsis.imgrabber.beans.dto.LoadRoleDTO;
import pe.com.synopsis.imgrabber.beans.response.Response;

public interface RoleService
{

    public Response<List<LoadRoleDTO>> loadRole(Long loginEmployPK);
}
