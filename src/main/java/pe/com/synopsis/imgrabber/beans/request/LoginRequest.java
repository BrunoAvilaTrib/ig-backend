
package pe.com.synopsis.imgrabber.beans.request;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import io.swagger.annotations.ApiModelProperty;

public class LoginRequest implements Serializable
{

    private static final long serialVersionUID = 1L;

    @NotNull
    @ApiModelProperty(notes = "login del usuario")
    @Pattern(regexp = "^\\S{1,}@\\S{2,}\\.\\S{2,}$")
    private String email;

    @NotNull
    private String password;

    @ApiModelProperty(notes = "variable que indica la versi&oacute;n de la aplicaci&oacute;n")
    private BigDecimal appVersion;

    public String getEmail()
    {
        return email;
    }

    public void setEmail(String email)
    {
        this.email = email;
    }

    public String getPassword()
    {
        return password;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }

    public BigDecimal getAppVersion()
    {
        return appVersion;
    }

    public void setAppVersion(BigDecimal appVersion)
    {
        this.appVersion = appVersion;
    }

}
