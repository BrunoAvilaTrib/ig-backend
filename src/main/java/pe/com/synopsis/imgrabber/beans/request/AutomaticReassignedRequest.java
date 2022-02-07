
package pe.com.synopsis.imgrabber.beans.request;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

public class AutomaticReassignedRequest
{

    @NotNull
    private Long employFK;

    @NotNull
    @Pattern(regexp = "^([0-2][0-9]|(3)[0-1])(\\/)(((0)[0-9])|((1)[0-2]))(\\/)\\d{4}$")
    private String date;

    public Long getEmployFK()
    {
        return employFK;
    }

    public void setEmployFK(Long employFK)
    {
        this.employFK = employFK;
    }

    public String getDate()
    {
        return date;
    }

    public void setDate(String date)
    {
        this.date = date;
    }

}
