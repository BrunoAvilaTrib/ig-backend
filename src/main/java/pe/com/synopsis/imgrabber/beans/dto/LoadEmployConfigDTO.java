
package pe.com.synopsis.imgrabber.beans.dto;

import org.springframework.beans.BeanUtils;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import pe.com.synopsis.imgrabber.beans.domain.LoadEmployConfig;

@JsonInclude(Include.NON_NULL)
public class LoadEmployConfigDTO
{

    private long configFk;
    private long employFk;
    private String name;
    private String advanceConfig;
    private String state;

    public long getConfigFk()
    {
        return configFk;
    }

    public void setConfigFk(long configFk)
    {
        this.configFk = configFk;
    }

    public long getEmployFk()
    {
        return employFk;
    }

    public void setEmployFk(long employFk)
    {
        this.employFk = employFk;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getAdvanceConfig()
    {
        return advanceConfig;
    }

    public void setAdvanceConfig(String advanceConfig)
    {
        this.advanceConfig = advanceConfig;
    }

    public String getState()
    {
        return state;
    }

    public void setState(String state)
    {
        this.state = state;
    }

    public LoadEmployConfigDTO()
    {
        super();
    }

    public LoadEmployConfigDTO(LoadEmployConfig employConfig)
    {
        BeanUtils.copyProperties(employConfig, this);
    }

}
