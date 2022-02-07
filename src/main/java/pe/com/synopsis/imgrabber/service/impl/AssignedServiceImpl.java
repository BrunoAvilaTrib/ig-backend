
package pe.com.synopsis.imgrabber.service.impl;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.com.synopsis.imgrabber.beans.dto.LoadAllReassignedChatsDTO;
import pe.com.synopsis.imgrabber.beans.dto.LoadChatsReassignedEmployDTO;
import pe.com.synopsis.imgrabber.beans.dto.UploadAssignedDTO;
import pe.com.synopsis.imgrabber.beans.request.AutomaticReassignedRequest;
import pe.com.synopsis.imgrabber.beans.request.ChangeAssignedChatRequest;
import pe.com.synopsis.imgrabber.beans.request.DefuseChangeAssignedChatRequest;
import pe.com.synopsis.imgrabber.beans.request.ListChangeAssignedChatRequest;
import pe.com.synopsis.imgrabber.beans.request.ListDefuseChangeAssignedChatRequest;
import pe.com.synopsis.imgrabber.beans.request.LoadAllReassignedChatsRequest;
import pe.com.synopsis.imgrabber.beans.request.LoadChatsReassignedEmployRequest;
import pe.com.synopsis.imgrabber.beans.request.UpdateAssignedRequest;
import pe.com.synopsis.imgrabber.beans.request.UploadAssignedRequest;
import pe.com.synopsis.imgrabber.beans.response.Response;
import pe.com.synopsis.imgrabber.beans.response.Status;
import pe.com.synopsis.imgrabber.business.AssignedBL;
import pe.com.synopsis.imgrabber.converter.LoadContactConverter;
import pe.com.synopsis.imgrabber.converter.LoadMessageConverter;
import pe.com.synopsis.imgrabber.converter.LoadPageConverter;
import pe.com.synopsis.imgrabber.enumeration.StatusEnum;
import pe.com.synopsis.imgrabber.exception.RulesException;
import pe.com.synopsis.imgrabber.service.AssignedService;

@Service
public class AssignedServiceImpl implements AssignedService
{

    private static final Logger logger = LoggerFactory.getLogger(AssignedServiceImpl.class);

    @Autowired
    LoadContactConverter convertercont;

    @Autowired
    LoadPageConverter pageConverter;

    @Autowired
    LoadMessageConverter convertermessag;

    @Autowired
    private AssignedBL assignedBl;

    @Override
    public Response<String> changeAssignedChat(@Valid ChangeAssignedChatRequest changeAssignedChatRequest)
    {

        Response<String> response = new Response<>();

        try
        {
            assignedBl.changeAssignedChat(changeAssignedChatRequest);
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
    public Response<String> listChangeAssignedChat(@Valid ListChangeAssignedChatRequest listChangeAssignedChatRequest)
    {

        Response<String> response = new Response<>();

        try
        {
            assignedBl.listChangeAssignedChat(listChangeAssignedChatRequest);
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
    public Response<String> automaticReassigned(@Valid AutomaticReassignedRequest automaticReassignedRequest)
    {

        Response<String> response = new Response<>();

        try
        {
            assignedBl.automaticReassigned(automaticReassignedRequest);
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
    public Response<String> updateAssigned(@Valid UpdateAssignedRequest updateAssignedRequest)
    {

        Response<String> response = new Response<>();

        try
        {
            assignedBl.updateAssigned(updateAssignedRequest);
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
    public Response<List<LoadChatsReassignedEmployDTO>> loadChatsReassignedEmploy(
            LoadChatsReassignedEmployRequest loadChatsReassignedEmployRequest)
    {
        Response<List<LoadChatsReassignedEmployDTO>> response = new Response<>();

        try
        {
            response.setData(assignedBl.loadChatsReassignedEmploy(loadChatsReassignedEmployRequest));
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
    public Response<List<LoadAllReassignedChatsDTO>> loadAllReassignedChats(
            LoadAllReassignedChatsRequest loadAllReassignedChatsRequest)
    {
        Response<List<LoadAllReassignedChatsDTO>> response = new Response<>();

        try
        {
            response.setData(assignedBl.loadAllReassignedChats(loadAllReassignedChatsRequest));
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
    public Response<List<UploadAssignedDTO>> uploadAssigned(UploadAssignedRequest uploadAssignedRequest)
    {
        Response<List<UploadAssignedDTO>> response = new Response<>();

        try
        {
            List<UploadAssignedDTO> lista = assignedBl.uploadAssigned(uploadAssignedRequest);
            response.setData(lista);
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
    public Response<String> defuseChangeAssignedChat(
            @Valid DefuseChangeAssignedChatRequest defuseChangeAssignedChatRequest)
    {
        Response<String> response = new Response<>();

        try
        {
            assignedBl.defuseChangeAssignedChat(defuseChangeAssignedChatRequest);
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
    public Response<String> listDefuseChangeAssignedChat(
            @Valid ListDefuseChangeAssignedChatRequest listDefuseChangeAssignedChatRequest)
    {

        Response<String> response = new Response<>();

        try
        {
            assignedBl.listDefuseChangeAssignedChat(listDefuseChangeAssignedChatRequest);
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