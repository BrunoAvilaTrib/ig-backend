
package pe.com.synopsis.imgrabber.business.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import pe.com.synopsis.imgrabber.beans.domain.LoadAllExcluidEmploy;
import pe.com.synopsis.imgrabber.beans.domain.LoadExcluidEmploy;
import pe.com.synopsis.imgrabber.beans.dto.LoadAllExcluidEmployDTO;
import pe.com.synopsis.imgrabber.beans.dto.LoadExcluidEmployDTO;
import pe.com.synopsis.imgrabber.beans.request.AddExcluidEmployRequest;
import pe.com.synopsis.imgrabber.beans.request.DefuseExcluidEmployRequest;
import pe.com.synopsis.imgrabber.beans.request.LoadExcluidEmployRequest;
import pe.com.synopsis.imgrabber.beans.request.UpdateExcluidEmployRequest;
import pe.com.synopsis.imgrabber.business.ExcluidEmployBL;
import pe.com.synopsis.imgrabber.converter.LoadAllExcluidEmployConverter;
import pe.com.synopsis.imgrabber.converter.LoadExcluidEmployConverter;
import pe.com.synopsis.imgrabber.dao.ExcluidEmployDAO;

@Component
public class ExcluidEmployBLImpl implements ExcluidEmployBL
{

    @Autowired
    private ExcluidEmployDAO excluidEmployDAO;

    @Autowired
    private LoadAllExcluidEmployConverter loadAllExcluidEmployConverter;

    @Autowired
    private LoadExcluidEmployConverter loadExcluidEmployConverter;

    @Override
    public void updateExcluidEmploy(UpdateExcluidEmployRequest updateExcluidEmployRequest)
    {
        excluidEmployDAO.updateExcluidEmploy(updateExcluidEmployRequest);
    }

    @Override
    public void addExcluidEmploy(AddExcluidEmployRequest addExcluidEmployRequest)
    {
        excluidEmployDAO.addExcluidEmploy(addExcluidEmployRequest);
    }

    @Override
    public void defuseExcluidEmploy(DefuseExcluidEmployRequest defuseExcluidEmployRequest)
    {
        excluidEmployDAO.defuseExcluidEmploy(defuseExcluidEmployRequest);
    }

    @Override
    public List<LoadAllExcluidEmployDTO> loadAllExcluidEmploy(Long loginEmployFK)
    {
        List<LoadAllExcluidEmploy> response = excluidEmployDAO.loadAllExcluidEmploy(loginEmployFK);
        return loadAllExcluidEmployConverter.convert(response);
    }

    @Override
    public List<LoadExcluidEmployDTO> loadExcluidEmploy(LoadExcluidEmployRequest LoadExcluidEmployRequest)
    {
        List<LoadExcluidEmploy> response = excluidEmployDAO.loadExcluidEmploy(LoadExcluidEmployRequest);
        return loadExcluidEmployConverter.convert(response);
    }
}