
package pe.com.synopsis.imgrabber.beans.request;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

public class UpdateExcluid
{
    @NotNull
    private Long excluidPk;
    @Pattern(regexp = "^[0-9]{9,12}+$")
    @NotNull
    private String mobile;
    @NotNull
    @Pattern(regexp = "^[A-Za-z\\u00E1\\u00E9\\u00ED\\u00F3\\u00FA\\u00C1\\u00C9\\u00CD\\u00D3\\u00DA\\u00F1\\u00D1 ]{0,40}+$")
    private String Alias;
    @NotNull
    private Long employPk;

    public Long getExcluidPk()
    {
        return excluidPk;
    }

    public void setExcluidPk(Long excluidPk)
    {
        this.excluidPk = excluidPk;
    }

    public String getMobile()
    {
        return mobile;
    }

    public void setMobile(String mobile)
    {
        this.mobile = mobile;
    }

    public String getAlias()
    {
        return Alias;
    }

    public void setAlias(String Alias)
    {
        this.Alias = Alias;
    }

    public Long getEmployPk()
    {
        return employPk;
    }

    public void setEmployPk(Long employPk)
    {
        this.employPk = employPk;
    }

}
