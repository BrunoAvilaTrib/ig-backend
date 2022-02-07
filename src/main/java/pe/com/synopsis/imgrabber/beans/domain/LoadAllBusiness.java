
package pe.com.synopsis.imgrabber.beans.domain;

public class LoadAllBusiness
{

    private Long businessPK;
    private String name;
    private Long countAssigned;
    private String state;
    private String date;
    private String email;

    public Long getBusinessPK()
    {
        return businessPK;
    }

    public void setBusinessPK(Long businessPK)
    {
        this.businessPK = businessPK;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public Long getCountAssigned()
    {
        return countAssigned;
    }

    public void setCountAssigned(Long countAssigned)
    {
        this.countAssigned = countAssigned;
    }

    public String getState()
    {
        return state;
    }

    public void setState(String state)
    {
        this.state = state;
    }

    public String getDate()
    {
        return date;
    }

    public void setDate(String date)
    {
        this.date = date;
    }

    public String getEmail()
    {
        return email;
    }

    public void setEmail(String email)
    {
        this.email = email;
    }

}
