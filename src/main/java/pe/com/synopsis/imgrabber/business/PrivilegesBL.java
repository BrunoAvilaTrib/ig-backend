
package pe.com.synopsis.imgrabber.business;

import java.util.List;

import pe.com.synopsis.imgrabber.beans.dto.LoadBySupervisorPrivilegeDTO;
import pe.com.synopsis.imgrabber.beans.dto.LoadPrivilegeDTO;

public interface PrivilegesBL
{

    public List<LoadPrivilegeDTO> loadPrivilege();

    public List<LoadBySupervisorPrivilegeDTO> loadBySupervisorPrivilege(String login);

}
