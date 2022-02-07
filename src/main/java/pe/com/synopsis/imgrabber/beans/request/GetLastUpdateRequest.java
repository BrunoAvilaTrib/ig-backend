
package pe.com.synopsis.imgrabber.beans.request;

import java.io.Serializable;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

public class GetLastUpdateRequest implements Serializable
{

    private static final long serialVersionUID = 2688594189089037861L;

    @NotNull
    @Pattern(regexp = "^[0-9]{9}+$")
    private String offiPhone;

    @NotNull
    @Pattern(regexp = "^[0-9]{9}+$")
    private String custPhone;

    @NotNull
    @Pattern(regexp = "^[0-9A-Za-z\\u00E1\\u00E9\\u00ED\\u00F3\\u00FA\\u00C1\\u00C9\\u00CD\\u00D3\\u00DA\\u00F1\\u00D1 ]{3,200}+$")
    private String custName;

    public String getOffiPhone()
    {
        return offiPhone;
    }

    public void setOffiPhone(String offiPhone)
    {
        this.offiPhone = offiPhone;
    }

    public String getCustPhone()
    {
        return custPhone;
    }

    public void setCustPhone(String custPhone)
    {
        this.custPhone = custPhone;
    }

    public String getCustName()
    {
        return custName;
    }

    public void setCustName(String custName)
    {
        this.custName = custName;
    }

}
