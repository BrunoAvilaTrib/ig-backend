
package pe.com.synopsis.imgrabber.business.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import pe.com.synopsis.imgrabber.beans.domain.LoadAllBusiness;
import pe.com.synopsis.imgrabber.beans.domain.LoadAllBusinessByRole;
import pe.com.synopsis.imgrabber.beans.domain.LoadBusiness;
import pe.com.synopsis.imgrabber.beans.dto.LoadAllBusinessByRoleDTO;
import pe.com.synopsis.imgrabber.beans.dto.LoadAllBusinessDTO;
import pe.com.synopsis.imgrabber.beans.dto.LoadBusinessDTO;
import pe.com.synopsis.imgrabber.beans.request.AddBusinessRequest;
import pe.com.synopsis.imgrabber.beans.request.LoadBusinessRequest;
import pe.com.synopsis.imgrabber.beans.request.UpdateBusinessRequest;
import pe.com.synopsis.imgrabber.business.BusinessBL;
import pe.com.synopsis.imgrabber.converter.LoadAllBusinessByRoleConverter;
import pe.com.synopsis.imgrabber.converter.LoadAllBusinessConverter;
import pe.com.synopsis.imgrabber.converter.LoadBusinessConverter;
import pe.com.synopsis.imgrabber.dao.BusinessDAO;

@Component
public class BusinessBLImpl implements BusinessBL
{

    @Autowired
    private BusinessDAO businessDAO;

    @Autowired
    private LoadAllBusinessByRoleConverter loadAllBusinessByRoleConverter;

    @Autowired
    private LoadAllBusinessConverter loadAllBusinessConverter;

    @Autowired
    private LoadBusinessConverter loadBusinessConverter;

    @Override
    public void updateBusiness(UpdateBusinessRequest updateBusinessRequest)
    {
        businessDAO.updateBusiness(updateBusinessRequest);
    }

    @Override
    public void addBusiness(AddBusinessRequest addBusinessRequest)
    {
        businessDAO.addBusiness(addBusinessRequest);
    }

    @Override
    public List<LoadAllBusinessByRoleDTO> loadAllBusinessByRol(Long loginEmployFK)
    {
        List<LoadAllBusinessByRole> loadAllBusinessbyrole = businessDAO.loadAllBusinessByRole(loginEmployFK);
        return loadAllBusinessByRoleConverter.convert(loadAllBusinessbyrole);
    }

    @Override
    public List<LoadAllBusinessDTO> loadAllBusiness()
    {
        List<LoadAllBusiness> loadAllBusiness = businessDAO.loadAllBusiness();
        return loadAllBusinessConverter.convert(loadAllBusiness);
    }

    @Override
    public List<LoadBusinessDTO> loadBusiness(LoadBusinessRequest loadBusinessRequest)
    {
        List<LoadBusiness> loadBusiness = businessDAO.loadBusiness(loadBusinessRequest);
        return loadBusinessConverter.convert(loadBusiness);
    }
}
