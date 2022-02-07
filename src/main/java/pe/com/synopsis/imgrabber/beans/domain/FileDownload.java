
package pe.com.synopsis.imgrabber.beans.domain;

public class FileDownload
{

    private String name;
    private String extension;
    private String size;
    private String key;
    private boolean hasDownload;

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

    public boolean isHasDownload()
    {
        return hasDownload;
    }

    public void setHasDownload(boolean hasDownload)
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
        builder.append(", hasDownload=");
        builder.append(hasDownload);
        builder.append("]");
        return builder.toString();
    }

}
