
package pe.com.synopsis.imgrabber.dao;

import java.util.List;

import pe.com.synopsis.imgrabber.beans.domain.LoadBySupervisorPrivilege;
import pe.com.synopsis.imgrabber.beans.domain.LoadPrivilege;

public interface PrivilegeDAO
{

    public List<LoadBySupervisorPrivilege> loadBySupervisorPrivilege(String login);

    public List<LoadPrivilege> loadPrivilege();

}
