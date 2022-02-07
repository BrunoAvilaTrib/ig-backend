
package pe.com.synopsis.imgrabber.business;

import java.util.List;

import pe.com.synopsis.imgrabber.beans.dto.LoadEmployTrazeDTO;
import pe.com.synopsis.imgrabber.beans.request.AddEmployTrazeRequest;

public interface EmployTrazeBL
{

    public List<LoadEmployTrazeDTO> loadEmployTrace();

    public void addEmployTraze(AddEmployTrazeRequest employTraze, String login);

}
