
package pe.com.synopsis.imgrabber.beans.dto;

import org.springframework.beans.BeanUtils;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.Getter;
import lombok.Setter;
import pe.com.synopsis.imgrabber.beans.domain.LastMessage;

@Setter
@Getter
@JsonInclude(Include.NON_NULL)
public class LastMessageDTO
{
    private String lastMessage;

    public LastMessageDTO(LastMessage lastMessage)
    {
        BeanUtils.copyProperties(lastMessage, this);
    }
}
