
package pe.com.synopsis.imgrabber.beans.request;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import io.swagger.annotations.ApiModelProperty;

@JsonInclude(Include.NON_NULL)
public class NameRequestPROBANDO implements Serializable
{

    private static final long serialVersionUID = 1L;

    @NotNull
    @ApiModelProperty(notes = "Id de session")
    private String mesajeenviado;

    public NameRequestPROBANDO()
    {
        super();
    }

    public String getMesajeenviado()
    {
        return mesajeenviado;
    }

    public void setMesajeenviado(String mesajeenviado)
    {
        this.mesajeenviado = mesajeenviado;
    }

    public static long getSerialversionuid()
    {
        return serialVersionUID;
    }

}
