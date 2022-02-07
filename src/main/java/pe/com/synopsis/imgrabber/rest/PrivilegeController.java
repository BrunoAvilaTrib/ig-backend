
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

import pe.com.synopsis.imgrabber.beans.dto.LoadBySupervisorPrivilegeDTO;
import pe.com.synopsis.imgrabber.beans.dto.LoadPrivilegeDTO;
import pe.com.synopsis.imgrabber.beans.response.Response;
import pe.com.synopsis.imgrabber.enumeration.StatusEnum;
import pe.com.synopsis.imgrabber.security.SecurityToken;
import pe.com.synopsis.imgrabber.service.PrivilegeService;

@RestController
@RequestMapping("/privilege/v1")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class PrivilegeController
{

    @Autowired
    private PrivilegeService privilegesService;

    @PostMapping("/loadBySupervisorPrivilege")
    public ResponseEntity<Response<List<LoadBySupervisorPrivilegeDTO>>> loadBySupervisorPrivilege(
            @AuthenticationPrincipal SecurityToken token)
    {

        Response<List<LoadBySupervisorPrivilegeDTO>> response = privilegesService
                .loadBySupervisorPrivilege(token.getUserInfo().getEmail());

        if (StatusEnum.STATUS_SUCCESSFULL.isCode(response.getStatus()))
        {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        else
        {
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @PostMapping("/loadPrivilege")
    public ResponseEntity<Response<List<LoadPrivilegeDTO>>> loadPrivilege()
    {

        Response<List<LoadPrivilegeDTO>> response = privilegesService.loadPrivilege();

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
