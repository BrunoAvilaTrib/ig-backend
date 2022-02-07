
package pe.com.synopsis.imgrabber.dao;

import java.util.List;

import pe.com.synopsis.imgrabber.beans.domain.LoadAllBusiness;
import pe.com.synopsis.imgrabber.beans.domain.LoadAllBusinessByRole;
import pe.com.synopsis.imgrabber.beans.domain.LoadBusiness;
import pe.com.synopsis.imgrabber.beans.request.AddBusinessRequest;
import pe.com.synopsis.imgrabber.beans.request.LoadBusinessRequest;
import pe.com.synopsis.imgrabber.beans.request.UpdateBusinessRequest;

public interface BusinessDAO
{

    public String getNameBusiness(String email);

    public void updateBusiness(UpdateBusinessRequest updateBusinessRequest);

    public void addBusiness(AddBusinessRequest addBusinessRequest);

    public List<LoadAllBusinessByRole> loadAllBusinessByRole(Long loginEmployFK);

    public List<LoadAllBusiness> loadAllBusiness();

    public List<LoadBusiness> loadBusiness(LoadBusinessRequest loadBusinessRequest);
}
