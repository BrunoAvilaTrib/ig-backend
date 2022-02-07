
package pe.com.synopsis.imgrabber.beans.request;

import java.io.Serializable;

import io.swagger.annotations.ApiModelProperty;

public class AssignCustomerRequest implements Serializable
{
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(notes = "Telefono del usuario")
    private String idOfficer;

    @ApiModelProperty(notes = "Nombre del usuario")
    private String idCustomer;

    @ApiModelProperty(notes = "Activar (A) o desactivar (I) chat")
    private String state;

    public String getIdOfficer()
    {
        return idOfficer;
    }

    public void setIdOfficer(String officerId)
    {
        this.idOfficer = officerId;
    }

    public String getIdCustomer()
    {
        return idCustomer;
    }

    public void setIdCustomer(String customerId)
    {
        this.idCustomer = customerId;
    }

    public String getState()
    {
        return state;
    }

    public void setState(String state)
    {
        this.state = state;
    }

}
