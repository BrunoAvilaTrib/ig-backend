
package pe.com.synopsis.imgrabber.service;

import java.util.List;

import javax.validation.Valid;

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
import pe.com.synopsis.imgrabber.beans.response.Response;

public interface ChatService
{

    public Response<List<ContactDTO>> loadContact(LoadContactRequest request);

    public Response<List<MessageDTO>> loadMessages(@Valid LoadMessagesRequest request);

    public Response<List<PageDTO>> loadPages(@Valid LoadPagesRequest request);

    public Response<List<GetLastUpdateDTO>> getLastUpdate(@Valid GetLastUpdateRequest getLastUpdateRequest);

    public Response<List<GetLastUpdateMSGDTO>> getLastUpdateMSG(@Valid GetLastUpdateRequest getLastUpdateRequest);

    public Response<String> registerMessage(@Valid RegisterMessageRequest registerMessageRequest);

}
