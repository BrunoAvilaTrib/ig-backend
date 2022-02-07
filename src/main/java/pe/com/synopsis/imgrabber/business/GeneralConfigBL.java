
package pe.com.synopsis.imgrabber.business;

import java.util.List;

import pe.com.synopsis.imgrabber.beans.dto.LoadGeneralConfigDTO;
import pe.com.synopsis.imgrabber.beans.request.UpdateGeneralConfigRequest;

public interface GeneralConfigBL
{

    public List<LoadGeneralConfigDTO> loadGeneralConfig();

    public void updateGeneralConfig(UpdateGeneralConfigRequest generalConfigRequest);

}
