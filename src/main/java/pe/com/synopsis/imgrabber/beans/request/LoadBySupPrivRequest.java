
package pe.com.synopsis.imgrabber.beans.request;

import java.io.Serializable;

public class LoadBySupPrivRequest implements Serializable
{
    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    private String employLogin;

    public String getEmployLogin()
    {
        return employLogin;
    }

    public void setEmployLogin(String employLogin)
    {
        this.employLogin = employLogin;
    }

}
