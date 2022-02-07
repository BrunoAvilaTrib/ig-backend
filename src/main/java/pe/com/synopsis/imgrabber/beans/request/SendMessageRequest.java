
package pe.com.synopsis.imgrabber.beans.request;

import java.io.Serializable;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SendMessageRequest implements Serializable
{

    private static final long serialVersionUID = -2968905277435750825L;

    @NotNull
    private String chatMobile;

    @NotNull
    private Long chatFK;

    @NotNull
    private Long employFK;

    @NotNull
    @Pattern(regexp = "^[0-9A-Za-z\\u00E1\\u00E9\\u00ED\\u00F3\\u00FA\\u00C1\\u00C9\\u00CD\\u00D3\\u00DA\\u00F1\\u00D1 ]{3,200}+$")
    private String toUser;

    @NotNull
    @Pattern(regexp = "^[0-9A-Za-z\\u00E1\\u00E9\\u00ED\\u00F3\\u00FA\\u00C1\\u00C9\\u00CD\\u00D3\\u00DA\\u00F1\\u00D1 ]{3,200}+$")
    private String toAlias;

    @NotNull
    private String msgText;

    @Pattern(regexp = "^([0-2][0-9]|(3)[0-1])(\\/)(((0)[0-9])|((1)[0-2]))(\\/)\\d{4}$")
    private String msgDate;

    @Pattern(regexp = "^(0[0-9]|1[0-9]|2[0-3])(:[0-5][0-9])$")
    private String msgHour;

    @NotNull
    @Pattern(regexp = "^[0-9A-Za-z\\u00E1\\u00E9\\u00ED\\u00F3\\u00FA\\u00C1\\u00C9\\u00CD\\u00D3\\u00DA\\u00F1\\u00D1 ]{3,200}+$")
    private String hashMsg;

    @NotNull
    @Pattern(regexp = "^[0-9A-Za-z\\u00E1\\u00E9\\u00ED\\u00F3\\u00FA\\u00C1\\u00C9\\u00CD\\u00D3\\u00DA\\u00F1\\u00D1 ]{3,3}+$")
    private String modeMsg;

    @Pattern(regexp = "^[0-9A-Za-z\\u00E1\\u00E9\\u00ED\\u00F3\\u00FA\\u00C1\\u00C9\\u00CD\\u00D3\\u00DA\\u00F1\\u00D1 ]{3,200}+$")
    private String fileHash;

    @Pattern(regexp = "^[0-9A-Za-z\\u00E1\\u00E9\\u00ED\\u00F3\\u00FA\\u00C1\\u00C9\\u00CD\\u00D3\\u00DA\\u00F1\\u00D1 ]{3,200}+$")
    private String fileName;

    @Pattern(regexp = "^[0-9A-Za-z\\u00E1\\u00E9\\u00ED\\u00F3\\u00FA\\u00C1\\u00C9\\u00CD\\u00D3\\u00DA\\u00F1\\u00D1 ]{3,10}+$")
    private String fileExt;

    @Pattern(regexp = "^[0-9A-Za-z\\u00E1\\u00E9\\u00ED\\u00F3\\u00FA\\u00C1\\u00C9\\u00CD\\u00D3\\u00DA\\u00F1\\u00D1 ]{3,10}+$")
    private String fileSize;

    private String fileImagen;
}
