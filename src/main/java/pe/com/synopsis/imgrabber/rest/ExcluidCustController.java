
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

import pe.com.synopsis.imgrabber.beans.dto.LoadAllExcluidCustDTO;
import pe.com.synopsis.imgrabber.beans.request.AddExcluidCustRequest;
import pe.com.synopsis.imgrabber.beans.request.DefuseExcluidCustRequest;
import pe.com.synopsis.imgrabber.beans.response.Response;
import pe.com.synopsis.imgrabber.enumeration.StatusEnum;
import pe.com.synopsis.imgrabber.security.SecurityToken;
import pe.com.synopsis.imgrabber.service.ExcluidCustService;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/excluidCust/v1")
public class ExcluidCustController
{

    @SuppressWarnings("unused")
    private static final Logger logger = LoggerFactory.getLogger(ExcluidCustController.class);

    @Autowired
    private ExcluidCustService excluidCustService;

    @PostMapping("/loadAllExcluidCust")
    public ResponseEntity<Response<List<LoadAllExcluidCustDTO>>> loadAllExcluidCust(
            @AuthenticationPrincipal SecurityToken token)
    {

        Response<List<LoadAllExcluidCustDTO>> response = excluidCustService
                .loadAllExcluidCust(token.getUserInfo().getEmployPk());

        if (StatusEnum.STATUS_SUCCESSFULL.isCode(response.getStatus()))
        {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        else
        {
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/defuseExcluidCust")
    public ResponseEntity<Response<String>> defuseExcluidCust(
            @Valid @RequestBody DefuseExcluidCustRequest defuseExcluidCustRequest, Errors error)
    {

        if (error.hasErrors())
        {
            return StatusEnum.BAD_FORMAT.internalError(String.class);

        }
        else
        {
            Response<String> response = excluidCustService.defuseExcluidCust(defuseExcluidCustRequest);

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

    @PostMapping("/addExcluidCust")
    public ResponseEntity<Response<String>> addExcluidCust(@AuthenticationPrincipal SecurityToken token,
            @Valid @RequestBody AddExcluidCustRequest addExcluidCustRequest, Errors error)
    {

        if (error.hasErrors())
        {
            return StatusEnum.BAD_FORMAT.internalError(String.class);

        }
        else
        {
            Response<String> response = excluidCustService.addExcluidCust(addExcluidCustRequest,
                    token.getUserInfo().getEmployPk());

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
