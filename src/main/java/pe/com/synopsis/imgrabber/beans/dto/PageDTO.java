
package pe.com.synopsis.imgrabber.beans.dto;

import java.text.SimpleDateFormat;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import pe.com.synopsis.imgrabber.beans.domain.Page;
import pe.com.synopsis.imgrabber.support.Constants;

@JsonInclude(Include.NON_NULL)
public class PageDTO
{

    private SimpleDateFormat formatDate;

    private String date;

    public PageDTO()
    {
        this.formatDate = new SimpleDateFormat(Constants.SQL_DATE_FORMAT);
    }

    public PageDTO(Page source)
    {
        this();
        if (source.getDate() != null)
        {
            this.setDate(this.formatDate.format(source.getDate()));
        }
    }

    public String getDate()
    {
        return date;
    }

    public void setDate(String date)
    {
        this.date = date;
    }

}
