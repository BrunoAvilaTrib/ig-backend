
package pe.com.synopsis.imgrabber.service;

import pe.com.synopsis.imgrabber.beans.dto.LoadEmployConfigDTO;
import pe.com.synopsis.imgrabber.beans.request.LoadEmployConfigRequest;
import pe.com.synopsis.imgrabber.beans.request.UpdateEmployConfigRequest;
import pe.com.synopsis.imgrabber.beans.response.Response;

public interface ConfigService
{

    Response<String> updateEmployConfig(UpdateEmployConfigRequest employConfigRequest);

    Response<LoadEmployConfigDTO> loadEmployConfig(LoadEmployConfigRequest employConfigRequest);
}
