
package pe.com.synopsis.imgrabber.service;

import java.util.List;

import pe.com.synopsis.imgrabber.beans.dto.LoadAllBusinessByRoleDTO;
import pe.com.synopsis.imgrabber.beans.dto.LoadAllBusinessDTO;
import pe.com.synopsis.imgrabber.beans.dto.LoadBusinessDTO;
import pe.com.synopsis.imgrabber.beans.request.AddBusinessRequest;
import pe.com.synopsis.imgrabber.beans.request.LoadBusinessRequest;
import pe.com.synopsis.imgrabber.beans.request.UpdateBusinessRequest;
import pe.com.synopsis.imgrabber.beans.response.Response;

public interface BusinessService
{

    public Response<String> updateBusiness(UpdateBusinessRequest updateBusinessRequest);

    public Response<String> addBusiness(AddBusinessRequest addBusinessRequest);

    public Response<List<LoadAllBusinessDTO>> loadAllBusiness();

    public Response<List<LoadAllBusinessByRoleDTO>> loadAllBusinessByRole(Long loginEmployPK);

    public Response<LoadBusinessDTO> loadBusiness(LoadBusinessRequest loadBusinessRequest);
}
