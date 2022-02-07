
package pe.com.synopsis.imgrabber.beans.request;

import java.io.Serializable;

import javax.validation.constraints.Pattern;

import io.swagger.annotations.ApiModelProperty;

public class ResourceRequest implements Serializable
{
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(notes = "Telefono del usuario")
    @Pattern(regexp = "^[0-9]+$")
    private String idMessage;

    public String getIdMessage()
    {
        return idMessage;
    }

    public void setIdMessage(String idMessage)
    {
        this.idMessage = idMessage;
    }

}
