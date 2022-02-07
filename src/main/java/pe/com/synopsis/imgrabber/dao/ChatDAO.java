
package pe.com.synopsis.imgrabber.dao;

import java.util.List;

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

public interface ChatDAO
{

    public List<Contact> loadContact(LoadContactRequest loadContactRequest);

    public List<Message> loadMessages(LoadMessagesRequest loadMessagesRequest);

    public List<Page> loadPages(String chatId);

    public List<GetLastUpdate> getLastUpdate(GetLastUpdateRequest getLastUpdateRequest);

    public List<GetLastUpdateMSG> getLastUpdateMSG(GetLastUpdateRequest getLastUpdateRequest);

    public void registerMessage(RegisterMessageRequest registerMessageRequest);

    public List<LastMessage> loadLastMessage(String chatId);
}
