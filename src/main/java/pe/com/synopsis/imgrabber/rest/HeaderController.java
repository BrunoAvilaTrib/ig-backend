
package pe.com.synopsis.imgrabber.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pe.com.synopsis.imgrabber.beans.dto.HeaderDTO;
import pe.com.synopsis.imgrabber.beans.response.Response;
import pe.com.synopsis.imgrabber.enumeration.StatusEnum;
import pe.com.synopsis.imgrabber.security.SecurityToken;
import pe.com.synopsis.imgrabber.service.HeaderService;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/header/v1")
public class HeaderController
{

    @Autowired
    private HeaderService headerService;

    @PostMapping("/loadHeader")
    public ResponseEntity<Response<List<HeaderDTO>>> loadHeader(@AuthenticationPrincipal SecurityToken token)
    {

        Response<List<HeaderDTO>> response = headerService.loadHeader(token.getUserInfo().getEmail());

        if (StatusEnum.STATUS_SUCCESSFULL.isCode(response.getStatus()))
        {
            return new ResponseEntity<Response<List<HeaderDTO>>>(response, HttpStatus.OK);
        }
        else
        {
            return new ResponseEntity<Response<List<HeaderDTO>>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
