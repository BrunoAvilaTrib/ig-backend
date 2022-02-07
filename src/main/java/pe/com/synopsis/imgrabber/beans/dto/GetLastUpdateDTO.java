
package pe.com.synopsis.imgrabber.beans.dto;

import org.springframework.beans.BeanUtils;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import pe.com.synopsis.imgrabber.beans.domain.GetLastUpdate;

@JsonInclude(Include.NON_NULL)
public class GetLastUpdateDTO
{

    private Long chatPK;
    private String lastUpdate;

    public Long getChatPK()
    {
        return chatPK;
    }

    public void setChatPK(Long chatPK)
    {
        this.chatPK = chatPK;
    }

    public String getLastUpdate()
    {
        return lastUpdate;
    }

    public void setLastUpdate(String lastUpdate)
    {
        this.lastUpdate = lastUpdate;
    }

    public GetLastUpdateDTO(GetLastUpdate getLastUpdate)
    {
        BeanUtils.copyProperties(getLastUpdate, this);
    }
}
