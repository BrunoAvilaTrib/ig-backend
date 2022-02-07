
package pe.com.synopsis.imgrabber.service;

import java.util.List;

import pe.com.synopsis.imgrabber.beans.dto.HeaderDTO;
import pe.com.synopsis.imgrabber.beans.response.Response;

public interface HeaderService
{

    public Response<List<HeaderDTO>> loadHeader(String login);

}
