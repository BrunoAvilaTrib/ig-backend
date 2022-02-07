
package pe.com.synopsis.imgrabber.beans.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import io.swagger.annotations.ApiModelProperty;

@JsonInclude(value = Include.NON_NULL)
public class Response<T>
{

    @ApiModelProperty(notes = "Objeto Status que indica el estado de la operaci&oacute;n")
    private Status status;
    @ApiModelProperty(notes = "Objeto data que contiene la informaci&oacute;n &uacute;til de la operaci&acute;n")
    private T data;

    public Status getStatus()
    {
        return status;
    }

    public void setStatus(Status status)
    {
        this.status = status;
    }

    public T getData()
    {
        return data;
    }

    public void setData(T data)
    {
        this.data = data;
    }

}
