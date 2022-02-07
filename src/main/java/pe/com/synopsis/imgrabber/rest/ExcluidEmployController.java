
package pe.com.synopsis.imgrabber.rest;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pe.com.synopsis.imgrabber.beans.dto.LoadAllExcluidEmployDTO;
import pe.com.synopsis.imgrabber.beans.dto.LoadExcluidEmployDTO;
import pe.com.synopsis.imgrabber.beans.request.AddExcluidEmployRequest;
import pe.com.synopsis.imgrabber.beans.request.DefuseExcluidEmployRequest;
import pe.com.synopsis.imgrabber.beans.request.LoadExcluidEmployRequest;
import pe.com.synopsis.imgrabber.beans.request.UpdateExcluidEmployRequest;
import pe.com.synopsis.imgrabber.beans.response.Response;
import pe.com.synopsis.imgrabber.enumeration.StatusEnum;
import pe.com.synopsis.imgrabber.security.SecurityToken;
import pe.com.synopsis.imgrabber.service.ExcluidEmployService;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/excluidEmploy/v1")
public class ExcluidEmployController
{

    @SuppressWarnings("unused")
    private static final Logger logger = LoggerFactory.getLogger(ExcluidEmployController.class);

    @Autowired
    private ExcluidEmployService excluidEmployService;

    @PostMapping("/updateExcluidEmploy")
    public ResponseEntity<Response<String>> updateExcluidEmploy(
            @Valid @RequestBody UpdateExcluidEmployRequest updateExcluidEmployRequest, Errors error)
    {

        if (error.hasErrors())
        {
            return StatusEnum.BAD_FORMAT.internalError(String.class);

        }
        else
        {
            Response<String> response = excluidEmployService.updateExcluidEmploy(updateExcluidEmployRequest);

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

    @PostMapping("/addExcluidEmploy")
    public ResponseEntity<Response<String>> addExcluidEmploy(
            @Valid @RequestBody AddExcluidEmployRequest addExcluidEmployRequest, Errors error)
    {

        if (error.hasErrors())
        {
            return StatusEnum.BAD_FORMAT.internalError(String.class);
        }
        else
        {
            Response<String> response = excluidEmployService.addExcluidEmploy(addExcluidEmployRequest);

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

    @PostMapping("/defuseExcluidEmploy")
    public ResponseEntity<Response<String>> defuseExcluidEmploy(
            @Valid @RequestBody DefuseExcluidEmployRequest defuseExcluidEmployRequest, Errors error)
    {

        if (error.hasErrors())
        {
            return StatusEnum.BAD_FORMAT.internalError(String.class);

        }
        else
        {
            Response<String> response = excluidEmployService.defuseExcluidEmploy(defuseExcluidEmployRequest);

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

    @PostMapping("/loadAllExcluidEmploy")
    public ResponseEntity<Response<List<LoadAllExcluidEmployDTO>>> loadAllExcluidEmploy(
            @AuthenticationPrincipal SecurityToken token)
    {

        Response<List<LoadAllExcluidEmployDTO>> response = excluidEmployService
                .loadAllExcluidEmploy(token.getUserInfo().getEmployPk());

        if (StatusEnum.STATUS_SUCCESSFULL.isCode(response.getStatus()))
        {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        else
        {
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/loadExcluidEmploy")
    public ResponseEntity<Response<LoadExcluidEmployDTO>> loadExcluidEmploy(
            @Valid @RequestBody LoadExcluidEmployRequest loadExcluidEmployRequest, Errors error)
    {

        if (error.hasErrors())
        {
            return StatusEnum.BAD_FORMAT.internalError(LoadExcluidEmployDTO.class);

        }
        else
        {
            Response<LoadExcluidEmployDTO> response = excluidEmployService.loadExcluidEmploy(loadExcluidEmployRequest);
            if (StatusEnum.STATUS_SUCCESSFULL.isCode(response.getStatus()))
            {
                return new ResponseEntity<>(response, HttpStatus.OK);
            }
            else
            {
                return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }
    }
}
