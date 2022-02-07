
package pe.com.synopsis.imgrabber.beans.dto;

import org.springframework.beans.BeanUtils;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import pe.com.synopsis.imgrabber.beans.domain.LoadAllArea;

@JsonInclude(Include.NON_NULL)
public class LoadAllAreaDTO
{

    private Long areaPk;
    private String nameArea;
    private Long countAssigned;
    private String support;
    private String date;
    private String nameBusiness;

    public Long getAreaPk()
    {
        return areaPk;
    }

    public void setAreaPk(Long areaPk)
    {
        this.areaPk = areaPk;
    }

    public String getNameArea()
    {
        return nameArea;
    }

    public void setNameArea(String nameArea)
    {
        this.nameArea = nameArea;
    }

    public Long getCountAssigned()
    {
        return countAssigned;
    }

    public void setCountAssigned(Long countAssigned)
    {
        this.countAssigned = countAssigned;
    }

    public String getSupport()
    {
        return support;
    }

    public void setSupport(String support)
    {
        this.support = support;
    }

    public String getDate()
    {
        return date;
    }

    public void setDate(String date)
    {
        this.date = date;
    }

    public String getNameBusiness()
    {
        return nameBusiness;
    }

    public void setNameBusiness(String nameBusiness)
    {
        this.nameBusiness = nameBusiness;
    }

    public LoadAllAreaDTO(LoadAllArea source)
    {
        BeanUtils.copyProperties(source, this);
    }

}
