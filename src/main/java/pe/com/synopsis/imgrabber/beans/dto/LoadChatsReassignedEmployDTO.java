
package pe.com.synopsis.imgrabber.beans.dto;

import org.springframework.beans.BeanUtils;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import pe.com.synopsis.imgrabber.beans.domain.LoadChatsReassignedEmploy;

@JsonInclude(Include.NON_NULL)
public class LoadChatsReassignedEmployDTO
{

    private Long chatPK;
    private String chatmobile;
    private String state;
    private String area;
    private String operator;

    public Long getChatPK()
    {
        return chatPK;
    }

    public void setChatPK(Long chatPK)
    {
        this.chatPK = chatPK;
    }

    public String getChatmobile()
    {
        return chatmobile;
    }

    public void setChatmobile(String chatmobile)
    {
        this.chatmobile = chatmobile;
    }

    public String getState()
    {
        return state;
    }

    public void setState(String state)
    {
        this.state = state;
    }

    public String getArea()
    {
        return area;
    }

    public void setArea(String area)
    {
        this.area = area;
    }

    public String getOperator()
    {
        return operator;
    }

    public void setOperator(String operator)
    {
        this.operator = operator;
    }

    public LoadChatsReassignedEmployDTO(LoadChatsReassignedEmploy loadChatsReassignedEmploy)
    {
        BeanUtils.copyProperties(loadChatsReassignedEmploy, this);
    }
}
