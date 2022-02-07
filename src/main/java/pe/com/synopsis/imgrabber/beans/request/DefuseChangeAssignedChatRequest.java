
package pe.com.synopsis.imgrabber.beans.request;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

public class DefuseChangeAssignedChatRequest implements Serializable
{

    private static final long serialVersionUID = -282620149838856410L;

    @NotNull
    private Long chatFK;

    public Long getChatFK()
    {
        return chatFK;
    }

    public void setChatFK(Long chatFK)
    {
        this.chatFK = chatFK;
    }

}
