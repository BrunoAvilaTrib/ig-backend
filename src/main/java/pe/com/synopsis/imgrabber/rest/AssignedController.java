
package pe.com.synopsis.imgrabber.rest;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
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
import pe.com.synopsis.imgrabber.enumeration.StatusEnum;
import pe.com.synopsis.imgrabber.service.AssignedService;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/assigned/v1")
@Api(value = "Chat Web Imgrabber")
public class AssignedController
{

    @Autowired
    private AssignedService assignedService;

    @PostMapping("/changeAssignedChat")
    public ResponseEntity<Response<String>> changeAssignedChat(
            @Valid @RequestBody ChangeAssignedChatRequest changeAssignedChatRequest, Errors error)
    {

        if (error.hasErrors())
        {
            return StatusEnum.BAD_FORMAT.internalError(String.class);

        }
        else
        {
            Response<String> response = assignedService.changeAssignedChat(changeAssignedChatRequest);

            if (StatusEnum.STATUS_SUCCESSFULL.isCode(response.getStatus()))
            {
                return new ResponseEntity<Response<String>>(response, HttpStatus.OK);
            }
            else
            {
                return new ResponseEntity<Response<String>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }
    }

    @PostMapping("/listChangeAssignedChat")
    public ResponseEntity<Response<String>> listChangeAssignedChat(
            @Valid @RequestBody ListChangeAssignedChatRequest listChangeAssignedChatRequest, Errors error)
    {

        if (error.hasErrors())
        {
            return StatusEnum.BAD_FORMAT.internalError(String.class);
        }
        else
        {
            Response<String> response = assignedService.listChangeAssignedChat(listChangeAssignedChatRequest);

            if (StatusEnum.STATUS_SUCCESSFULL.isCode(response.getStatus()))
            {
                return new ResponseEntity<Response<String>>(response, HttpStatus.OK);
            }
            else
            {
                return new ResponseEntity<Response<String>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }
    }

    @PostMapping("/automaticReassigned")
    public ResponseEntity<Response<String>> automaticReassigned(
            @Valid @RequestBody AutomaticReassignedRequest automaticReassignedRequest, Errors error)
    {

        if (error.hasErrors())
        {
            return StatusEnum.BAD_FORMAT.internalError(String.class);

        }
        else
        {
            Response<String> response = assignedService.automaticReassigned(automaticReassignedRequest);

            if (StatusEnum.STATUS_SUCCESSFULL.isCode(response.getStatus()))
            {
                return new ResponseEntity<Response<String>>(response, HttpStatus.OK);
            }
            else
            {
                return new ResponseEntity<Response<String>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }
    }

    @PostMapping("/updateAssigned")
    public ResponseEntity<Response<String>> updateAssigned(
            @Valid @RequestBody UpdateAssignedRequest updateAssignedRequest, Errors error)
    {

        if (error.hasErrors())
        {
            return StatusEnum.BAD_FORMAT.internalError(String.class);

        }
        else
        {
            Response<String> response = assignedService.updateAssigned(updateAssignedRequest);

            if (StatusEnum.STATUS_SUCCESSFULL.isCode(response.getStatus()))
            {
                return new ResponseEntity<Response<String>>(response, HttpStatus.OK);
            }
            else
            {
                return new ResponseEntity<Response<String>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }
    }

    @PostMapping("/loadChatsReassignedEmploy")
    public ResponseEntity<Response<List<LoadChatsReassignedEmployDTO>>> loadChatsReassignedEmploy(
            @Valid @RequestBody LoadChatsReassignedEmployRequest loadChatsReassignedEmployRequest, Errors error)
    {

        Response<List<LoadChatsReassignedEmployDTO>> response = assignedService
                .loadChatsReassignedEmploy(loadChatsReassignedEmployRequest);

        if (StatusEnum.STATUS_SUCCESSFULL.isCode(response.getStatus()))
        {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        else
        {
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/loadAllReassignedChats")
    public ResponseEntity<Response<List<LoadAllReassignedChatsDTO>>> loadAllReassignedChats(
            @Valid @RequestBody LoadAllReassignedChatsRequest loadAllReassignedChatsRequest, Errors error)
    {

        Response<List<LoadAllReassignedChatsDTO>> response = assignedService
                .loadAllReassignedChats(loadAllReassignedChatsRequest);

        if (StatusEnum.STATUS_SUCCESSFULL.isCode(response.getStatus()))
        {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        else
        {
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @SuppressWarnings("unchecked")
    @PostMapping("/uploadAssigned")
    public ResponseEntity<Response<List<UploadAssignedDTO>>> uploadAssigned(
            @Valid @RequestBody UploadAssignedRequest uploadAssignedRequest, Errors error)
    {

        if (error.hasErrors())
        {
            return StatusEnum.BAD_FORMAT.internalError(((Class<List<UploadAssignedDTO>>) (Object) List.class));
        }
        else
        {
            Response<List<UploadAssignedDTO>> response = assignedService.uploadAssigned(uploadAssignedRequest);

            if (StatusEnum.STATUS_SUCCESSFULL.isCode(response.getStatus()))
            {
                return new ResponseEntity<Response<List<UploadAssignedDTO>>>(response, HttpStatus.OK);
            }
            else
            {
                return new ResponseEntity<Response<List<UploadAssignedDTO>>>(response,
                        HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }
    }

    @PostMapping("/defuseChangeAssignedChat")
    public ResponseEntity<Response<String>> defuseChangeAssignedChat(
            @Valid @RequestBody DefuseChangeAssignedChatRequest defuseChangeAssignedChatRequest, Errors error)
    {

        if (error.hasErrors())
        {
            return StatusEnum.BAD_FORMAT.internalError(String.class);

        }
        else
        {
            Response<String> response = assignedService.defuseChangeAssignedChat(defuseChangeAssignedChatRequest);

            if (StatusEnum.STATUS_SUCCESSFULL.isCode(response.getStatus()))
            {
                return new ResponseEntity<Response<String>>(response, HttpStatus.OK);
            }
            else
            {
                return new ResponseEntity<Response<String>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }
    }

    @PostMapping("/listDefuseChangeAssignedChat")
    public ResponseEntity<Response<String>> listDefuseChangeAssignedChat(
            @Valid @RequestBody ListDefuseChangeAssignedChatRequest listDefuseChangeAssignedChatRequest, Errors error)
    {

        if (error.hasErrors())
        {
            return StatusEnum.BAD_FORMAT.internalError(String.class);
        }
        else
        {
            Response<String> response = assignedService
                    .listDefuseChangeAssignedChat(listDefuseChangeAssignedChatRequest);

            if (StatusEnum.STATUS_SUCCESSFULL.isCode(response.getStatus()))
            {
                return new ResponseEntity<Response<String>>(response, HttpStatus.OK);
            }
            else
            {
                return new ResponseEntity<Response<String>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }
    }
}