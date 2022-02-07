
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
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
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
import pe.com.synopsis.imgrabber.enumeration.StatusEnum;
import pe.com.synopsis.imgrabber.service.ChatService;
import pe.com.synopsis.imgrabber.support.WhatsappBusinessApi;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/chat/v1")
@Api(value = "Chat Web Imgrabber")
public class ChatController
{

    @Autowired
    private ChatService chatService;

    @Autowired
    private WhatsappBusinessApi whatsappBusinessApi;

    @ApiOperation(value = "Permite al usuario consultar datos del chat")
    @ApiResponses(value = { @ApiResponse(code = 0000, message = "El servicio se ha ejecutado de forma correcta.") })
    @PostMapping(value = "/contacts")
    @SuppressWarnings("unchecked")
    public ResponseEntity<Response<List<ContactDTO>>> loadContact(@Valid @RequestBody LoadContactRequest request,
            Errors error)
    {

        if (error.hasErrors())
        {
            return StatusEnum.BAD_FORMAT.internalError((Class<List<ContactDTO>>) (Object) List.class);

        }
        else
        {
            Response<List<ContactDTO>> response = chatService.loadContact(request);

            if (StatusEnum.STATUS_SUCCESSFULL.isCode(response.getStatus()))
            {
                return new ResponseEntity<Response<List<ContactDTO>>>(response, HttpStatus.OK);
            }
            else
            {
                return new ResponseEntity<Response<List<ContactDTO>>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }
    }

    @ApiOperation(value = "Permite al usuario consultar datos del chat")
    @ApiResponses(value = { @ApiResponse(code = 0000, message = "El servicio se ha ejecutado de forma correcta.") })
    @PostMapping(value = "/pages")
    @SuppressWarnings("unchecked")
    public ResponseEntity<Response<List<PageDTO>>> loadPages(@Valid @RequestBody LoadPagesRequest request, Errors error)
    {

        if (error.hasErrors())
        {
            return StatusEnum.BAD_FORMAT.internalError((Class<List<PageDTO>>) (Object) List.class);

        }
        else
        {
            Response<List<PageDTO>> response = chatService.loadPages(request);

            if (StatusEnum.STATUS_SUCCESSFULL.isCode(response.getStatus()))
            {
                return new ResponseEntity<Response<List<PageDTO>>>(response, HttpStatus.OK);
            }
            else
            {
                return new ResponseEntity<Response<List<PageDTO>>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }
    }

    @ApiOperation(value = "Permite al usuario consultar datos del chat")
    @ApiResponses(value = { @ApiResponse(code = 0000, message = "El servicio se ha ejecutado de forma correcta.") })
    @PostMapping(value = "/messages")
    @SuppressWarnings("unchecked")
    public ResponseEntity<Response<List<MessageDTO>>> loadMessages(@Valid @RequestBody LoadMessagesRequest request,
            Errors error)
    {

        if (error.hasErrors())
        {
            return StatusEnum.BAD_FORMAT.internalError((Class<List<MessageDTO>>) (Object) List.class);

        }
        else
        {
            Response<List<MessageDTO>> response = chatService.loadMessages(request);

            if (StatusEnum.STATUS_SUCCESSFULL.isCode(response.getStatus()))
            {
                return new ResponseEntity<Response<List<MessageDTO>>>(response, HttpStatus.OK);
            }
            else
            {
                return new ResponseEntity<Response<List<MessageDTO>>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }
    }

    @PostMapping("/getLastUpdate")
    public ResponseEntity<Response<List<GetLastUpdateDTO>>> getLastUpdate(
            @Valid @RequestBody GetLastUpdateRequest getLastUpdateRequest, Errors error)
    {

        Response<List<GetLastUpdateDTO>> response = chatService.getLastUpdate(getLastUpdateRequest);

        if (StatusEnum.STATUS_SUCCESSFULL.isCode(response.getStatus()))
        {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        else
        {
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/getLastUpdateMSG")
    public ResponseEntity<Response<List<GetLastUpdateMSGDTO>>> getLastUpdateMSG(
            @Valid @RequestBody GetLastUpdateRequest getLastUpdateRequest, Errors error)
    {

        Response<List<GetLastUpdateMSGDTO>> response = chatService.getLastUpdateMSG(getLastUpdateRequest);

        if (StatusEnum.STATUS_SUCCESSFULL.isCode(response.getStatus()))
        {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        else
        {
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/registerMessage")
    public ResponseEntity<Response<String>> registerMessage(
            @Valid @RequestBody RegisterMessageRequest registerMessageRequest, Errors error)
    {

        if (error.hasErrors())
        {
            return StatusEnum.BAD_FORMAT.internalError(String.class);

        }
        else
        {
            Response<String> response = chatService.registerMessage(registerMessageRequest);

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

    @PostMapping("/sendMessage")
    public ResponseEntity<Response<String>> sendMessage(
            @Valid @RequestBody RegisterMessageRequest registerMessageRequest, Errors error)
    {

        if (error.hasErrors())
        {
            return StatusEnum.BAD_FORMAT.internalError(String.class);

        }
        else
        {
            // Enviar mensaje via api whatsapp de twilio
            Response<String> response = whatsappBusinessApi.send(registerMessageRequest);

            if (StatusEnum.STATUS_SUCCESSFULL.isCode(response.getStatus()))
            {
                // Si el mensaje se envia correctamente
                // Lo registramos en BD
                Response<String> registerResponse = chatService.registerMessage(registerMessageRequest);

                if (StatusEnum.STATUS_SUCCESSFULL.isCode(registerResponse.getStatus()))
                {
                    return new ResponseEntity<Response<String>>(response, HttpStatus.OK);
                }
                else
                {
                    return new ResponseEntity<Response<String>>(registerResponse, HttpStatus.INTERNAL_SERVER_ERROR);
                }
            }
            else
            {
                return new ResponseEntity<Response<String>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }
    }
}