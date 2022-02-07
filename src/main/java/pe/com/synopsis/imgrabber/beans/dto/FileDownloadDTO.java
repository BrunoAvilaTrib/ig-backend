
package pe.com.synopsis.imgrabber.beans.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
public class FileDownloadDTO
{

    private String name;
    private String extension;
    private String size;
    private String key;
    private Boolean hasDownload;

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getExtension()
    {
        return extension;
    }

    public void setExtension(String extension)
    {
        this.extension = extension;
    }

    public String getSize()
    {
        return size;
    }

    public void setSize(String size)
    {
        this.size = size;
    }

    public String getKey()
    {
        return key;
    }

    public void setKey(String key)
    {
        this.key = key;
    }

    public Boolean getHasDownload()
    {
        return hasDownload;
    }

    public void setHasDownload(Boolean hasDownload)
    {
        this.hasDownload = hasDownload;
    }

    @Override
    public String toString()
    {
        StringBuilder builder = new StringBuilder();
        builder.append("FileDownload [name=");
        builder.append(name);
        builder.append(", extension=");
        builder.append(extension);
        builder.append(", size=");
        builder.append(size);
        builder.append(", key=");
        builder.append(key);
        builder.append("]");
        return builder.toString();
    }

}
