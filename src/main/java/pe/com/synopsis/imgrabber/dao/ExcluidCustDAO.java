
package pe.com.synopsis.imgrabber.dao;

import java.util.List;

import pe.com.synopsis.imgrabber.beans.domain.LoadAllExcluidCust;
import pe.com.synopsis.imgrabber.beans.request.AddExcluidCustRequest;
import pe.com.synopsis.imgrabber.beans.request.DefuseExcluidCustRequest;

public interface ExcluidCustDAO
{

    public List<LoadAllExcluidCust> loadAllExcluidCust(Long loginEmployFK);

    public void defuseExcluidCust(DefuseExcluidCustRequest defuseExcluidCustRequest);

    public void addExcluidCust(AddExcluidCustRequest addExcluidCustRequest, Long loginEmployFK);

}
