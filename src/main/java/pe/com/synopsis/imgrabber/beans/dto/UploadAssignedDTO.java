
package pe.com.synopsis.imgrabber.beans.dto;

import org.springframework.beans.BeanUtils;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.Getter;
import lombok.Setter;
import pe.com.synopsis.imgrabber.beans.domain.UploadAssigned;

@JsonInclude(Include.NON_NULL)
@Getter
@Setter
public class UploadAssignedDTO
{

    private String nameEmploy;
    private String nameArea;
    private Long idchat;

    public UploadAssignedDTO(UploadAssigned source)
    {
        BeanUtils.copyProperties(source, this);
    }
}
