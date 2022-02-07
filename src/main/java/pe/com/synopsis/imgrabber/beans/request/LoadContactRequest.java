
package pe.com.synopsis.imgrabber.beans.request;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

import io.swagger.annotations.ApiModelProperty;

public class LoadContactRequest implements Serializable
{
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(notes = "Telefono del usuario")
    @NotNull
    private Long idOfficer;

    public Long getIdOfficer()
    {
        return idOfficer;
    }

    public void setIdOfficer(Long idOfficer)
    {
        this.idOfficer = idOfficer;
    }

}
