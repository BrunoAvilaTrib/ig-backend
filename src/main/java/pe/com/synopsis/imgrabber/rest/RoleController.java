
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

import pe.com.synopsis.imgrabber.beans.dto.LoadRoleDTO;
import pe.com.synopsis.imgrabber.beans.response.Response;
import pe.com.synopsis.imgrabber.enumeration.StatusEnum;
import pe.com.synopsis.imgrabber.security.SecurityToken;
import pe.com.synopsis.imgrabber.service.RoleService;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/role/v1")
public class RoleController
{

    @Autowired
    private RoleService roleService;

    @PostMapping("/loadRole")
    public ResponseEntity<Response<List<LoadRoleDTO>>> loadRole(@AuthenticationPrincipal SecurityToken token)
    {

        Response<List<LoadRoleDTO>> response = roleService.loadRole(token.getUserInfo().getEmployPk());

        if (StatusEnum.STATUS_SUCCESSFULL.isCode(response.getStatus()))
        {
            return new ResponseEntity<Response<List<LoadRoleDTO>>>(response, HttpStatus.OK);
        }
        else
        {
            return new ResponseEntity<Response<List<LoadRoleDTO>>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
