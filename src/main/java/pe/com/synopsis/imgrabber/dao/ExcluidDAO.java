
package pe.com.synopsis.imgrabber.dao;

import java.util.List;

import pe.com.synopsis.imgrabber.beans.domain.LoadAllExcluid;
import pe.com.synopsis.imgrabber.beans.request.AddExcluidRequest;

public interface ExcluidDAO
{

    public void addExcluid(AddExcluidRequest excluid, Long employPK);

    public void deleteExcluid(Long employPK);

    public List<LoadAllExcluid> loadAllExcluid(Long inEmployFK);

}
