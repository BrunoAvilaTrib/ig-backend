
package pe.com.synopsis.imgrabber.business.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import pe.com.synopsis.imgrabber.beans.domain.LoadBySupervisorPrivilege;
import pe.com.synopsis.imgrabber.beans.domain.LoadPrivilege;
import pe.com.synopsis.imgrabber.beans.dto.LoadBySupervisorPrivilegeDTO;
import pe.com.synopsis.imgrabber.beans.dto.LoadPrivilegeDTO;
import pe.com.synopsis.imgrabber.business.PrivilegesBL;
import pe.com.synopsis.imgrabber.converter.LoadBySupervisorPrivilegeConverter;
import pe.com.synopsis.imgrabber.converter.LoadPrivilegeConverter;
import pe.com.synopsis.imgrabber.dao.PrivilegeDAO;

@Component
public class PrivilegesBLImpl implements PrivilegesBL
{

    @Autowired
    private LoadPrivilegeConverter loadPrivilegeConverter;

    @Autowired
    private LoadBySupervisorPrivilegeConverter loadBySupervisorPrivilegeConverter;

    @Autowired
    private PrivilegeDAO privilegeDAO;

    @Override
    public List<LoadPrivilegeDTO> loadPrivilege()
    {

        List<LoadPrivilege> privileges = privilegeDAO.loadPrivilege();
        return loadPrivilegeConverter.convert(privileges);
    }

    @Override
    public List<LoadBySupervisorPrivilegeDTO> loadBySupervisorPrivilege(String login)
    {

        List<LoadBySupervisorPrivilege> privileges = privilegeDAO.loadBySupervisorPrivilege(login);
        return loadBySupervisorPrivilegeConverter.convert(privileges);
    }

}
