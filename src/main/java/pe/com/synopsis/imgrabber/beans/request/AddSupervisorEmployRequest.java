
package pe.com.synopsis.imgrabber.beans.request;

import java.io.Serializable;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import lombok.Data;

@Data
public class AddSupervisorEmployRequest implements Serializable
{

    private static final long serialVersionUID = 1L;

    @NotNull
    @Pattern(regexp = "^[0-9A-Za-z\\u00E1\\u00E9\\u00ED\\u00F3\\u00FA\\u00C1\\u00C9\\u00CD\\u00D3\\u00DA\\u00F1\\u00D1 ]{3,100}+$")
    private String name;

    @NotNull
    @Pattern(regexp = "^[0-9A-Za-z\\u00E1\\u00E9\\u00ED\\u00F3\\u00FA\\u00C1\\u00C9\\u00CD\\u00D3\\u00DA\\u00F1\\u00D1 ]{3,60}+$")
    private String apePat;

    @NotNull
    @Pattern(regexp = "^[0-9A-Za-z\\u00E1\\u00E9\\u00ED\\u00F3\\u00FA\\u00C1\\u00C9\\u00CD\\u00D3\\u00DA\\u00F1\\u00D1 ]{3,60}+$")
    private String apeMat;

    @NotNull
    @Pattern(regexp = "^\\S{1,}@\\S{2,}\\.\\S{2,}$")
    private String email;

    @NotNull
    private String password;

    @Pattern(regexp = "^[FM]{1,1}+$")
    @NotNull
    private String sex;

    @NotNull
    @Pattern(regexp = "^[0-9]{9,9}+$")
    private String mobile;

    @NotNull
    private Long roleFK;

    @NotNull
    private Long businessFK;

    @NotNull
    private Long areaFK;

    @NotNull
    @Pattern(regexp = "^[AB]{1,1}+$")
    private String statePrivilege;

}