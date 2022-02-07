
package pe.com.synopsis.imgrabber.business.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import pe.com.synopsis.imgrabber.beans.domain.Header;
import pe.com.synopsis.imgrabber.beans.dto.HeaderDTO;
import pe.com.synopsis.imgrabber.business.HeaderBL;
import pe.com.synopsis.imgrabber.converter.LoadHeaderConverter;
import pe.com.synopsis.imgrabber.dao.HeaderDAO;

@Component
public class HeaderBLImpl implements HeaderBL
{

    @Autowired
    private HeaderDAO headerDAO;
    @Autowired
    private LoadHeaderConverter loadHeaderConverter;

    @Override
    public List<HeaderDTO> loadHeader(String email)
    {
        List<Header> headers = headerDAO.loadHeader(email);
        return loadHeaderConverter.convert(headers);
    }

}
