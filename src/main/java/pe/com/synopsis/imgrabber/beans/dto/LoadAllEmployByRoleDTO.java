
package pe.com.synopsis.imgrabber.beans.dto;

import org.springframework.beans.BeanUtils;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import pe.com.synopsis.imgrabber.beans.domain.LoadAllEmployByRole;

@JsonInclude(Include.NON_NULL)
public class LoadAllEmployByRoleDTO
{

    private Long employPK;
    private String nameEmploy;

    public Long getEmployPK()
    {
        return employPK;
    }

    public void setEmployPK(Long employPK)
    {
        this.employPK = employPK;
    }

    public String getNameEmploy()
    {
        return nameEmploy;
    }

    public void setNameEmploy(String nameEmploy)
    {
        this.nameEmploy = nameEmploy;
    }

    public LoadAllEmployByRoleDTO(LoadAllEmployByRole loadAllEmployByRole)
    {
        BeanUtils.copyProperties(loadAllEmployByRole, this);
    }
}
