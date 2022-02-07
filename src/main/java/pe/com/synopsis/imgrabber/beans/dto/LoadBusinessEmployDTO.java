
package pe.com.synopsis.imgrabber.beans.dto;

import org.springframework.beans.BeanUtils;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import pe.com.synopsis.imgrabber.beans.domain.LoadBusinessLogin;

@JsonInclude(Include.NON_NULL)
public class LoadBusinessEmployDTO
{

    private String name;
    private Long businessPk;

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public Long getBusinessPk()
    {
        return businessPk;
    }

    public void setBusinessPk(Long businessPk)
    {
        this.businessPk = businessPk;
    }

    public LoadBusinessEmployDTO(LoadBusinessLogin loadBusiness)
    {
        BeanUtils.copyProperties(loadBusiness, this);
    }
}