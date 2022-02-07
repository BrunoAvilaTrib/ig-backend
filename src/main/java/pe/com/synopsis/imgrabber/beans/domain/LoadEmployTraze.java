
package pe.com.synopsis.imgrabber.beans.domain;

import java.sql.Date;
import java.sql.Time;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude
public class LoadEmployTraze
{

    private Long employTrazePk;
    private String login;
    private String nameEmploy;
    private Date date;
    private Time time;
    private String operation;

    private String areaAnexo;
    private String areaName;

    public Long getEmployTrazePk()
    {
        return employTrazePk;
    }

    public void setEmployTrazePk(Long employTrazePk)
    {
        this.employTrazePk = employTrazePk;
    }

    public String getLogin()
    {
        return login;
    }

    public void setLogin(String login)
    {
        this.login = login;
    }

    public String getNameEmploy()
    {
        return nameEmploy;
    }

    public void setNameEmploy(String nameEmploy)
    {
        this.nameEmploy = nameEmploy;
    }

    public Date getDate()
    {
        return date;
    }

    public void setDate(Date date)
    {
        this.date = date;
    }

    public Time getTime()
    {
        return time;
    }

    public void setTime(Time time)
    {
        this.time = time;
    }

    public String getOperation()
    {
        return operation;
    }

    public void setOperation(String operation)
    {
        this.operation = operation;
    }

    public String getAreaAnexo()
    {
        return areaAnexo;
    }

    public void setAreaAnexo(String areaAnexo)
    {
        this.areaAnexo = areaAnexo;
    }

    public String getAreaName()
    {
        return areaName;
    }

    public void setAreaName(String areaName)
    {
        this.areaName = areaName;
    }

}
