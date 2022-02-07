
package pe.com.synopsis.imgrabber.beans.request;

import java.io.Serializable;

import javax.validation.constraints.Pattern;

import io.swagger.annotations.ApiModelProperty;

public class LoadPagesRequest implements Serializable
{
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(notes = "Telefono del usuario")
    @Pattern(regexp = "^[0-9]+$")
    private String idChat;

    public String getIdChat()
    {
        return idChat;
    }

    public void setIdChat(String chatId)
    {
        this.idChat = chatId;
    }

}
