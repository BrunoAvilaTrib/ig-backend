
package pe.com.synopsis.imgrabber.dao;

import java.util.List;

import pe.com.synopsis.imgrabber.beans.domain.LoadEmployConfig;
import pe.com.synopsis.imgrabber.beans.request.LoadEmployConfigRequest;
import pe.com.synopsis.imgrabber.beans.request.UpdateEmployConfigRequest;

public interface ConfigDAO
{

    public void updateEmployConfig(UpdateEmployConfigRequest employConfigRequest);

    public List<LoadEmployConfig> loadEmployConfig(LoadEmployConfigRequest employConfigRequest);

}
