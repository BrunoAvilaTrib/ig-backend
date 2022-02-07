
package pe.com.synopsis.imgrabber.beans.request;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

public class LoadChatsReassignedEmployRequest implements Serializable
{

    private static final long serialVersionUID = 6505107506283616132L;

    @NotNull
    private Long employPK;

    public Long getEmployPK()
    {
        return employPK;
    }

    public void setEmployPK(Long employPK)
    {
        this.employPK = employPK;
    }

}
