
package pe.com.synopsis.imgrabber.beans.request;

import java.io.Serializable;

public class LoadRoleRequest implements Serializable
{

    private static final long serialVersionUID = 1L;
    String username;

    public String getUsername()
    {
        return username;
    }

    public void setUsername(String username)
    {
        this.username = username;
    }

}
