
package pe.com.synopsis.imgrabber.beans.request;

import java.io.Serializable;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

public class UpdateGeneralConfigRequest implements Serializable
{

    private static final long serialVersionUID = 1L;

    @NotNull
    private Long generalConfigPk;
    @NotNull
    @Pattern(regexp = "^[AB]{1,1}+$")
    private String inGeneralConfigState;

    public Long getGeneralConfigPk()
    {
        return generalConfigPk;
    }

    public void setGeneralConfigPk(Long generalConfigPk)
    {
        this.generalConfigPk = generalConfigPk;
    }

    public String getInGeneralConfigState()
    {
        return inGeneralConfigState;
    }

    public void setInGeneralConfigState(String inGeneralConfigState)
    {
        this.inGeneralConfigState = inGeneralConfigState;
    }

}
