
package pe.com.synopsis.imgrabber.business.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import pe.com.synopsis.imgrabber.beans.domain.LoadRole;
import pe.com.synopsis.imgrabber.beans.dto.LoadRoleDTO;
import pe.com.synopsis.imgrabber.business.RoleBL;
import pe.com.synopsis.imgrabber.converter.LoadRoleConverter;
import pe.com.synopsis.imgrabber.dao.RoleDAO;

@Component
public class RoleBLImpl implements RoleBL
{

    @Autowired
    private RoleDAO roleDao;

    @Autowired
    private LoadRoleConverter loadRoleConverter;

    public List<LoadRoleDTO> loadRole(Long loginEmployPK)
    {
        List<LoadRole> role = roleDao.loadRole(loginEmployPK);
        return loadRoleConverter.convert(role);
    }
}
