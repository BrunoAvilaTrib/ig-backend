
package pe.com.synopsis.imgrabber.beans.request;

import java.io.Serializable;
import java.util.List;

public class ListChangeAssignedChatRequest implements Serializable
{

    private static final long serialVersionUID = -210316399640799959L;

    private List<ChangeAssignedChatRequest> changeAssignedChatRequest;

    public List<ChangeAssignedChatRequest> getChangeAssignedChatRequest()
    {
        return changeAssignedChatRequest;
    }

    public void setChangeAssignedChatRequest(List<ChangeAssignedChatRequest> changeAssignedChatRequest)
    {
        this.changeAssignedChatRequest = changeAssignedChatRequest;
    }

}
