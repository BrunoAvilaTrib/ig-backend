
package pe.com.synopsis.imgrabber.beans.request;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

public class UpdateAssignedRequest implements Serializable
{

    private static final long serialVersionUID = 8913383355089203766L;

    @NotNull
    private Long chatFK;

    @NotNull
    private Long employFK;

    public Long getChatFK()
    {
        return chatFK;
    }

    public void setChatFK(Long chatFK)
    {
        this.chatFK = chatFK;
    }

    public Long getEmployFK()
    {
        return employFK;
    }

    public void setEmployFK(Long employFK)
    {
        this.employFK = employFK;
    }

}
