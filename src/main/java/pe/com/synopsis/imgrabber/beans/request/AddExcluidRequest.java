
package pe.com.synopsis.imgrabber.beans.request;

import java.io.Serializable;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

public class AddExcluidRequest implements Serializable
{

    private static final long serialVersionUID = 1L;
    @NotNull
    @Pattern(regexp = "^[0-9]{9,12}+$")
    private String mobile;

    @NotNull
    @Pattern(regexp = "^[A-Za-z\\u00E1\\u00E9\\u00ED\\u00F3\\u00FA\\u00C1\\u00C9\\u00CD\\u00D3\\u00DA\\u00F1\\u00D1 ]{0,40}+$")
    private String alias;

    public String getMobile()
    {
        return mobile;
    }

    public void setMobile(String excluidMobile)
    {
        this.mobile = excluidMobile;
    }

    public String getAlias()
    {
        return alias;
    }

    public void setAlias(String excluidAlias)
    {
        this.alias = excluidAlias;
    }

}
