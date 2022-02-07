
package pe.com.synopsis.imgrabber.dao;

import java.util.List;

import pe.com.synopsis.imgrabber.beans.domain.LoadEmployTraze;
import pe.com.synopsis.imgrabber.beans.request.AddEmployTrazeRequest;

public interface EmployTrazeDAO
{

    public List<LoadEmployTraze> loadEmployTrace();

    public void addEmployTraze(AddEmployTrazeRequest employTrazeRequest, String login);

}
