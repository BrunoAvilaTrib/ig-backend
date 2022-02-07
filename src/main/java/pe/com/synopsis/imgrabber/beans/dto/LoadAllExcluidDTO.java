
package pe.com.synopsis.imgrabber.beans.dto;

import java.beans.Transient;

import org.springframework.beans.BeanUtils;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import pe.com.synopsis.imgrabber.beans.domain.LoadAllExcluid;

@JsonInclude(Include.NON_NULL)
public class LoadAllExcluidDTO
{

    private long excluidPk;
    private String mobile;
    private String alias;
    private long employFk;

    @Transient
    public long getExcluidPk()
    {
        return excluidPk;
    }

    public void setExcluidPk(long excluidPk)
    {
        this.excluidPk = excluidPk;
    }

    public String getMobile()
    {
        return mobile;
    }

    public void setMobile(String mobile)
    {
        this.mobile = mobile;
    }

    public String getAlias()
    {
        return alias;
    }

    public void setAlias(String alias)
    {
        this.alias = alias;
    }

    @Transient
    public long getEmployFk()
    {
        return employFk;
    }

    public void setEmployFk(long employFk)
    {
        this.employFk = employFk;
    }

    public LoadAllExcluidDTO(LoadAllExcluid excluid)
    {
        BeanUtils.copyProperties(excluid, this);
    }

}
