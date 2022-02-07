
package pe.com.synopsis.imgrabber.beans.request;

import java.io.Serializable;

import io.swagger.annotations.ApiModelProperty;

public class LoadCustomerRequest implements Serializable
{
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(notes = "Telefono del usuario")
    private String userPhone;

    @ApiModelProperty(notes = "Nombre del usuario")
    private String userName;

    public String getUserPhone()
    {
        return userPhone;
    }

    public void setUserPhone(String userPhone)
    {
        this.userPhone = userPhone;
    }

    public String getUserName()
    {
        return userName;
    }

    public void setUserName(String userName)
    {
        this.userName = userName;
    }

}
