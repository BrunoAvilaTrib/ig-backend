
package pe.com.synopsis.imgrabber.beans.dto;

import org.springframework.beans.BeanUtils;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import pe.com.synopsis.imgrabber.beans.domain.LoadPrivilege;

@JsonInclude(Include.NON_NULL)
public class LoadPrivilegeDTO
{

    private Long privilegePk;
    private String name;

    public Long getPrivilegePk()
    {
        return privilegePk;
    }

    public void setPrivilegePk(Long privilegePk)
    {
        this.privilegePk = privilegePk;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public LoadPrivilegeDTO()
    {
        super();
    }

    public LoadPrivilegeDTO(LoadPrivilege privilege)
    {
        BeanUtils.copyProperties(privilege, this);
    }

}
