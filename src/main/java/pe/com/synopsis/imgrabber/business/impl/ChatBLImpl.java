
package pe.com.synopsis.imgrabber.business.impl;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import pe.com.synopsis.imgrabber.beans.domain.Contact;
import pe.com.synopsis.imgrabber.beans.domain.GetLastUpdate;
import pe.com.synopsis.imgrabber.beans.domain.GetLastUpdateMSG;
import pe.com.synopsis.imgrabber.beans.domain.Message;
import pe.com.synopsis.imgrabber.beans.domain.Page;
import pe.com.synopsis.imgrabber.beans.dto.ContactDTO;
import pe.com.synopsis.imgrabber.beans.dto.GetLastUpdateDTO;
import pe.com.synopsis.imgrabber.beans.dto.GetLastUpdateMSGDTO;
import pe.com.synopsis.imgrabber.beans.dto.MessageDTO;
import pe.com.synopsis.imgrabber.beans.dto.PageDTO;
import pe.com.synopsis.imgrabber.beans.request.GetLastUpdateRequest;
import pe.com.synopsis.imgrabber.beans.request.LoadContactRequest;
import pe.com.synopsis.imgrabber.beans.request.LoadMessagesRequest;
import pe.com.synopsis.imgrabber.beans.request.LoadPagesRequest;
import pe.com.synopsis.imgrabber.beans.request.RegisterMessageRequest;
import pe.com.synopsis.imgrabber.business.ChatBL;
import pe.com.synopsis.imgrabber.converter.GetLastUpdateConverter;
import pe.com.synopsis.imgrabber.converter.GetLastUpdateMSGConverter;
import pe.com.synopsis.imgrabber.converter.LoadContactConverter;
import pe.com.synopsis.imgrabber.converter.LoadMessageConverter;
import pe.com.synopsis.imgrabber.converter.LoadPageConverter;
import pe.com.synopsis.imgrabber.dao.ChatDAO;

@Component
public class ChatBLImpl implements ChatBL
{

    @SuppressWarnings("unused")
    private static final Logger logger = LoggerFactory.getLogger(ChatBLImpl.class);

    @Autowired
    private ChatDAO chatDao;

    @Autowired
    LoadMessageConverter msgConverter;

    @Autowired
    LoadContactConverter converter;

    @Autowired
    LoadPageConverter pageConverter;

    @Autowired
    GetLastUpdateConverter getLastUpdateConverter;

    @Autowired
    GetLastUpdateMSGConverter getLastUpdateMSGConverter;

    @Override
    public List<ContactDTO> loadContact(LoadContactRequest loadContactRequest)
    {
        List<Contact> contacts = chatDao.loadContact(loadContactRequest);

        for (Contact contact : contacts)
        {
            contact.setPages(chatDao.loadPages(contact.getIdChat()));
            contact.setLastMessage(chatDao.loadLastMessage(contact.getIdChat()));
        }

        return converter.convert(contacts);
    }

    @Override
    public List<MessageDTO> loadMessages(@Valid LoadMessagesRequest request)
    {
        List<Message> contacts = chatDao.loadMessages(request);
        return msgConverter.convert(contacts);
    }

    @Override
    public List<PageDTO> loadPages(@Valid LoadPagesRequest request)
    {
        List<Page> contacts = chatDao.loadPages(request.getIdChat());
        return pageConverter.convert(contacts);
    }

    @Override
    public List<GetLastUpdateDTO> getLastUpdate(@Valid GetLastUpdateRequest getLastUpdateRequest)
    {
        List<GetLastUpdate> response = chatDao.getLastUpdate(getLastUpdateRequest);
        return getLastUpdateConverter.convert(response);
    }

    @Override
    public List<GetLastUpdateMSGDTO> getLastUpdateMSG(@Valid GetLastUpdateRequest getLastUpdateRequest)
    {
        List<GetLastUpdateMSG> response = chatDao.getLastUpdateMSG(getLastUpdateRequest);
        return getLastUpdateMSGConverter.convert(response);
    }

    @Override
    public void registerMessage(@Valid RegisterMessageRequest registerMessageRequest)
    {
        chatDao.registerMessage(registerMessageRequest);
    }

}
