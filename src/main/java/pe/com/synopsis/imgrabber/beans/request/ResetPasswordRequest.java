package pe.com.synopsis.imgrabber.beans.request;

import java.io.Serializable;

public class ResetPasswordRequest implements Serializable
{

    private static final long serialVersionUID = -7738076455464082744L;

    private String token;
    private String oldPassword;
    private String newPassword;
    
    public String getToken()
    {
        return token;
    }
    public void setToken(String token)
    {
        this.token = token;
    }
    public String getOldPassword()
    {
        return oldPassword;
    }
    public void setOldPassword(String oldPassword)
    {
        this.oldPassword = oldPassword;
    }
    public String getNewPassword()
    {
        return newPassword;
    }
    public void setNewPassword(String newPassword)
    {
        this.newPassword = newPassword;
    }
    
}
