
package pe.com.synopsis.imgrabber.beans.request;

import java.io.Serializable;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

public class UpdateAreaRequest implements Serializable
{

    private static final long serialVersionUID = 1L;
    @NotNull
    private Long areaPk;

    @NotNull
    @Pattern(regexp = "^[0-9A-Za-z\\u00E1\\u00E9\\u00ED\\u00F3\\u00FA\\u00C1\\u00C9\\u00CD\\u00D3\\u00DA\\u00F1\\u00D1 ]{3,100}+$")
    private String areaName;

    @NotNull
    @Pattern(regexp = "^[AB]{1,1}+$")
    private String areaSupport;

    @NotNull
    @Pattern(regexp = "^[0-9A-Za-z\\u00E1\\u00E9\\u00ED\\u00F3\\u00FA\\u00C1\\u00C9\\u00CD\\u00D3\\u00DA\\u00F1\\u00D1 ]{3,200}+$")
    private String areaComment;

    public Long getAreaPk()
    {
        return areaPk;
    }

    public void setAreaPk(Long areaPk)
    {
        this.areaPk = areaPk;
    }

    public String getAreaName()
    {
        return areaName;
    }

    public void setAreaName(String areaName)
    {
        this.areaName = areaName;
    }

    public String getAreaSupport()
    {
        return areaSupport;
    }

    public void setAreaSupport(String areaSupport)
    {
        this.areaSupport = areaSupport;
    }

    public String getAreaComment()
    {
        return areaComment;
    }

    public void setAreaComment(String areaComment)
    {
        this.areaComment = areaComment;
    }

}
