
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

import pe.com.synopsis.imgrabber.beans.dto.LoadGeneralConfigDTO;
import pe.com.synopsis.imgrabber.beans.request.UpdateGeneralConfigRequest;
import pe.com.synopsis.imgrabber.beans.response.Response;
import pe.com.synopsis.imgrabber.enumeration.StatusEnum;
import pe.com.synopsis.imgrabber.service.GeneralConfigService;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/generalConfig/v1")
public class GeneralConfigController
{

    @Autowired
    GeneralConfigService generalConfigService;

    @PostMapping("/loadGeneralConfig")
    public ResponseEntity<Response<List<LoadGeneralConfigDTO>>> loadGeneralConfig()
    {

        Response<List<LoadGeneralConfigDTO>> response = generalConfigService.loadGeneralConfig();

        if (StatusEnum.STATUS_SUCCESSFULL.isCode(response.getStatus()))
        {

            return new ResponseEntity<Response<List<LoadGeneralConfigDTO>>>(response, HttpStatus.OK);
        }
        else
        {

            return new ResponseEntity<Response<List<LoadGeneralConfigDTO>>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @PostMapping("/updateGeneralConfig")
    public ResponseEntity<Response<String>> updateGeneralConfig(
            @Valid @RequestBody UpdateGeneralConfigRequest generalConfigRequest, Errors error)
    {

        if (error.hasErrors())
        {
            return StatusEnum.BAD_FORMAT.internalError(String.class);
        }
        else
        {

            Response<String> response = generalConfigService.updateGeneralConfig(generalConfigRequest);

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
