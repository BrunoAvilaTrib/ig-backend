
package pe.com.synopsis.imgrabber.dao;

import java.util.List;

import pe.com.synopsis.imgrabber.beans.domain.LoadAllArea;
import pe.com.synopsis.imgrabber.beans.domain.LoadAllAreaByRole;
import pe.com.synopsis.imgrabber.beans.domain.LoadArea;
import pe.com.synopsis.imgrabber.beans.request.AddAreaRequest;
import pe.com.synopsis.imgrabber.beans.request.DefuseAreaRequest;
import pe.com.synopsis.imgrabber.beans.request.LoadAreaRequest;
import pe.com.synopsis.imgrabber.beans.request.UpdateAreaRequest;

public interface AreaDAO
{

    public void updateArea(UpdateAreaRequest updateAreaRequest);

    public void addArea(AddAreaRequest addAreaRequest);

    public void defuseArea(DefuseAreaRequest defuseAreaRequest);

    public List<LoadAllArea> loadAllArea(Long loginEmployFK);

    public List<LoadAllAreaByRole> loadAllAreaByRole(Long loginEmployFK);

    public List<LoadArea> loadArea(LoadAreaRequest loadAreaRequest);

}
