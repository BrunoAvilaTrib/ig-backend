
package pe.com.synopsis.imgrabber.beans.dto;

import org.springframework.beans.BeanUtils;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import pe.com.synopsis.imgrabber.beans.domain.ValidateEmploy;

@JsonInclude(Include.NON_NULL)
public class ValidateEmployDTO
{

    private long employPk;
    private String login;
    private String password;
    private boolean accountNonLocked;

    public long getEmployPk()
    {
        return employPk;
    }

    public void setEmployPk(long employPk)
    {
        this.employPk = employPk;
    }

    public String getLogin()
    {
        return login;
    }

    public void setLogin(String login)
    {
        this.login = login;
    }

    public String getPassword()
    {
        return password;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }

    public boolean isAccountNonLocked()
    {
        return accountNonLocked;
    }

    public void setAccountNonLocked(boolean accountNonLocked)
    {
        this.accountNonLocked = accountNonLocked;
    }

    public ValidateEmployDTO()
    {
        super();
    }

    public ValidateEmployDTO(ValidateEmploy employ)
    {
        BeanUtils.copyProperties(employ, this);
    }

}
