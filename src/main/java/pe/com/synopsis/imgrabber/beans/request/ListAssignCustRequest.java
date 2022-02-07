
package pe.com.synopsis.imgrabber.beans.request;

import java.io.Serializable;

import io.swagger.annotations.ApiModelProperty;

public class ListAssignCustRequest implements Serializable
{
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(notes = "Telefono del usuario")
    private String idOfficer;

    public String getIdOfficer()
    {
        return idOfficer;
    }

    public void setIdOfficer(String officerId)
    {
        this.idOfficer = officerId;
    }

}
