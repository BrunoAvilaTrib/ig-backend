
package pe.com.synopsis.imgrabber.beans.request;

import java.io.Serializable;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import io.swagger.annotations.ApiModelProperty;

public class UpdateConfigRequest implements Serializable
{

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(notes = "Telefono del usuario")
    @NotNull
    @Pattern(regexp = "^[AB]{1,1}+$")
    private String estado;
    @ApiModelProperty(notes = "Nombre del usuario")
    @NotNull
    private Long personfk;
    @NotNull
    @Pattern(regexp = "^[A-Za-z\\u00E1\\u00E9\\u00ED\\u00F3\\u00FA\\u00C1\\u00C9\\u00CD\\u00D3\\u00DA\\u00F1\\u00D1 ]{3,50}+$")
    private String nombre;

    public String getEstado()
    {
        return estado;
    }

    public void setEstado(String estado)
    {
        this.estado = estado;
    }

    public Long getPersonfk()
    {
        return personfk;
    }

    public void setPersonfk(Long personfk)
    {
        this.personfk = personfk;
    }

    public String getNombre()
    {
        return nombre;
    }

    public void setNombre(String nombre)
    {
        this.nombre = nombre;
    }

}
