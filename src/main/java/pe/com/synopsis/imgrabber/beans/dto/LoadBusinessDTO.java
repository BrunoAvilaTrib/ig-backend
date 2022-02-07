
package pe.com.synopsis.imgrabber.beans.dto;

import org.springframework.beans.BeanUtils;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import pe.com.synopsis.imgrabber.beans.domain.LoadBusiness;

@JsonInclude(Include.NON_NULL)
public class LoadBusinessDTO
{

    private Long businessPK;
    private String name;
    private String state;
    private String ruc;
    private String email;

    public Long getBusinessPK()
    {
        return businessPK;
    }

    public void setBusinessPK(Long businessPK)
    {
        this.businessPK = businessPK;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getState()
    {
        return state;
    }

    public void setState(String state)
    {
        this.state = state;
    }

    public String getRuc()
    {
        return ruc;
    }

    public void setRuc(String ruc)
    {
        this.ruc = ruc;
    }

    public String getEmail()
    {
        return email;
    }

    public void setEmail(String email)
    {
        this.email = email;
    }

    public LoadBusinessDTO(LoadBusiness loadBusiness)
    {
        BeanUtils.copyProperties(loadBusiness, this);
    }
}
