
package pe.com.synopsis.imgrabber.beans.request;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

//import io.swagger.annotations.ApiModelProperty;

public class LoadEmployConfigRequest implements Serializable
{

    private static final long serialVersionUID = 1L;
    @NotNull
    private Long employPk;

    public Long getEmployPk()
    {
        return employPk;
    }

    public void setEmployPk(Long employPk)
    {
        this.employPk = employPk;
    }

}
