
package pe.com.synopsis.imgrabber.beans.domain;

import java.beans.Transient;

public class LoadAllExcluid
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

}
