
package pe.com.synopsis.imgrabber.beans.dto;

import java.beans.Transient;

import org.springframework.beans.BeanUtils;
import org.springframework.security.core.GrantedAuthority;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import pe.com.synopsis.imgrabber.beans.domain.LoadRole;

@JsonInclude(Include.NON_NULL)
public class RoleDTO implements GrantedAuthority
{

    private static final long serialVersionUID = 1L;
    private Long rolePk;
    private String name;

    public RoleDTO()
    {

    }

    public RoleDTO(LoadRole role)
    {
        BeanUtils.copyProperties(role, this);
    }

    public long getRolePk()
    {
        return rolePk;
    }

    public void setRolePk(long rolePk)
    {
        this.rolePk = rolePk;
    }

    @Override
    public String getAuthority()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    @Transient
    public String getName()
    {
        return name;
    }

}
