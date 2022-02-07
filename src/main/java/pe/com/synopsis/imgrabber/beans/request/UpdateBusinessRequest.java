
package pe.com.synopsis.imgrabber.beans.request;

import java.io.Serializable;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

public class UpdateBusinessRequest implements Serializable
{

    private static final long serialVersionUID = 1585535288266047748L;

    @NotNull
    private Long businessPK;

    @NotNull
    @Pattern(regexp = "^[0-9A-Za-z\\u00E1\\u00E9\\u00ED\\u00F3\\u00FA\\u00C1\\u00C9\\u00CD\\u00D3\\u00DA\\u00F1\\u00D1 ]{3,100}+$")
    private String name;

    @NotNull
    @Pattern(regexp = "^[0-9]{11,20}+$")
    private String ruc;

    @NotNull
    @Pattern(regexp = "^[AB]{1,1}+$")
    private String state;

    public Long getBusinessPK()
    {
        return businessPK;
    }

    public void setBusinessPK(Long businessPK)
    {
        this.businessPK = businessPK;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getRuc()
    {
        return ruc;
    }

    public void setRuc(String ruc)
    {
        this.ruc = ruc;
    }

    public String getState()
    {
        return state;
    }

    public void setState(String state)
    {
        this.state = state;
    }

}
