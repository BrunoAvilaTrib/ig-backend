
package pe.com.synopsis.imgrabber.beans.request;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UploadAssignedRequest implements Serializable
{
    private static final long serialVersionUID = 1L;

    @NotNull
    private Long idEmploy;

    @NotNull
    private Long idArea;

    @NotNull
    private Long idChat;
}
