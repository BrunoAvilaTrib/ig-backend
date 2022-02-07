
package pe.com.synopsis.imgrabber.business;

import java.util.List;

import pe.com.synopsis.imgrabber.beans.dto.LoadAllExcluidCustDTO;
import pe.com.synopsis.imgrabber.beans.request.AddExcluidCustRequest;
import pe.com.synopsis.imgrabber.beans.request.DefuseExcluidCustRequest;

public interface ExcluidCustBL
{

    public List<LoadAllExcluidCustDTO> loadAllExcluidCust(Long loginEmployFK);

    public void defuseExcluidCust(DefuseExcluidCustRequest defuseExcluidCustRequest);

    public void addExcluidCust(AddExcluidCustRequest addExcluidCustRequest, Long loginEmployFK);

}
