
package pe.com.synopsis.imgrabber.beans.request;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

public class LoadAreaRequest implements Serializable
{

    private static final long serialVersionUID = 1L;

    @NotNull
    private Long areaPk;

    public Long getAreaPk()
    {
        return areaPk;
    }

    public void setAreaPk(Long areaPk)
    {
        this.areaPk = areaPk;
    }

}
