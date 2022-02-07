
package pe.com.synopsis.imgrabber.business;

import java.util.List;

import pe.com.synopsis.imgrabber.beans.dto.LoadAllExcluidDTO;
import pe.com.synopsis.imgrabber.beans.request.LoadAllExcluidRequest;

public interface ExcluidBL
{

    public List<LoadAllExcluidDTO> loadAllExcluid(LoadAllExcluidRequest loadAllExcluidRequest);

}
