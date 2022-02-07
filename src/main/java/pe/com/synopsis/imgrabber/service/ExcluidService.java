
package pe.com.synopsis.imgrabber.service;

import pe.com.synopsis.imgrabber.beans.dto.LoadAllExcluidDTO;
import pe.com.synopsis.imgrabber.beans.request.LoadAllExcluidRequest;
import pe.com.synopsis.imgrabber.beans.response.Response;

public interface ExcluidService
{

    Response<LoadAllExcluidDTO> loadAllExcluid(LoadAllExcluidRequest loadAllExcluidRequest);

}
