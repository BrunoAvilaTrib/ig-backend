
package pe.com.synopsis.imgrabber.beans.request;

import java.io.Serializable;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

public class RegisterMessageRequest implements Serializable
{

    private static final long serialVersionUID = -6804786695912857504L;

    @NotNull
    private String chatMobile;

    @NotNull
    private Long chatFK;

    @NotNull
    private Long employFK;

    @NotNull
    @Pattern(regexp = "^[0-9A-Za-z\\u00E1\\u00E9\\u00ED\\u00F3\\u00FA\\u00C1\\u00C9\\u00CD\\u00D3\\u00DA\\u00F1\\u00D1 ]{3,200}+$")
    private String toUser;

    @NotNull
    @Pattern(regexp = "^[0-9A-Za-z\\u00E1\\u00E9\\u00ED\\u00F3\\u00FA\\u00C1\\u00C9\\u00CD\\u00D3\\u00DA\\u00F1\\u00D1 ]{3,200}+$")
    private String toAlias;

    @NotNull
    private String msgText;

    @Pattern(regexp = "^([0-2][0-9]|(3)[0-1])(\\/)(((0)[0-9])|((1)[0-2]))(\\/)\\d{4}$")
    private String msgDate;

    @Pattern(regexp = "^(0[0-9]|1[0-9]|2[0-3])(:[0-5][0-9])$")
    private String msgHour;

    @NotNull
    @Pattern(regexp = "^[0-9A-Za-z\\u00E1\\u00E9\\u00ED\\u00F3\\u00FA\\u00C1\\u00C9\\u00CD\\u00D3\\u00DA\\u00F1\\u00D1 ]{3,200}+$")
    private String hashMsg;

    @NotNull
    @Pattern(regexp = "^[0-9A-Za-z\\u00E1\\u00E9\\u00ED\\u00F3\\u00FA\\u00C1\\u00C9\\u00CD\\u00D3\\u00DA\\u00F1\\u00D1 ]{3,3}+$")
    private String modeMsg;

    @Pattern(regexp = "^[0-9A-Za-z\\u00E1\\u00E9\\u00ED\\u00F3\\u00FA\\u00C1\\u00C9\\u00CD\\u00D3\\u00DA\\u00F1\\u00D1 ]{3,200}+$")
    private String fileHash;

    @Pattern(regexp = "^[0-9A-Za-z\\u00E1\\u00E9\\u00ED\\u00F3\\u00FA\\u00C1\\u00C9\\u00CD\\u00D3\\u00DA\\u00F1\\u00D1 ]{3,200}+$")
    private String fileName;

    @Pattern(regexp = "^[0-9A-Za-z\\u00E1\\u00E9\\u00ED\\u00F3\\u00FA\\u00C1\\u00C9\\u00CD\\u00D3\\u00DA\\u00F1\\u00D1 ]{3,10}+$")
    private String fileExt;

    @Pattern(regexp = "^[0-9A-Za-z\\u00E1\\u00E9\\u00ED\\u00F3\\u00FA\\u00C1\\u00C9\\u00CD\\u00D3\\u00DA\\u00F1\\u00D1 ]{3,10}+$")
    private String fileSize;

    private String fileImagen;

    public String getChatMobile()
    {
        return chatMobile;
    }

    public void setChatMobile(String chatMobile)
    {
        this.chatMobile = chatMobile;
    }

    public Long getChatFK()
    {
        return chatFK;
    }

    public void setChatFK(Long chatFK)
    {
        this.chatFK = chatFK;
    }

    public Long getEmployFK()
    {
        return employFK;
    }

    public void setEmployFK(Long employFK)
    {
        this.employFK = employFK;
    }

    public String getToUser()
    {
        return toUser;
    }

    public void setToUser(String toUser)
    {
        this.toUser = toUser;
    }

    public String getToAlias()
    {
        return toAlias;
    }

    public void setToAlias(String toAlias)
    {
        this.toAlias = toAlias;
    }

    public String getMsgText()
    {
        return msgText;
    }

    public void setMsgText(String msgText)
    {
        this.msgText = msgText;
    }

    public String getMsgDate()
    {
        return msgDate;
    }

    public void setMsgDate(String msgDate)
    {
        this.msgDate = msgDate;
    }

    public String getMsgHour()
    {
        return msgHour;
    }

    public void setMsgHour(String msgHour)
    {
        this.msgHour = msgHour;
    }

    public String getHashMsg()
    {
        return hashMsg;
    }

    public void setHashMsg(String hashMsg)
    {
        this.hashMsg = hashMsg;
    }

    public String getModeMsg()
    {
        return modeMsg;
    }

    public void setModeMsg(String modeMsg)
    {
        this.modeMsg = modeMsg;
    }

    public String getFileHash()
    {
        return fileHash;
    }

    public void setFileHash(String fileHash)
    {
        this.fileHash = fileHash;
    }

    public String getFileName()
    {
        return fileName;
    }

    public void setFileName(String fileName)
    {
        this.fileName = fileName;
    }

    public String getFileExt()
    {
        return fileExt;
    }

    public void setFileExt(String fileExt)
    {
        this.fileExt = fileExt;
    }

    public String getFileSize()
    {
        return fileSize;
    }

    public void setFileSize(String fileSize)
    {
        this.fileSize = fileSize;
    }

    public String getFileImagen()
    {
        return fileImagen;
    }

    public void setFileImagen(String fileImagen)
    {
        this.fileImagen = fileImagen;
    }

}
