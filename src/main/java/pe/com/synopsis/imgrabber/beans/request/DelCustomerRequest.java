
package pe.com.synopsis.imgrabber.beans.request;

import java.io.Serializable;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import io.swagger.annotations.ApiModelProperty;

public class DelCustomerRequest implements Serializable
{
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(notes = "Telefono del usuario")

    @Pattern(regexp = "^[0-9]+$")
    @NotNull
    private String idCustomer;

    public String getIdCustomer()
    {
        return idCustomer;
    }

    public void setIdCustomer(String officerId)
    {
        this.idCustomer = officerId;
    }

}
