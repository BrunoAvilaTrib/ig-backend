
package pe.com.synopsis.imgrabber.beans.request;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

import io.swagger.annotations.ApiModelProperty;

public class DeleteAllExcluidEmployRequest implements Serializable
{

    private static final long serialVersionUID = 1L;
    @ApiModelProperty(notes = "id del usuario a eliminar")
    @NotNull
    private Long employPk;

    public Long getEmployPk()
    {
        return employPk;
    }

    public void setEmployPk(Long emploPk)
    {
        this.employPk = emploPk;
    }

}
