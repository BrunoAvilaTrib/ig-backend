
package pe.com.synopsis.imgrabber.service.impl;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
import pe.com.synopsis.imgrabber.beans.response.Status;
import pe.com.synopsis.imgrabber.business.ChatBL;
import pe.com.synopsis.imgrabber.converter.LoadContactConverter;
import pe.com.synopsis.imgrabber.converter.LoadMessageConverter;
import pe.com.synopsis.imgrabber.converter.LoadPageConverter;
import pe.com.synopsis.imgrabber.enumeration.StatusEnum;
import pe.com.synopsis.imgrabber.exception.RulesException;
import pe.com.synopsis.imgrabber.service.ChatService;

@Service
public class ChatServiceImpl implements ChatService
{

    private static final Logger logger = LoggerFactory.getLogger(ChatServiceImpl.class);

    @Autowired
    LoadContactConverter convertercont;

    @Autowired
    LoadPageConverter pageConverter;

    @Autowired
    LoadMessageConverter convertermessag;

    @Autowired
    private ChatBL chatBl;

    public Response<List<ContactDTO>> loadContact(@Valid LoadContactRequest request)
    {

        Response<List<ContactDTO>> response = new Response<List<ContactDTO>>();

        try
        {
            response.setData(chatBl.loadContact(request));
            response.setStatus(StatusEnum.STATUS_SUCCESSFULL.create());

        }
        catch (RulesException e)
        {
            logger.error(e.getMessage(), e);
            response.setStatus(new Status(e.getErrorcode(), e.getMessage()));

        }
        catch (Exception e)
        {
            logger.error(e.getMessage(), e);
            response.setStatus(StatusEnum.STATUS_FAIL.create());
        }
        return response;
    }

    public Response<List<MessageDTO>> loadMessages(@Valid LoadMessagesRequest request)
    {

        Response<List<MessageDTO>> response = new Response<List<MessageDTO>>();

        try
        {
            List<MessageDTO> messages = chatBl.loadMessages(request);
            logger.error(messages + "");
            response.setData(messages);
            response.setStatus(StatusEnum.STATUS_SUCCESSFULL.create());

        }
        catch (RulesException e)
        {
            logger.error(e.getMessage(), e);
            response.setStatus(new Status(e.getErrorcode(), e.getMessage()));
        }
        catch (Exception e)
        {
            logger.error(e.getMessage(), e);
            response.setStatus(StatusEnum.STATUS_FAIL.create());
        }
        return response;
    }

    public Response<List<PageDTO>> loadPages(@Valid LoadPagesRequest request)
    {

        Response<List<PageDTO>> response = new Response<List<PageDTO>>();

        try
        {
            List<PageDTO> pages = chatBl.loadPages(request);
            response.setData(pages);
            response.setStatus(StatusEnum.STATUS_SUCCESSFULL.create());

        }
        catch (RulesException e)
        {
            logger.error(e.getMessage(), e);
            response.setStatus(new Status(e.getErrorcode(), e.getMessage()));

        }
        catch (Exception e)
        {
            logger.error(e.getMessage(), e);
            response.setStatus(StatusEnum.STATUS_FAIL.create());
        }
        return response;
    }

    @Override
    public Response<List<GetLastUpdateDTO>> getLastUpdate(@Valid GetLastUpdateRequest getLastUpdateRequest)
    {

        Response<List<GetLastUpdateDTO>> response = new Response<>();

        try
        {
            response.setData(chatBl.getLastUpdate(getLastUpdateRequest));
            response.setStatus(StatusEnum.STATUS_SUCCESSFULL.create());

        }
        catch (RulesException e)
        {
            logger.error(e.getMessage(), e);
            response.setStatus(new Status(e.getErrorcode(), e.getMessage()));

        }
        catch (Exception e)
        {
            logger.error(e.getMessage(), e);
            response.setStatus(StatusEnum.STATUS_FAIL.create());
        }
        return response;
    }

    @Override
    public Response<List<GetLastUpdateMSGDTO>> getLastUpdateMSG(@Valid GetLastUpdateRequest getLastUpdateRequest)
    {

        Response<List<GetLastUpdateMSGDTO>> response = new Response<>();

        try
        {
            response.setData(chatBl.getLastUpdateMSG(getLastUpdateRequest));
            response.setStatus(StatusEnum.STATUS_SUCCESSFULL.create());

        }
        catch (RulesException e)
        {
            logger.error(e.getMessage(), e);
            response.setStatus(new Status(e.getErrorcode(), e.getMessage()));

        }
        catch (Exception e)
        {
            logger.error(e.getMessage(), e);
            response.setStatus(StatusEnum.STATUS_FAIL.create());
        }
        return response;
    }

    @Override
    public Response<String> registerMessage(@Valid RegisterMessageRequest registerMessageRequest)
    {

        Response<String> response = new Response<>();

        try
        {
            chatBl.registerMessage(registerMessageRequest);
            response.setStatus(StatusEnum.STATUS_SUCCESSFULL.create());

        }
        catch (RulesException e)
        {
            logger.error(e.getMessage(), e);
            response.setStatus(new Status(e.getErrorcode(), e.getMessage()));

        }
        catch (Exception e)
        {
            logger.error(e.getMessage(), e);
            response.setStatus(StatusEnum.STATUS_FAIL.create());
        }
        return response;
    }
}