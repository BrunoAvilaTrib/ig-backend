
package pe.com.synopsis.imgrabber.beans.domain;

public class LoadBySupervisorPrivilege
{

    private long employPk;
    private long privilegePk;
    private String name;
    private String state;

    public long getEmployPk()
    {
        return employPk;
    }

    public void setEmployPk(long employPk)
    {
        this.employPk = employPk;
    }

    public long getPrivilegePk()
    {
        return privilegePk;
    }

    public void setPrivilegePk(long privilegePk)
    {
        this.privilegePk = privilegePk;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getState()
    {
        return state;
    }

    public void setState(String state)
    {
        this.state = state;
    }

}
