
package pe.com.synopsis.imgrabber.beans.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import pe.com.synopsis.imgrabber.beans.dto.RoleDTO;

@Data
@JsonInclude(Include.NON_NULL)
public class LoginResponse
{

    @ApiModelProperty(notes = "Id de sesi&oacute;n del usuario")

    private String sessionId;
    private String employ;
    private String email;
    private RoleDTO role;
    private String bussines;

}
