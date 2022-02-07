
package pe.com.synopsis.imgrabber.beans.request;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

public class UpdateAdminGlobalPasswordRequest implements Serializable
{

    private static final long serialVersionUID = 3615911019424099972L;

    @NotNull
    private String password;

    @NotNull
    private Long employPK;

    public String getPassword()
    {
        return password;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }

    public Long getEmployPK()
    {
        return employPK;
    }

    public void setEmployPK(Long employPK)
    {
        this.employPK = employPK;
    }

}
