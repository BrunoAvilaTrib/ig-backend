
package pe.com.synopsis.imgrabber.beans.dto;

import org.springframework.beans.BeanUtils;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import pe.com.synopsis.imgrabber.beans.domain.LoadRole;

@JsonInclude(Include.NON_NULL)
public class LoadRoleDTO
{

    private String name;
    private Long rolePk;

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public Long getRolePk()
    {
        return rolePk;
    }

    public void setRolePk(Long rolePk)
    {
        this.rolePk = rolePk;
    }

    public LoadRoleDTO(LoadRole source)
    {
        BeanUtils.copyProperties(source, this);
    }

}
