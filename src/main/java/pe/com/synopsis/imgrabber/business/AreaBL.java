
package pe.com.synopsis.imgrabber.business;

import java.util.List;

import pe.com.synopsis.imgrabber.beans.dto.LoadAllAreaByRoleDTO;
import pe.com.synopsis.imgrabber.beans.dto.LoadAllAreaDTO;
import pe.com.synopsis.imgrabber.beans.dto.LoadAreaDTO;
import pe.com.synopsis.imgrabber.beans.request.AddAreaRequest;
import pe.com.synopsis.imgrabber.beans.request.DefuseAreaRequest;
import pe.com.synopsis.imgrabber.beans.request.LoadAreaRequest;
import pe.com.synopsis.imgrabber.beans.request.UpdateAreaRequest;

public interface AreaBL
{

    public void updateArea(UpdateAreaRequest updateAreaRequest);

    public void addArea(AddAreaRequest addAreaRequest);

    public void defuseArea(DefuseAreaRequest defuseAreaRequest);

    public List<LoadAllAreaDTO> loadAllArea(Long loginEmployFK);

    public List<LoadAllAreaByRoleDTO> loadAllAreaByRole(Long loginEmployFK);

    public List<LoadAreaDTO> loadArea(LoadAreaRequest loadAreaRequest);

}
