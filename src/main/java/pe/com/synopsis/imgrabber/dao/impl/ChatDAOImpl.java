
package pe.com.synopsis.imgrabber.dao.impl;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Component;

import pe.com.synopsis.imgrabber.beans.domain.Contact;
import pe.com.synopsis.imgrabber.beans.domain.GetLastUpdate;
import pe.com.synopsis.imgrabber.beans.domain.GetLastUpdateMSG;
import pe.com.synopsis.imgrabber.beans.domain.LastMessage;
import pe.com.synopsis.imgrabber.beans.domain.Message;
import pe.com.synopsis.imgrabber.beans.domain.Page;
import pe.com.synopsis.imgrabber.beans.request.GetLastUpdateRequest;
import pe.com.synopsis.imgrabber.beans.request.LoadContactRequest;
import pe.com.synopsis.imgrabber.beans.request.LoadMessagesRequest;
import pe.com.synopsis.imgrabber.beans.request.RegisterMessageRequest;
import pe.com.synopsis.imgrabber.dao.ChatDAO;
import pe.com.synopsis.imgrabber.dao.sp.SPGetLastUpdate;
import pe.com.synopsis.imgrabber.dao.sp.SPGetLastUpdateMSG;
import pe.com.synopsis.imgrabber.dao.sp.SPLoadContacts;
import pe.com.synopsis.imgrabber.dao.sp.SPLoadLastMessage;
import pe.com.synopsis.imgrabber.dao.sp.SPLoadMessages;
import pe.com.synopsis.imgrabber.dao.sp.SPLoadPages;
import pe.com.synopsis.imgrabber.dao.sp.SPRegisterMessage;
import pe.com.synopsis.imgrabber.enumeration.SPCodeEnum;
import pe.com.synopsis.imgrabber.exception.RulesException;
import pe.com.synopsis.imgrabber.support.MessageInventory;

@Component
@SuppressWarnings({ "unchecked", "unused" })
public class ChatDAOImpl implements ChatDAO
{

    private static final Logger logger = LoggerFactory.getLogger(ChatDAOImpl.class);

    @Autowired
    SPLoadContacts spLoadContacts;

    @Autowired
    SPLoadMessages spLoadMessages;

    @Autowired
    SPLoadPages spLoadPages;

    @Autowired
    MessageInventory messageInventory;

    @Autowired
    SPGetLastUpdateMSG sPGetLastUpdateMSG;

    @Autowired
    SPGetLastUpdate sPGetLastUpdate;

    @Autowired
    SPRegisterMessage sPRegisterMessage;

    @Autowired
    SPLoadLastMessage sPLoadLastMessage;

    @Override
    public List<Contact> loadContact(LoadContactRequest loadContactRequest)
    {

        SqlParameterSource in = new MapSqlParameterSource().addValue(SPLoadContacts.IN_EMPLOY_PK,
                loadContactRequest.getIdOfficer());

        Map<String, Object> result = spLoadContacts.execute(in);
        List<Contact> messages = (List<Contact>) result.get(SPLoadContacts.OUT_CURSOR);
        String status = (String) result.get(SPLoadContacts.OUT_STATUS);

        if (!SPCodeEnum.RESULT_OK.isCode(status))
        {
            throw new RulesException(status);
        }
        return messages;
    }

    @Override
    public List<Message> loadMessages(LoadMessagesRequest loadMessagesRequest)
    {

        SqlParameterSource in = new MapSqlParameterSource()
                .addValue(SPLoadMessages.IN_CHATID, loadMessagesRequest.getIdChat())
                .addValue(SPLoadMessages.IN_PAGE, loadMessagesRequest.getPage());

        Map<String, Object> result = spLoadMessages.execute(in);
        List<Message> messages = (List<Message>) result.get(SPLoadMessages.OUT_CURSOR);
        String status = (String) result.get(SPLoadMessages.OUT_STATUS);

        if (!SPCodeEnum.RESULT_OK.isCode(status))
        {
            throw new RulesException(status);
        }
        return messages;
    }

    @Override
    public List<Page> loadPages(String chatId)
    {

        SqlParameterSource in = new MapSqlParameterSource().addValue(SPLoadPages.IN_CHATID, chatId);

        Map<String, Object> result = spLoadPages.execute(in);
        List<Page> messages = (List<Page>) result.get(SPLoadPages.OUT_CURSOR);
        String status = (String) result.get(SPLoadPages.OUT_STATUS);

        if (!SPCodeEnum.RESULT_OK.isCode(status))
        {
            throw new RulesException(status);
        }
        return messages;
    }

