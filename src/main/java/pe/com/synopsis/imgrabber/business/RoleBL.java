
package pe.com.synopsis.imgrabber.business;

import java.util.List;

import pe.com.synopsis.imgrabber.beans.dto.LoadRoleDTO;

public interface RoleBL
{

    public List<LoadRoleDTO> loadRole(Long loginEmployPK);

}
