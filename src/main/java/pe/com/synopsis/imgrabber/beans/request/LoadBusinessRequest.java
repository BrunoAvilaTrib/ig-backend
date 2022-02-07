
package pe.com.synopsis.imgrabber.beans.request;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

public class LoadBusinessRequest implements Serializable
{

    private static final long serialVersionUID = -2892707845806080777L;

    @NotNull
    private Long businessPK;

    public Long getBusinessPK()
    {
        return businessPK;
    }

    public void setBusinessPK(Long businessPK)
    {
        this.businessPK = businessPK;
    }

}
