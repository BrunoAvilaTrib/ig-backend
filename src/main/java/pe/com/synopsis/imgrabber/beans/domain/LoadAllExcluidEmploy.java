
package pe.com.synopsis.imgrabber.beans.domain;

public class LoadAllExcluidEmploy
{

    private Long excluidEmployPK;
    private Long areaFK;
    private Long employFK;
    private String startDate;
    private String endDate;
    private String nameArea;
    private String nameEmploy;

    public Long getExcluidEmployPK()
    {
        return excluidEmployPK;
    }

    public void setExcluidEmployPK(Long excluidEmployPK)
    {
        this.excluidEmployPK = excluidEmployPK;
    }

    public Long getAreaFK()
    {
        return areaFK;
    }

    public void setAreaFK(Long areaFK)
    {
        this.areaFK = areaFK;
    }

    public Long getEmployFK()
    {
        return employFK;
    }

    public void setEmployFK(Long employFK)
    {
        this.employFK = employFK;
    }

    public String getStartDate()
    {
        return startDate;
    }

    public void setStartDate(String startDate)
    {
        this.startDate = startDate;
    }

    public String getEndDate()
    {
        return endDate;
    }

    public void setEndDate(String endDate)
    {
        this.endDate = endDate;
    }

    public String getNameArea()
    {
        return nameArea;
    }

    public void setNameArea(String nameArea)
    {
        this.nameArea = nameArea;
    }

    public String getNameEmploy()
    {
        return nameEmploy;
    }

    public void setNameEmploy(String nameEmploy)
    {
        this.nameEmploy = nameEmploy;
    }
}
