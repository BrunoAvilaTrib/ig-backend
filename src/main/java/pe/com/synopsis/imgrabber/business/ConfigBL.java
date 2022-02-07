
package pe.com.synopsis.imgrabber.business;

import java.util.List;

import pe.com.synopsis.imgrabber.beans.dto.LoadEmployConfigDTO;
import pe.com.synopsis.imgrabber.beans.request.LoadEmployConfigRequest;
import pe.com.synopsis.imgrabber.beans.request.UpdateEmployConfigRequest;

public interface ConfigBL
{

    public void updateEmployConfig(UpdateEmployConfigRequest employConfigRequest);

    public List<LoadEmployConfigDTO> loadEmployConfig(LoadEmployConfigRequest employConfigRequest);

}
