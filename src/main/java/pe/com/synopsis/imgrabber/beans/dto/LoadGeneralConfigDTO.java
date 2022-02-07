
package pe.com.synopsis.imgrabber.beans.dto;

import org.springframework.beans.BeanUtils;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import pe.com.synopsis.imgrabber.beans.domain.LoadGeneralConfig;

@JsonInclude(Include.NON_NULL)
public class LoadGeneralConfigDTO
{

    private long generalConfigPk;
    private String name;
    private String state;

    public long getGeneralConfigPk()
    {
        return generalConfigPk;
    }

    public void setGeneralConfigPk(long generalConfigPk)
    {
        this.generalConfigPk = generalConfigPk;
    }

    public String getName()
    {
        return this.name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getState()
    {
        return this.state;
    }

    public void setState(String state)
    {
        this.state = state;
    }

    public LoadGeneralConfigDTO()
    {
        super();
    }

    public LoadGeneralConfigDTO(LoadGeneralConfig generalConfig)
    {
        BeanUtils.copyProperties(generalConfig, this);
    }

}
