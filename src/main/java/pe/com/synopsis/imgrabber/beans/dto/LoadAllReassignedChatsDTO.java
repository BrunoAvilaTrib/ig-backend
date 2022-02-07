
package pe.com.synopsis.imgrabber.beans.dto;

import org.springframework.beans.BeanUtils;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import pe.com.synopsis.imgrabber.beans.domain.LoadAllReassignedChats;

@JsonInclude(Include.NON_NULL)
public class LoadAllReassignedChatsDTO
{

    private Long employPK;
    private String operator;
    private String emailOperator;
    private Long chats;
    private String date;
    private String area;
    private String sex;

    public Long getEmployPK()
    {
        return employPK;
    }

    public void setEmployPK(Long employPK)
    {
        this.employPK = employPK;
    }

    public String getOperator()
    {
        return operator;
    }

    public void setOperator(String operator)
    {
        this.operator = operator;
    }

    public String getEmailOperator()
    {
        return emailOperator;
    }

    public void setEmailOperator(String emailOperator)
    {
        this.emailOperator = emailOperator;
    }

    public Long getChats()
    {
        return chats;
    }

    public void setChats(Long chats)
    {
        this.chats = chats;
    }

    public String getDate()
    {
        return date;
    }

    public void setDate(String date)
    {
        this.date = date;
    }

    public String getArea()
    {
        return area;
    }

    public void setArea(String area)
    {
        this.area = area;
    }

    public String getSex()
    {
        return sex;
    }

    public void setSex(String sex)
    {
        this.sex = sex;
    }

    public LoadAllReassignedChatsDTO(LoadAllReassignedChats loadAllReassignedChats)
    {
        BeanUtils.copyProperties(loadAllReassignedChats, this);
    }
}
