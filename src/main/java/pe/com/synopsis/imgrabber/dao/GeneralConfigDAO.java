
package pe.com.synopsis.imgrabber.dao;

import java.util.List;

import pe.com.synopsis.imgrabber.beans.domain.LoadGeneralConfig;
import pe.com.synopsis.imgrabber.beans.request.UpdateGeneralConfigRequest;

public interface GeneralConfigDAO
{

    public List<LoadGeneralConfig> loadGeneralConfig();

    public void updateGenConfig(UpdateGeneralConfigRequest generalConfig);

}
