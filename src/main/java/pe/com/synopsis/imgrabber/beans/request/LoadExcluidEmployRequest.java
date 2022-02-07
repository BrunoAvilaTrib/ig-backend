
package pe.com.synopsis.imgrabber.beans.request;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

import io.swagger.annotations.ApiModelProperty;

public class LoadExcluidEmployRequest implements Serializable
{

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(notes = "Codigo del Empleado.")
    @NotNull
    private Long excluidEmployPK;

    public Long getExcluidEmployPK()
    {
        return excluidEmployPK;
    }

    public void setExcluidEmployPK(Long excluidEmployPK)
    {
        this.excluidEmployPK = excluidEmployPK;
    }

}
