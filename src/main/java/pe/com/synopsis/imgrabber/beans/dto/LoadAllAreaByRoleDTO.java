
package pe.com.synopsis.imgrabber.beans.dto;

import org.springframework.beans.BeanUtils;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import pe.com.synopsis.imgrabber.beans.domain.LoadAllAreaByRole;

@JsonInclude(Include.NON_NULL)
public class LoadAllAreaByRoleDTO
{

    private Long areaPK;
    private String name;

    public Long getAreaPK()
    {
        return areaPK;
    }

    public void setAreaPK(Long areaPK)
    {
        this.areaPK = areaPK;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public LoadAllAreaByRoleDTO(LoadAllAreaByRole loadAllAreaByRole)
    {
        BeanUtils.copyProperties(loadAllAreaByRole, this);
    }

}
