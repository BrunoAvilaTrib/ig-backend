
package pe.com.synopsis.imgrabber.dao;

import java.util.List;

import pe.com.synopsis.imgrabber.beans.domain.LoadAllExcluidEmploy;
import pe.com.synopsis.imgrabber.beans.domain.LoadExcluidEmploy;
import pe.com.synopsis.imgrabber.beans.request.AddExcluidEmployRequest;
import pe.com.synopsis.imgrabber.beans.request.DefuseExcluidEmployRequest;
import pe.com.synopsis.imgrabber.beans.request.LoadExcluidEmployRequest;
import pe.com.synopsis.imgrabber.beans.request.UpdateExcluidEmployRequest;

public interface ExcluidEmployDAO
{

    public void addExcluidEmploy(AddExcluidEmployRequest addExcluidEmployRequest);

    public void updateExcluidEmploy(UpdateExcluidEmployRequest updateExcluidEmployRequest);

    public void defuseExcluidEmploy(DefuseExcluidEmployRequest defuseExcluidEmployRequest);

    public List<LoadAllExcluidEmploy> loadAllExcluidEmploy(Long loginEmployFK);

    public List<LoadExcluidEmploy> loadExcluidEmploy(LoadExcluidEmployRequest LoadExcluidEmployRequest);
}
