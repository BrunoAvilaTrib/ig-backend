
package pe.com.synopsis.imgrabber.beans.dto;

import org.springframework.beans.BeanUtils;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import pe.com.synopsis.imgrabber.beans.domain.LoadArea;

@JsonInclude(Include.NON_NULL)
public class LoadAreaDTO
{

    private Long areaPk;
    private String name;
    private String comment;
    private Long active;

    public Long getAreaPk()
    {
        return areaPk;
    }

    public void setAreaPk(Long areaPk)
    {
        this.areaPk = areaPk;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getComment()
    {
        return comment;
    }

    public void setComment(String comment)
    {
        this.comment = comment;
    }

    public Long getActive()
    {
        return active;
    }

    public void setActive(Long active)
    {
        this.active = active;
    }

    public LoadAreaDTO(LoadArea source)
    {
        BeanUtils.copyProperties(source, this);
    }

}
