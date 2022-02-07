
package pe.com.synopsis.imgrabber.beans.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoadExcluidEmploy
{

    private Long excluidEmployPK;
    private Long areaFK;
    private Long employFK;
    private String startDate;
    private String endDate;
    private String nameArea;
    private String nameEmploy;
}
