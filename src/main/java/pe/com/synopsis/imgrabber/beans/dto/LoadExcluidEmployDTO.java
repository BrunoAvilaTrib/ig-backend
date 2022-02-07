
package pe.com.synopsis.imgrabber.beans.dto;

import org.springframework.beans.BeanUtils;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.Getter;
import lombok.Setter;
import pe.com.synopsis.imgrabber.beans.domain.LoadExcluidEmploy;

@Getter
@Setter
@JsonInclude(Include.NON_NULL)
public class LoadExcluidEmployDTO
{

    private Long excluidEmployPK;
    private Long areaFK;
    private Long employFK;
    private String startDate;
    private String endDate;
    private String nameArea;
    private String nameEmploy;

    public LoadExcluidEmployDTO(LoadExcluidEmploy employ)
    {
        BeanUtils.copyProperties(employ, this);
    }
}
