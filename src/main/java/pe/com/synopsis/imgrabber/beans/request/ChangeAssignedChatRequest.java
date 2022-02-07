
package pe.com.synopsis.imgrabber.beans.request;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

public class ChangeAssignedChatRequest implements Serializable
{

    private static final long serialVersionUID = -3899565832907399372L;

    @NotNull
    private Long chatFK;

    @NotNull
    private Long reasignedEmployFK;

    public Long getChatFK()
    {
        return chatFK;
    }

    public void setChatFK(Long chatFK)
    {
        this.chatFK = chatFK;
    }

    public Long getReasignedEmployFK()
    {
        return reasignedEmployFK;
    }

    public void setReasignedEmployFK(Long reasignedEmployFK)
    {
        this.reasignedEmployFK = reasignedEmployFK;
    }

}
