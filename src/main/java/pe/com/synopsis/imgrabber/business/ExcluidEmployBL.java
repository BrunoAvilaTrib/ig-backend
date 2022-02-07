
package pe.com.synopsis.imgrabber.business;

import java.util.List;

import pe.com.synopsis.imgrabber.beans.dto.LoadAllExcluidEmployDTO;
import pe.com.synopsis.imgrabber.beans.dto.LoadExcluidEmployDTO;
import pe.com.synopsis.imgrabber.beans.request.AddExcluidEmployRequest;
import pe.com.synopsis.imgrabber.beans.request.DefuseExcluidEmployRequest;
import pe.com.synopsis.imgrabber.beans.request.LoadExcluidEmployRequest;
import pe.com.synopsis.imgrabber.beans.request.UpdateExcluidEmployRequest;

public interface ExcluidEmployBL
{

    public void updateExcluidEmploy(UpdateExcluidEmployRequest updateExcluidEmployRequest);

    public void addExcluidEmploy(AddExcluidEmployRequest addExcluidEmployRequest);

    public void defuseExcluidEmploy(DefuseExcluidEmployRequest defuseExcluidEmployRequest);

    public List<LoadAllExcluidEmployDTO> loadAllExcluidEmploy(Long loginEmployFK);

    public List<LoadExcluidEmployDTO> loadExcluidEmploy(LoadExcluidEmployRequest LoadExcluidEmployRequest);
}
