
package pe.com.synopsis.imgrabber.beans.dto;

import org.springframework.beans.BeanUtils;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import pe.com.synopsis.imgrabber.beans.domain.Message;

@JsonInclude(Include.NON_NULL)
public class MessageDTO
{

    private String idMessage;
    private String msgText;
    private String msgDateTime;
    private String toUser;
    private String toAlias;
    private byte[] audio;
    private byte[] image;
    private String hashMsg;
    private byte[] file;
    private String modeMsg;
    private boolean hasVideo;

    private FileDownloadDTO fileDownload;

    public MessageDTO(Message source)
    {
        BeanUtils.copyProperties(source, this, "fileDownload");
        if (source.getFileDownload() != null)
        {
            this.setFileDownload(new FileDownloadDTO());
            BeanUtils.copyProperties(source.getFileDownload(), this.getFileDownload());
        }
    }

    public String getIdMessage()
    {
        return idMessage;
    }

    public void setIdMessage(String idMessage)
    {
        this.idMessage = idMessage;
    }

    public String getMsgText()
    {
        return msgText;
    }

    public void setMsgText(String msgText)
    {
        this.msgText = msgText;
    }

    public String getMsgDateTime()
    {
        return msgDateTime;
    }

    public void setMsgDateTime(String msgDateTime)
    {
        this.msgDateTime = msgDateTime;
    }

    public String getToUser()
    {
        return toUser;
    }

    public void setToUser(String fromUser)
    {
        this.toUser = fromUser;
    }

    public String getToAlias()
    {
        return toAlias;
    }

    public void setToAlias(String aliasUser)
    {
        this.toAlias = aliasUser;
    }

    public byte[] getAudio()
    {
        return audio;
    }

    public void setAudio(byte[] audio)
    {
        this.audio = audio;
    }

    public byte[] getImage()
    {
        return image;
    }

    public void setImage(byte[] image)
    {
        this.image = image;
    }

    public String getHashMsg()
    {
        return hashMsg;
    }

    public void setHashMsg(String hashMsg)
    {
        this.hashMsg = hashMsg;
    }

    public byte[] getFile()
    {
        return file;
    }

    public void setFile(byte[] file)
    {
        this.file = file;
    }

    public String getModeMsg()
    {
        return modeMsg;
    }

    public void setModeMsg(String modeMsg)
    {
        this.modeMsg = modeMsg;
    }

    public boolean isHasVideo()
    {
        return hasVideo;
    }

    public void setHasVideo(boolean hasVideo)
    {
        this.hasVideo = hasVideo;
    }

    public FileDownloadDTO getFileDownload()
    {
        return fileDownload;
    }

    public void setFileDownload(FileDownloadDTO fileDownload)
    {
        this.fileDownload = fileDownload;
    }

}
