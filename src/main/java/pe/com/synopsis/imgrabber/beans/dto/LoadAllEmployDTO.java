
package pe.com.synopsis.imgrabber.beans.dto;

import org.springframework.beans.BeanUtils;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import pe.com.synopsis.imgrabber.beans.domain.LoadAllEmploy;

@JsonInclude(Include.NON_NULL)
public class LoadAllEmployDTO
{

    private Long employPk;
    private String nameEnploy;
    private String nameRole;
    private String email;
    private String mobile;
    private String nameArea;
    private String date;
    private String sex;

    public Long getEmployPk()
    {
        return employPk;
    }

    public void setEmployPk(Long employPk)
    {
        this.employPk = employPk;
    }

    public String getNameEnploy()
    {
        return nameEnploy;
    }

    public void setNameEnploy(String nameEnploy)
    {
        this.nameEnploy = nameEnploy;
    }

    public String getNameRole()
    {
        return nameRole;
    }

    public void setNameRole(String nameRole)
    {
        this.nameRole = nameRole;
    }

    public String getEmail()
    {
        return email;
    }

    public void setEmail(String email)
    {
        this.email = email;
    }

    public String getMobile()
    {
        return mobile;
    }

    public void setMobile(String mobile)
    {
        this.mobile = mobile;
    }

    public String getNameArea()
    {
        return nameArea;
    }

    public void setNameArea(String nameArea)
    {
        this.nameArea = nameArea;
    }

    public String getDate()
    {
        return date;
    }

    public void setDate(String date)
    {
        this.date = date;
    }

    public String getSex()
    {
        return sex;
    }

    public void setSex(String sex)
    {
        this.sex = sex;
    }

    public LoadAllEmployDTO(LoadAllEmploy employ)
    {
        BeanUtils.copyProperties(employ, this);
    }

}
