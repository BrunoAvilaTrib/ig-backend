
package pe.com.synopsis.imgrabber.beans.request;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

public class DefuseSupervisorRequest implements Serializable
{

    private static final long serialVersionUID = -1795002060828371865L;

    @NotNull
    private Long employPK;

    @NotNull
    private Long superEmployPK;

    public Long getEmployPK()
    {
        return employPK;
    }

    public void setEmployPK(Long employPK)
    {
        this.employPK = employPK;
    }


    public Long getSuperEmployPK()
    {
        return superEmployPK;
    }

    public void setSuperEmployPK(Long superEmployPK)
    {
        this.superEmployPK = superEmployPK;
    }


}