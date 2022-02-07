
package pe.com.synopsis.imgrabber.beans.request;

import java.io.Serializable;
import java.util.List;

public class ListDefuseChangeAssignedChatRequest implements Serializable
{

    private static final long serialVersionUID = 8560260704439969978L;

    private List<DefuseChangeAssignedChatRequest> listDefuseChangeAssignedChatRequest;

    public List<DefuseChangeAssignedChatRequest> getListDefuseChangeAssignedChatRequest()
    {
        return listDefuseChangeAssignedChatRequest;
    }

    public void setListDefuseChangeAssignedChatRequest(
            List<DefuseChangeAssignedChatRequest> listDefuseChangeAssignedChatRequest)
    {
        this.listDefuseChangeAssignedChatRequest = listDefuseChangeAssignedChatRequest;
    }

}
