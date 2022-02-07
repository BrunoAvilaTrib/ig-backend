
package pe.com.synopsis.imgrabber.beans.dto;

import org.springframework.beans.BeanUtils;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import pe.com.synopsis.imgrabber.beans.domain.LoadNavegation;

@JsonInclude(Include.NON_NULL)
public class LoadNavegationDTO
{

    private long navegationPk;
    private String nameNavegation;
    private long submenuPk;
    private String nameSubmenu;
    private String pathRute;

    public long getNavegationPk()
    {
        return navegationPk;
    }

    public void setNavegationPk(long navegationPk)
    {
        this.navegationPk = navegationPk;
    }

    public String getNameNavegation()
    {
        return nameNavegation;
    }

    public void setNameNavegation(String nameNavegation)
    {
        this.nameNavegation = nameNavegation;
    }

    public long getSubmenuPk()
    {
        return submenuPk;
    }

    public void setSubmenuPk(long submenuPk)
    {
        this.submenuPk = submenuPk;
    }

    public String getNameSubmenu()
    {
        return nameSubmenu;
    }

    public void setNameSubmenu(String nameSubmenu)
    {
        this.nameSubmenu = nameSubmenu;
    }

    public String getPathRute()
    {
        return pathRute;
    }

    public void setPathRute(String pathRute)
    {
        this.pathRute = pathRute;
    }

    public LoadNavegationDTO()
    {
        super();
    }

    public LoadNavegationDTO(LoadNavegation navegation)
    {
        BeanUtils.copyProperties(navegation, this);
    }

}
