
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

import pe.com.synopsis.imgrabber.beans.dto.LoadEmployTrazeDTO;
import pe.com.synopsis.imgrabber.beans.request.AddEmployTrazeRequest;
import pe.com.synopsis.imgrabber.beans.response.Response;
import pe.com.synopsis.imgrabber.enumeration.StatusEnum;
import pe.com.synopsis.imgrabber.security.SecurityToken;
import pe.com.synopsis.imgrabber.service.EmployTrazeService;

@RestController
@RequestMapping("/employTraze/v1")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class EmployTrazeController
{

    @SuppressWarnings("unused")
    private static final Logger logger = LoggerFactory.getLogger(EmployTrazeController.class);
    @Autowired
    private EmployTrazeService employTrazeService;

    @PostMapping("/loadEmployTrace")
    public ResponseEntity<Response<List<LoadEmployTrazeDTO>>> loadTrace()
    {

        Response<List<LoadEmployTrazeDTO>> response = employTrazeService.loadEmployTrace();

        if (StatusEnum.STATUS_SUCCESSFULL.isCode(response.getStatus()))
        {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        else
        {
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @PostMapping("/addEmployTraze")
    public ResponseEntity<Response<String>> addTraze(@AuthenticationPrincipal SecurityToken token,
            @Valid @RequestBody AddEmployTrazeRequest addTrazeRequest, Errors error)
    {
        if (error.hasErrors())
        {
            return StatusEnum.BAD_FORMAT.internalError(String.class);
        }
        else
        {
            Response<String> response = employTrazeService.addEmployTraze(addTrazeRequest,
                    token.getUserInfo().getEmail());

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
