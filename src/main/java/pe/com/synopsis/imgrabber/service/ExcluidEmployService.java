
package pe.com.synopsis.imgrabber.service;

import java.util.List;

import pe.com.synopsis.imgrabber.beans.dto.LoadAllExcluidEmployDTO;
import pe.com.synopsis.imgrabber.beans.dto.LoadExcluidEmployDTO;
import pe.com.synopsis.imgrabber.beans.request.AddExcluidEmployRequest;
import pe.com.synopsis.imgrabber.beans.request.DefuseExcluidEmployRequest;
import pe.com.synopsis.imgrabber.beans.request.LoadExcluidEmployRequest;
import pe.com.synopsis.imgrabber.beans.request.UpdateExcluidEmployRequest;
import pe.com.synopsis.imgrabber.beans.response.Response;

public interface ExcluidEmployService
{

    public Response<String> updateExcluidEmploy(UpdateExcluidEmployRequest updateExcluidEmployRequest);

    public Response<String> addExcluidEmploy(AddExcluidEmployRequest addExcluidEmployRequest);

    public Response<String> defuseExcluidEmploy(DefuseExcluidEmployRequest defuseExcluidEmployRequest);

    public Response<List<LoadAllExcluidEmployDTO>> loadAllExcluidEmploy(Long loginEmployFK);

    public Response<LoadExcluidEmployDTO> loadExcluidEmploy(LoadExcluidEmployRequest loadExcluidEmployRequest);
}
