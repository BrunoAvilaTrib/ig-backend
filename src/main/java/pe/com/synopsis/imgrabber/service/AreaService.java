
package pe.com.synopsis.imgrabber.service;

import java.util.List;

import pe.com.synopsis.imgrabber.beans.dto.LoadAllAreaByRoleDTO;
import pe.com.synopsis.imgrabber.beans.dto.LoadAllAreaDTO;
import pe.com.synopsis.imgrabber.beans.dto.LoadAreaDTO;
import pe.com.synopsis.imgrabber.beans.request.AddAreaRequest;
import pe.com.synopsis.imgrabber.beans.request.DefuseAreaRequest;
import pe.com.synopsis.imgrabber.beans.request.LoadAreaRequest;
import pe.com.synopsis.imgrabber.beans.request.UpdateAreaRequest;
import pe.com.synopsis.imgrabber.beans.response.Response;

public interface AreaService
{

    public Response<String> updateArea(UpdateAreaRequest updateAreaRequest);

    public Response<String> addArea(AddAreaRequest addAreaRequest);

    public Response<String> defuseArea(DefuseAreaRequest defuseAreaRequest);

    public Response<List<LoadAllAreaDTO>> loadAllArea(Long loginEmployFK);

    public Response<List<LoadAllAreaByRoleDTO>> loadAllAreaByRole(Long loginEmployFK);

    public Response<LoadAreaDTO> loadArea(LoadAreaRequest loadAreaRequest);

}
