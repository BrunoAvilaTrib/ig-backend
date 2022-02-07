
package pe.com.synopsis.imgrabber.business.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import pe.com.synopsis.imgrabber.beans.domain.LoadEmployTraze;
import pe.com.synopsis.imgrabber.beans.dto.LoadEmployTrazeDTO;
import pe.com.synopsis.imgrabber.beans.request.AddEmployTrazeRequest;
import pe.com.synopsis.imgrabber.business.EmployTrazeBL;
import pe.com.synopsis.imgrabber.converter.LoadEmployTraceConverter;
import pe.com.synopsis.imgrabber.dao.EmployTrazeDAO;

@Component
public class EmployTrazeBLImpl implements EmployTrazeBL
{

    @Autowired
    private EmployTrazeDAO employTrazeDAO;

    @Autowired
    private LoadEmployTraceConverter loadEmployTrazeConverter;

    @Override
    public List<LoadEmployTrazeDTO> loadEmployTrace()
    {

        List<LoadEmployTraze> response = employTrazeDAO.loadEmployTrace();

        return loadEmployTrazeConverter.convert(response);
    }

    @Override
    public void addEmployTraze(AddEmployTrazeRequest employTrazeRequest, String login)
    {

        employTrazeDAO.addEmployTraze(employTrazeRequest, login);
    }

}
