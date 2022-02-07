
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

import pe.com.synopsis.imgrabber.beans.dto.LoadEmployConfigDTO;
import pe.com.synopsis.imgrabber.beans.request.LoadEmployConfigRequest;
import pe.com.synopsis.imgrabber.beans.request.UpdateEmployConfigRequest;
import pe.com.synopsis.imgrabber.beans.response.Response;
import pe.com.synopsis.imgrabber.enumeration.StatusEnum;
import pe.com.synopsis.imgrabber.service.ConfigService;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/config/v1")
public class ConfigController
{

    @Autowired
    private ConfigService configServic;

    @PostMapping("/updateEmployConfig")
    public ResponseEntity<Response<String>> updateEmployConfig(
            @Valid @RequestBody UpdateEmployConfigRequest updateEmployConfigRequest, Errors error)
    {

        if (error.hasErrors())
        {
            return StatusEnum.BAD_FORMAT.internalError(String.class);
        }
        else
        {

            Response<String> response = configServic.updateEmployConfig(updateEmployConfigRequest);

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

    @SuppressWarnings("unchecked")
    @PostMapping("/loadEmployConfig")
    public ResponseEntity<Response<LoadEmployConfigDTO>> loadEmployConfig(
            @Valid @RequestBody LoadEmployConfigRequest loadConfigRequest, Errors error)
    {

        if (error.hasErrors())
        {
            return StatusEnum.BAD_FORMAT.internalError(((Class<LoadEmployConfigDTO>) (Object) List.class));
        }
        else
        {

            Response<LoadEmployConfigDTO> response = configServic.loadEmployConfig(loadConfigRequest);

            if (StatusEnum.STATUS_SUCCESSFULL.isCode(response.getStatus()))
            {

                return new ResponseEntity<Response<LoadEmployConfigDTO>>(response, HttpStatus.OK);
            }
            else
            {

                return new ResponseEntity<Response<LoadEmployConfigDTO>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
            }

        }

    }

}
