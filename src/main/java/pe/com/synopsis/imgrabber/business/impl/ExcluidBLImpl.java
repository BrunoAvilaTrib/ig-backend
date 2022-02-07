
package pe.com.synopsis.imgrabber.business.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import pe.com.synopsis.imgrabber.beans.domain.LoadAllExcluid;
import pe.com.synopsis.imgrabber.beans.dto.LoadAllExcluidDTO;
import pe.com.synopsis.imgrabber.beans.request.LoadAllExcluidRequest;
import pe.com.synopsis.imgrabber.business.ExcluidBL;
import pe.com.synopsis.imgrabber.converter.LoadAllExcluidConverter;
import pe.com.synopsis.imgrabber.dao.ExcluidDAO;

@Component
public class ExcluidBLImpl implements ExcluidBL
{

    @SuppressWarnings("unused")
    private static final Logger logger = LoggerFactory.getLogger(ExcluidBLImpl.class);

    @Autowired
    private LoadAllExcluidConverter loadAllExcluidConverter;

    @Autowired
    private ExcluidDAO excluidDAO;

    @Override
    public List<LoadAllExcluidDTO> loadAllExcluid(LoadAllExcluidRequest loadAllExcluidRequest)
    {
        List<LoadAllExcluid> list = excluidDAO.loadAllExcluid(loadAllExcluidRequest.getEmployFk());
        return loadAllExcluidConverter.convert(list);
    }

}
