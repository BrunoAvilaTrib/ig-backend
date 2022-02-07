
package pe.com.synopsis.imgrabber.beans.request;

import java.io.Serializable;

import javax.validation.Valid;

import io.swagger.annotations.ApiModelProperty;

public class LoadMessagesRequest implements Serializable
{
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(notes = "Telefono del usuario")
    @Valid
    private Long idChat;

    @ApiModelProperty(notes = "Telefono del usuario")
    private String page;

    public Long getIdChat()
    {
        return idChat;
    }

    public void setIdChat(Long idChat)
    {
        this.idChat = idChat;
    }

    public String getPage()
    {
        return page;
    }

    public void setPage(String page)
    {
        this.page = page;
    }

}
