
package pe.com.synopsis.imgrabber.beans.domain;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude
public class LoadGeneralConfig
{

    private long generalConfigPk;
    private String name;
    private String state;

    public long getGeneralConfigPk()
    {
        return generalConfigPk;
    }

    public void setGeneralConfigPk(long generalConfigPk)
    {
        this.generalConfigPk = generalConfigPk;
    }

    public String getName()
    {
        return this.name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getState()
    {
        return this.state;
    }

    public void setState(String state)
    {
        this.state = state;
    }

}
