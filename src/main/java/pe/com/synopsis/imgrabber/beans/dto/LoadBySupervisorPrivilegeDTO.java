
package pe.com.synopsis.imgrabber.beans.dto;

import org.springframework.beans.BeanUtils;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import pe.com.synopsis.imgrabber.beans.domain.LoadBySupervisorPrivilege;

@JsonInclude(Include.NON_NULL)
public class LoadBySupervisorPrivilegeDTO
{

    private long employPk;
    private long privilegePk;
    private String name;
    private String state;

    public long getEmployPk()
    {
        return employPk;
    }

    public void setEmployPk(long employPk)
    {
        this.employPk = employPk;
    }

    public long getPrivilegePk()
    {
        return privilegePk;
    }

    public void setPrivilegePk(long privilegePk)
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

    public String getState()
    {
        return state;
    }

    public void setState(String state)
    {
        this.state = state;
    }

    public LoadBySupervisorPrivilegeDTO()
    {
        super();
    }

    public LoadBySupervisorPrivilegeDTO(LoadBySupervisorPrivilege employ)
    {
        BeanUtils.copyProperties(employ, this);
    }

}
