
package pe.com.synopsis.imgrabber.beans.dto;

import org.springframework.beans.BeanUtils;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import pe.com.synopsis.imgrabber.beans.domain.LoadGeneralConfig;

@JsonInclude(Include.NON_NULL)
public class GenConfigDTO
{

    private String GEN_CONF_PK;
    private String NAME_CONF;
    private String ESTADO;

    public String getGEN_CONF_PK()
    {
        return GEN_CONF_PK;
    }

    public void setGEN_CONF_PK(String gEN_CONF_PK)
    {
        GEN_CONF_PK = gEN_CONF_PK;
    }

    public String getNAME_CONF()
    {
        return NAME_CONF;
    }

    public void setNAME_CONF(String nAME_CONF)
    {
        NAME_CONF = nAME_CONF;
    }

    public String getESTADO()
    {
        return ESTADO;
    }

    public void setESTADO(String eSTADO)
    {
        ESTADO = eSTADO;
    }

    public GenConfigDTO(LoadGeneralConfig source)
    {

        BeanUtils.copyProperties(source, this);
    }

}
