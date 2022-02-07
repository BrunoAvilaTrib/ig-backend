
package pe.com.synopsis.imgrabber.beans.request;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

public class UploadPhotoRequest implements Serializable
{

    private static final long serialVersionUID = -8358033778938159744L;

    @NotNull
    private Long idChat;

    @NotNull
    private String photo;

    @NotNull
    private Integer mode;

    public Long getIdChat()
    {
        return idChat;
    }

    public void setIdChat(Long idChat)
    {
        this.idChat = idChat;
    }

    public String getPhoto()
    {
        return photo;
    }

    public void setPhoto(String photo)
    {
        this.photo = photo;
    }

    public Integer getMode()
    {
        return mode;
    }

    public void setMode(Integer mode)
    {
        this.mode = mode;
    }

}
