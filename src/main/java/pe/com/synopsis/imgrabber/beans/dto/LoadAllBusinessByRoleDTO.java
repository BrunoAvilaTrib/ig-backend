
package pe.com.synopsis.imgrabber.beans.dto;

import org.springframework.beans.BeanUtils;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import pe.com.synopsis.imgrabber.beans.domain.LoadAllBusinessByRole;

@JsonInclude(Include.NON_NULL)
public class LoadAllBusinessByRoleDTO
{

    private Long businessPK;
    private String name;

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

    public LoadAllBusinessByRoleDTO(LoadAllBusinessByRole loadAllBusinessByRole)
    {
        BeanUtils.copyProperties(loadAllBusinessByRole, this);
    }
}