    @Override
    public List<GetLastUpdate> getLastUpdate(GetLastUpdateRequest getLastUpdateRequest)
    {

        SqlParameterSource in = new MapSqlParameterSource()
                .addValue(SPGetLastUpdate.IN_OFFI_PHONE, getLastUpdateRequest.getOffiPhone())
                .addValue(SPGetLastUpdate.IN_CUST_PHONE, getLastUpdateRequest.getCustPhone())
                .addValue(SPGetLastUpdate.IN_CUST_NAME, getLastUpdateRequest.getCustName());

        Map<String, Object> result = sPGetLastUpdate.execute(in);
        String status = (String) result.get(SPGetLastUpdate.OUT_STATUS);

        if (!SPCodeEnum.RESULT_OK.isCode(status))
        {
            throw new RulesException(status);
        }

        List<GetLastUpdate> getLastUpdate = (List<GetLastUpdate>) result.get(SPGetLastUpdate.OUT_CURSOR);
        return getLastUpdate;
    }

    @Override
    public List<GetLastUpdateMSG> getLastUpdateMSG(GetLastUpdateRequest getLastUpdateRequest)
    {

        SqlParameterSource in = new MapSqlParameterSource()
                .addValue(SPGetLastUpdateMSG.IN_OFFI_PHONE, getLastUpdateRequest.getOffiPhone())
                .addValue(SPGetLastUpdateMSG.IN_CUST_PHONE, getLastUpdateRequest.getCustPhone())
                .addValue(SPGetLastUpdateMSG.IN_CUST_NAME, getLastUpdateRequest.getCustName());

        Map<String, Object> result = sPGetLastUpdateMSG.execute(in);
        String status = (String) result.get(SPGetLastUpdateMSG.OUT_STATUS);

        if (!SPCodeEnum.RESULT_OK.isCode(status))
        {
            throw new RulesException(status);
        }

        List<GetLastUpdateMSG> getLastUpdateMSG = (List<GetLastUpdateMSG>) result.get(SPGetLastUpdateMSG.OUT_CURSOR);
        return getLastUpdateMSG;
    }

    @Override
    public void registerMessage(RegisterMessageRequest registerMessageRequest)
    {

        SqlParameterSource in = new MapSqlParameterSource()
                .addValue(SPRegisterMessage.IN_CHAT_FK, registerMessageRequest.getChatFK())
                .addValue(SPRegisterMessage.IN_EMPLOY_FK, registerMessageRequest.getEmployFK())
                .addValue(SPRegisterMessage.IN_TO_USER, registerMessageRequest.getToUser())
                .addValue(SPRegisterMessage.IN_TO_ALIAS, registerMessageRequest.getToAlias())
                .addValue(SPRegisterMessage.IN_MSG_TEXT, registerMessageRequest.getMsgText())
                .addValue(SPRegisterMessage.IN_MSG_DATE, registerMessageRequest.getMsgDate())
                .addValue(SPRegisterMessage.IN_MSG_HOUR, registerMessageRequest.getMsgHour())
                .addValue(SPRegisterMessage.IN_HASH_MSG, registerMessageRequest.getHashMsg())
                .addValue(SPRegisterMessage.IN_MODE_MSG, registerMessageRequest.getModeMsg())
                .addValue(SPRegisterMessage.IN_FILE_HASH, registerMessageRequest.getFileHash())
                .addValue(SPRegisterMessage.IN_FILE_NAME, registerMessageRequest.getFileName())
                .addValue(SPRegisterMessage.IN_FILE_EXT, registerMessageRequest.getFileExt())
                .addValue(SPRegisterMessage.IN_FILE_SIZE, registerMessageRequest.getFileSize())
                .addValue(SPRegisterMessage.IN_FILE_IMAGE, registerMessageRequest.getFileImagen());

        Map<String, Object> result = sPRegisterMessage.execute(in);
        String status = (String) result.get(SPRegisterMessage.OUT_STATUS);

        if (!SPCodeEnum.RESULT_OK.isCode(status))
        {
            throw new RulesException(status);
        }
    }

    @Override
    public List<LastMessage> loadLastMessage(String chatId)
    {
        SqlParameterSource in = new MapSqlParameterSource().addValue(SPLoadLastMessage.IN_CHATID, chatId);

        Map<String, Object> result = sPLoadLastMessage.execute(in);
        List<LastMessage> messages = (List<LastMessage>) result.get(SPLoadLastMessage.OUT_CURSOR);
        String status = (String) result.get(SPLoadLastMessage.OUT_STATUS);

        if (!SPCodeEnum.RESULT_OK.isCode(status))
        {
            throw new RulesException(status);
        }
        return messages;
    }

}
