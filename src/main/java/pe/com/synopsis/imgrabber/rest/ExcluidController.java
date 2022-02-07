
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

import pe.com.synopsis.imgrabber.beans.dto.LoadAllExcluidDTO;
import pe.com.synopsis.imgrabber.beans.request.LoadAllExcluidRequest;
import pe.com.synopsis.imgrabber.beans.response.Response;
import pe.com.synopsis.imgrabber.enumeration.StatusEnum;
import pe.com.synopsis.imgrabber.service.ExcluidService;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/excluid/v1")
public class ExcluidController
{

    @Autowired
    private ExcluidService excluidService;

    @SuppressWarnings("unchecked")
    @PostMapping("/loadAllExcluid")
    public ResponseEntity<Response<LoadAllExcluidDTO>> loadExcluid(
            @Valid @RequestBody LoadAllExcluidRequest loadAllExcluidRequest, Errors error)
    {

        if (error.hasErrors())
        {
            return StatusEnum.BAD_FORMAT.internalError((Class<LoadAllExcluidDTO>) (Object) List.class);

        }
        else
        {
            Response<LoadAllExcluidDTO> response = excluidService.loadAllExcluid(loadAllExcluidRequest);

            if (StatusEnum.STATUS_SUCCESSFULL.isCode(response.getStatus()))
            {
                return new ResponseEntity<Response<LoadAllExcluidDTO>>(response, HttpStatus.OK);
            }
            else
            {
                return new ResponseEntity<Response<LoadAllExcluidDTO>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }
    }
}
