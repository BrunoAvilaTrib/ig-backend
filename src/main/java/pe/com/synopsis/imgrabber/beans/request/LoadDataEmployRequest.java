
package pe.com.synopsis.imgrabber.beans.request;

import java.io.Serializable;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

public class LoadDataEmployRequest implements Serializable
{

    private static final long serialVersionUID = 1L;

    @NotNull
    @Pattern(regexp = "^[a-zA-Z]{5,20}+$")
    private String login;

    public String getLogin()
    {
        return login;
    }

    public void setLogin(String login)
    {
        this.login = login;
    }

}
