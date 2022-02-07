
package pe.com.synopsis.imgrabber.beans.request;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

public class DefuseExcluidEmployRequest implements Serializable
{

    private static final long serialVersionUID = -3831910062551366186L;

    @NotNull
    private Long excluidEmployPk;

    public Long getExcluidEmployPk()
    {
        return excluidEmployPk;
    }

    public void setExcluidEmployPk(Long excluidEmployPk)
    {
        this.excluidEmployPk = excluidEmployPk;
    }

}
