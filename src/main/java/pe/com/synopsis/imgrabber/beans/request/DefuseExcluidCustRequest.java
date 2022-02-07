
package pe.com.synopsis.imgrabber.beans.request;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

public class DefuseExcluidCustRequest implements Serializable
{

    private static final long serialVersionUID = -1563132194359038515L;

    @NotNull
    private Long excluidCustPK;

    public Long getExcluidCustPK()
    {
        return excluidCustPK;
    }

    public void setExcluidCustPK(Long excluidCustPK)
    {
        this.excluidCustPK = excluidCustPK;
    }

}
