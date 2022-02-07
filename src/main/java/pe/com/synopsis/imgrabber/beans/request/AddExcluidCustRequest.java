
package pe.com.synopsis.imgrabber.beans.request;

import java.io.Serializable;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

public class AddExcluidCustRequest implements Serializable
{

    private static final long serialVersionUID = 7199105863533104218L;

    @NotNull
    @Pattern(regexp = "^[0-9]{9}+$")
    private String phoneCust;

    @NotNull
    @Pattern(regexp = "^[0-9A-Za-z\\u00E1\\u00E9\\u00ED\\u00F3\\u00FA\\u00C1\\u00C9\\u00CD\\u00D3\\u00DA\\u00F1\\u00D1 ]{3,300}+$")
    private String reason;

    public String getPhoneCust()
    {
        return phoneCust;
    }

    public void setPhoneCust(String phoneCust)
    {
        this.phoneCust = phoneCust;
    }

    public String getReason()
    {
        return reason;
    }

    public void setReason(String reason)
    {
        this.reason = reason;
    }

}
