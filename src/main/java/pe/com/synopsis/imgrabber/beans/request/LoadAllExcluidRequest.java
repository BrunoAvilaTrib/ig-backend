
package pe.com.synopsis.imgrabber.beans.request;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

public class LoadAllExcluidRequest implements Serializable
{

    private static final long serialVersionUID = 6199174184179235346L;

    @NotNull
    private Long employFk;

    public Long getEmployFk()
    {
        return employFk;
    }

    public void setEmployFk(Long employFk)
    {
        this.employFk = employFk;
    }

}
