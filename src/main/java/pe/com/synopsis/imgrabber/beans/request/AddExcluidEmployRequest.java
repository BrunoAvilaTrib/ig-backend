
package pe.com.synopsis.imgrabber.beans.request;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

public class AddExcluidEmployRequest implements Serializable
{

    private static final long serialVersionUID = -3772053946605089972L;

    @NotNull
    private String startDate;

    @NotNull
    private String endDate;

    @NotNull
    private Long employFk;

    @NotNull
    private String reason;

    public String getStartDate()
    {
        return startDate;
    }

    public void setStartDate(String startDate)
    {
        this.startDate = startDate;
    }

    public String getEndDate()
    {
        return endDate;
    }

    public void setEndDate(String endDate)
    {
        this.endDate = endDate;
    }

    public Long getEmployFk()
    {
        return employFk;
    }

    public void setEmployFk(Long employFk)
    {
        this.employFk = employFk;
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
