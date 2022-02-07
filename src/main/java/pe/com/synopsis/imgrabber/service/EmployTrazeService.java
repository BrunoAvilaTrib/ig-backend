
package pe.com.synopsis.imgrabber.service;

import java.util.List;

import pe.com.synopsis.imgrabber.beans.dto.LoadEmployTrazeDTO;
import pe.com.synopsis.imgrabber.beans.request.AddEmployTrazeRequest;
import pe.com.synopsis.imgrabber.beans.response.Response;

public interface EmployTrazeService
{

    public Response<List<LoadEmployTrazeDTO>> loadEmployTrace();

    public Response<String> addEmployTraze(AddEmployTrazeRequest employTrazeRequest, String login);

}
