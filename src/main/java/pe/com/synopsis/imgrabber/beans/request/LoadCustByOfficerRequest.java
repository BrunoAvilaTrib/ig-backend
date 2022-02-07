
package pe.com.synopsis.imgrabber.beans.request;

import java.io.Serializable;

import io.swagger.annotations.ApiModelProperty;

public class LoadCustByOfficerRequest implements Serializable
{
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(notes = "Telefono del usuario")
    private String userPhone;

    @ApiModelProperty(notes = "Nombre del usuario")
    private String userName;

    @ApiModelProperty(notes = "Codigo de funcionario")
    private String idOfficer;

    public String getIdOfficer()
    {
        return idOfficer;
    }

    public void setIdOfficer(String idOfficer)
    {
        this.idOfficer = idOfficer;
    }

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
