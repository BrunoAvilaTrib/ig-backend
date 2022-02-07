
package pe.com.synopsis.imgrabber.dao;

import java.util.List;

import pe.com.synopsis.imgrabber.beans.domain.LoadRole;

public interface RoleDAO
{
    public List<LoadRole> loadRole(Long loginEmployPK);
}
