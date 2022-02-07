
package pe.com.synopsis.imgrabber.service;

import java.util.List;

import pe.com.synopsis.imgrabber.beans.dto.LoadAllExcluidCustDTO;
import pe.com.synopsis.imgrabber.beans.request.AddExcluidCustRequest;
import pe.com.synopsis.imgrabber.beans.request.DefuseExcluidCustRequest;
import pe.com.synopsis.imgrabber.beans.response.Response;

public interface ExcluidCustService
{

    public Response<List<LoadAllExcluidCustDTO>> loadAllExcluidCust(Long loginEmployFK);

    public Response<String> defuseExcluidCust(DefuseExcluidCustRequest defuseExcluidCustRequest);

    public Response<String> addExcluidCust(AddExcluidCustRequest addExcluidCustRequest, Long loginEmployFK);

}
