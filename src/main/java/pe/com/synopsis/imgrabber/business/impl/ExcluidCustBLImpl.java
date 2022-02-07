
package pe.com.synopsis.imgrabber.business.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import pe.com.synopsis.imgrabber.beans.domain.LoadAllExcluidCust;
import pe.com.synopsis.imgrabber.beans.dto.LoadAllExcluidCustDTO;
import pe.com.synopsis.imgrabber.beans.request.AddExcluidCustRequest;
import pe.com.synopsis.imgrabber.beans.request.DefuseExcluidCustRequest;
import pe.com.synopsis.imgrabber.business.ExcluidCustBL;
import pe.com.synopsis.imgrabber.converter.LoadAllExcluidCustConverter;
import pe.com.synopsis.imgrabber.dao.ExcluidCustDAO;

@Component
public class ExcluidCustBLImpl implements ExcluidCustBL
{

    @Autowired
    private ExcluidCustDAO excluidCustDAO;

    @Autowired
    private LoadAllExcluidCustConverter loadAllExcluidCustConverter;

    @Override
    public List<LoadAllExcluidCustDTO> loadAllExcluidCust(Long loginEmployFK)
    {
        List<LoadAllExcluidCust> response = excluidCustDAO.loadAllExcluidCust(loginEmployFK);
        return loadAllExcluidCustConverter.convert(response);
    }

    @Override
    public void defuseExcluidCust(DefuseExcluidCustRequest defuseExcluidCustRequest)
    {
        excluidCustDAO.defuseExcluidCust(defuseExcluidCustRequest);
    }

    @Override
    public void addExcluidCust(AddExcluidCustRequest addExcluidCustRequest, Long loginEmployFK)
    {
        excluidCustDAO.addExcluidCust(addExcluidCustRequest, loginEmployFK);
    }
}