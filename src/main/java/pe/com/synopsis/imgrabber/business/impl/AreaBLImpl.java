
package pe.com.synopsis.imgrabber.business.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import pe.com.synopsis.imgrabber.beans.domain.LoadAllArea;
import pe.com.synopsis.imgrabber.beans.domain.LoadAllAreaByRole;
import pe.com.synopsis.imgrabber.beans.domain.LoadArea;
import pe.com.synopsis.imgrabber.beans.dto.LoadAllAreaByRoleDTO;
import pe.com.synopsis.imgrabber.beans.dto.LoadAllAreaDTO;
import pe.com.synopsis.imgrabber.beans.dto.LoadAreaDTO;
import pe.com.synopsis.imgrabber.beans.request.AddAreaRequest;
import pe.com.synopsis.imgrabber.beans.request.DefuseAreaRequest;
import pe.com.synopsis.imgrabber.beans.request.LoadAreaRequest;
import pe.com.synopsis.imgrabber.beans.request.UpdateAreaRequest;
import pe.com.synopsis.imgrabber.business.AreaBL;
import pe.com.synopsis.imgrabber.converter.LoadAllAreaByRoleConverter;
import pe.com.synopsis.imgrabber.converter.LoadAllAreaConverter;
import pe.com.synopsis.imgrabber.converter.LoadAreaConverter;
import pe.com.synopsis.imgrabber.dao.AreaDAO;

@Component
public class AreaBLImpl implements AreaBL
{

    @Autowired
    AreaDAO areaDAO;

    @Autowired
    private LoadAllAreaConverter loadAllAreaConverter;

    @Autowired
    private LoadAreaConverter loadAreaConverter;

    @Autowired
    private LoadAllAreaByRoleConverter loadAllAreaByRoleConverter;

    @Override
    public void updateArea(UpdateAreaRequest updateAreaRequest)
    {
        areaDAO.updateArea(updateAreaRequest);
    }

    @Override
    public void addArea(AddAreaRequest addAreaRequest)
    {
        areaDAO.addArea(addAreaRequest);
    }

    @Override
    public void defuseArea(DefuseAreaRequest defuseAreaRequest)
    {
        areaDAO.defuseArea(defuseAreaRequest);
    }

    @Override
    public List<LoadAllAreaDTO> loadAllArea(Long loginEmployFK)
    {
        List<LoadAllArea> areas = areaDAO.loadAllArea(loginEmployFK);
        return loadAllAreaConverter.convert(areas);
    }

    @Override
    public List<LoadAllAreaByRoleDTO> loadAllAreaByRole(Long loginEmployFK)
    {
        List<LoadAllAreaByRole> areas = areaDAO.loadAllAreaByRole(loginEmployFK);
        return loadAllAreaByRoleConverter.convert(areas);
    }

    @Override
    public List<LoadAreaDTO> loadArea(LoadAreaRequest loadAreaRequest)
    {
        List<LoadArea> areas = areaDAO.loadArea(loadAreaRequest);
        return loadAreaConverter.convert(areas);
    }

}
