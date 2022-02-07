
package pe.com.synopsis.imgrabber.business;

import java.util.List;

import pe.com.synopsis.imgrabber.beans.dto.LoadAllBusinessByRoleDTO;
import pe.com.synopsis.imgrabber.beans.dto.LoadAllBusinessDTO;
import pe.com.synopsis.imgrabber.beans.dto.LoadBusinessDTO;
import pe.com.synopsis.imgrabber.beans.request.AddBusinessRequest;
import pe.com.synopsis.imgrabber.beans.request.LoadBusinessRequest;
import pe.com.synopsis.imgrabber.beans.request.UpdateBusinessRequest;

public interface BusinessBL
{

    public void updateBusiness(UpdateBusinessRequest updateBusinessRequest);

    public void addBusiness(AddBusinessRequest addBusinessRequest);

    public List<LoadAllBusinessDTO> loadAllBusiness();

    public List<LoadAllBusinessByRoleDTO> loadAllBusinessByRol(Long loginEmployFK);

    public List<LoadBusinessDTO> loadBusiness(LoadBusinessRequest loadBusinessRequest);

}
