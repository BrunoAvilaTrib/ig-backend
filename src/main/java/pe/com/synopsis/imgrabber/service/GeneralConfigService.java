
package pe.com.synopsis.imgrabber.service;

import java.util.List;

import pe.com.synopsis.imgrabber.beans.dto.LoadGeneralConfigDTO;
import pe.com.synopsis.imgrabber.beans.request.UpdateGeneralConfigRequest;
import pe.com.synopsis.imgrabber.beans.response.Response;

public interface GeneralConfigService
{

    public Response<List<LoadGeneralConfigDTO>> loadGeneralConfig();

    public Response<String> updateGeneralConfig(UpdateGeneralConfigRequest generalConfig);
}
