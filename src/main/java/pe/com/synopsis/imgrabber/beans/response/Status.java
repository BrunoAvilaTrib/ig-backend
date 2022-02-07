
package pe.com.synopsis.imgrabber.beans.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;

import io.swagger.annotations.ApiModelProperty;

@JsonRootName(value = "status")
public class Status
{
    @JsonProperty
    @ApiModelProperty(notes = "Indica el c&oacute;digo del estado la operaci&oacute;n")
    private String code;
    @JsonProperty
    @ApiModelProperty(notes = "Indica el mensaje del estado la operación")
    private String message;

    public Status(String code, String message)
    {
        this.code = code;
        this.message = message;
    }

    public String getCode()
    {
        return code;
    }

    public void setCode(String code)
    {
        this.code = code;
    }

    public String getMessage()
    {
        return message;
    }

    public void setMessage(String message)
    {
        this.message = message;
    }
}
