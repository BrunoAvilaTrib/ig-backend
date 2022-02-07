
package pe.com.synopsis.imgrabber.beans.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import pe.com.synopsis.imgrabber.beans.domain.LoadEmployConfig;

@JsonInclude(Include.NON_NULL)
public class EmployConfigDTO
{

    private long employFk;
    private long configFk;

    public EmployConfigDTO(LoadEmployConfig employConfig)
    {

        this.configFk = employConfig.getConfigFk();
        this.employFk = employConfig.getEmployFk();
    }

    public long getConfigFk()
    {
        return configFk;
    }

    public void setConfigFk(long username)
    {
        this.configFk = username;
    }

    public long getEmployFk()
    {
        return employFk;
    }

    public void setEmployFk(long idpriv)
    {
        this.employFk = idpriv;
    }

}
