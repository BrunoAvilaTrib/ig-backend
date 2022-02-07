
package pe.com.synopsis.imgrabber.beans.request;

import java.io.Serializable;
import java.util.List;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

public class UpdateOfficerEmployRequest implements Serializable
{

    private static final long serialVersionUID = 1L;

    @NotNull
    private Long employPk;

    @NotNull
    private String password;

    @NotNull
    @Pattern(regexp = "^[0-9A-Za-z\\u00E1\\u00E9\\u00ED\\u00F3\\u00FA\\u00C1\\u00C9\\u00CD\\u00D3\\u00DA\\u00F1\\u00D1 ]{3,100}+$")
    private String name;

    @NotNull
    @Pattern(regexp = "^[0-9A-Za-z\\u00E1\\u00E9\\u00ED\\u00F3\\u00FA\\u00C1\\u00C9\\u00CD\\u00D3\\u00DA\\u00F1\\u00D1 ]{3,60}+$")
    private String apePat;

    @NotNull
    @Pattern(regexp = "^[0-9A-Za-z\\u00E1\\u00E9\\u00ED\\u00F3\\u00FA\\u00C1\\u00C9\\u00CD\\u00D3\\u00DA\\u00F1\\u00D1 ]{3,60}+$")
    private String apeMat;

    @Pattern(regexp = "^[FM]{1,1}+$")
    @NotNull
    private String sex;

    @NotNull
    @Pattern(regexp = "^[0-9]{9,12}+$")
    private String mobile;

    @NotNull
    @Pattern(regexp = "^\\S{1,}@\\S{2,}\\.\\S{2,}$")
    private String email;

    @NotNull
    private Long areaFk;

    @NotNull
    private Long employFk;

    @Pattern(regexp = "^[AB]{1,1}+$")
    @NotNull
    private String stateConfig;

  

    public Long getEmployPk()
    {
        return employPk;
    }

    public void setEmployPk(Long employPk)
    {
        this.employPk = employPk;
    }

    public String getPassword()
    {
        return password;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getApePat()
    {
        return apePat;
    }

    public void setApePat(String apePat)
    {
        this.apePat = apePat;
    }

    public String getApeMat()
    {
        return apeMat;
    }

    public void setApeMat(String apeMat)
    {
        this.apeMat = apeMat;
    }

    public String getSex()
    {
        return sex;
    }

    public void setSex(String sex)
    {
        this.sex = sex;
    }

    public String getMobile()
    {
        return mobile;
    }

    public void setMobile(String mobile)
    {
        this.mobile = mobile;
    }

    public String getEmail()
    {
        return email;
    }

    public void setEmail(String email)
    {
        this.email = email;
    }

    public Long getAreaFk()
    {
        return areaFk;
    }

    public void setAreaFk(Long areaFk)
    {
        this.areaFk = areaFk;
    }

    public Long getEmployFk()
    {
        return employFk;
    }

    public void setEmployFk(Long employFk)
    {
        this.employFk = employFk;
    }

  public String getStateConfig()
  {
       return stateConfig;
   }

    public void setStateConfig(String stateConfig)
   {
       this.stateConfig = stateConfig;
   }

  
}
