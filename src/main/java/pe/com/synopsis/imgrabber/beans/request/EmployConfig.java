
package pe.com.synopsis.imgrabber.beans.request;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

public class EmployConfig
{
    @NotNull
    private Long configPk;
    @NotNull
    private Long employPk;
    @Pattern(regexp = "^[AB]{1,1}+$")
    private String state;

    public Long getConfigPk()
    {
        return configPk;
    }

    public void setConfigPk(Long configPk)
    {
        this.configPk = configPk;
    }

    public Long getEmployPk()
    {
        return employPk;
    }

    public void setEmployPk(Long employPk)
    {
        this.employPk = employPk;
    }

    public String getState()
    {
        return state;
    }

    public void setState(String state)
    {
        this.state = state;
    }

}
