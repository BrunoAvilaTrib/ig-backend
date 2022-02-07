
package pe.com.synopsis.imgrabber.beans.dto;

import java.sql.Date;
import java.sql.Time;

import org.springframework.beans.BeanUtils;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import pe.com.synopsis.imgrabber.beans.domain.LoadEmployTraze;

@JsonInclude(Include.NON_NULL)
public class TraceUserDTO
{

    private String idTraza;
    private String username;
    private Date date;
    private Time hour;
    private String operacion;

    public String getIdTraza()
    {
        return idTraza;
    }

    public void setIdTraza(String idTraza)
    {
        this.idTraza = idTraza;
    }

    public String getUsername()
    {
        return username;
    }

    public void setUsername(String username)
    {
        this.username = username;
    }

    public Date getDate()
    {
        return date;
    }

    public void setDate(Date date)
    {
        this.date = date;
    }

    public Time getHour()
    {
        return hour;
    }

    public void setHour(Time hour)
    {
        this.hour = hour;
    }

    public String getOperacion()
    {
        return operacion;
    }

    public void setOperacion(String operacion)
    {
        this.operacion = operacion;
    }

    public TraceUserDTO(LoadEmployTraze source)
    {
        BeanUtils.copyProperties(source, this);
    }

}
