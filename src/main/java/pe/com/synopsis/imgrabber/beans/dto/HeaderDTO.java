
package pe.com.synopsis.imgrabber.beans.dto;

import org.springframework.beans.BeanUtils;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import pe.com.synopsis.imgrabber.beans.domain.Header;

@JsonInclude(Include.NON_NULL)
public class HeaderDTO
{

    private String header;
    private String path;
    private String pathImg;
    private String pathImgB;

    public HeaderDTO(Header source)
    {
        BeanUtils.copyProperties(source, this);
    }

    public String getHeader()
    {
        return header;
    }

    public void setHeader(String header)
    {
        this.header = header;
    }

    public String getPath()
    {
        return path;
    }

    public void setPath(String path)
    {
        this.path = path;
    }

    public String getPathImg()
    {
        return pathImg;
    }

    public void setPathImg(String pathImg)
    {
        this.pathImg = pathImg;
    }

    public String getPathImgB()
    {
        return pathImgB;
    }

    public void setPathImgB(String pathImgB)
    {
        this.pathImgB = pathImgB;
    }
}
