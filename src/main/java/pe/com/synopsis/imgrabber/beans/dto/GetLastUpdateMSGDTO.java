
package pe.com.synopsis.imgrabber.beans.dto;

import org.springframework.beans.BeanUtils;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import pe.com.synopsis.imgrabber.beans.domain.GetLastUpdateMSG;

@JsonInclude(Include.NON_NULL)
public class GetLastUpdateMSGDTO
{

    private String msgHash;
    private String msgDateTime;
    private String msgDate;
    private String msgHour;

    public String getMsgHash()
    {
        return msgHash;
    }

    public void setMsgHash(String msgHash)
    {
        this.msgHash = msgHash;
    }

    public String getMsgDateTime()
    {
        return msgDateTime;
    }

    public void setMsgDateTime(String msgDateTime)
    {
        this.msgDateTime = msgDateTime;
    }

    public String getMsgDate()
    {
        return msgDate;
    }

    public void setMsgDate(String msgDate)
    {
        this.msgDate = msgDate;
    }

    public String getMsgHour()
    {
        return msgHour;
    }

    public void setMsgHour(String msgHour)
    {
        this.msgHour = msgHour;
    }

    public GetLastUpdateMSGDTO(GetLastUpdateMSG getLastUpdateMSG)
    {
        BeanUtils.copyProperties(getLastUpdateMSG, this);
    }

}
