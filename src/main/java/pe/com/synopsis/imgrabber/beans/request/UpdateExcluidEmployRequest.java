
package pe.com.synopsis.imgrabber.beans.request;

import java.io.Serializable;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

public class UpdateExcluidEmployRequest implements Serializable
{

    private static final long serialVersionUID = -801839470273721707L;

    @NotNull
    private Long excluidEmployPk;

    @NotNull
    @Pattern(regexp = "^([0-2][0-9]|(3)[0-1])(\\/)(((0)[0-9])|((1)[0-2]))(\\/)\\d{4}$")
    private String startDate;

    @NotNull
    @Pattern(regexp = "^([0-2][0-9]|(3)[0-1])(\\/)(((0)[0-9])|((1)[0-2]))(\\/)\\d{4}$")
    private String endDate;

    @NotNull
    private Long employFk;

    public Long getExcluidEmployPk()
    {
        return excluidEmployPk;
    }

    public void setExcluidEmployPk(Long excluidEmployPk)
    {
        this.excluidEmployPk = excluidEmployPk;
    }

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

}
