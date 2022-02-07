
package pe.com.synopsis.imgrabber.beans.dto;

import java.beans.Transient;
import org.springframework.beans.BeanUtils;
import org.springframework.security.core.GrantedAuthority;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.Data;
import pe.com.synopsis.imgrabber.beans.domain.LoadEmployLogin;

@Data
@JsonInclude(Include.NON_NULL)
public class EmployDTO implements GrantedAuthority
{

    private static final long serialVersionUID = -3672278819090200571L;

    private String name;
    private Long employPk;

    public EmployDTO()
    {

    }

    public EmployDTO(LoadEmployLogin loadEmployLogin)
    {
        BeanUtils.copyProperties(loadEmployLogin, this);
    }

    @Transient
    @Override
    public String getAuthority()
    {
        return name;
    }

}
