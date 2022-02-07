
package pe.com.synopsis.imgrabber.rest;

import java.util.List;

import javax.validation.Valid;

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

import pe.com.synopsis.imgrabber.beans.dto.LoadAllBusinessByRoleDTO;
import pe.com.synopsis.imgrabber.beans.dto.LoadAllBusinessDTO;
import pe.com.synopsis.imgrabber.beans.dto.LoadBusinessDTO;
import pe.com.synopsis.imgrabber.beans.request.AddBusinessRequest;
import pe.com.synopsis.imgrabber.beans.request.LoadBusinessRequest;
import pe.com.synopsis.imgrabber.beans.request.UpdateBusinessRequest;
import pe.com.synopsis.imgrabber.beans.response.Response;
import pe.com.synopsis.imgrabber.enumeration.StatusEnum;
import pe.com.synopsis.imgrabber.security.SecurityToken;
import pe.com.synopsis.imgrabber.service.BusinessService;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/business/v1")
public class BusinessController
{

    @Autowired
    private BusinessService businessService;

    @PostMapping("/loadAllBusiness")
    public ResponseEntity<Response<List<LoadAllBusinessDTO>>> loadAllBusiness()
    {

        Response<List<LoadAllBusinessDTO>> response = businessService.loadAllBusiness();

        if (StatusEnum.STATUS_SUCCESSFULL.isCode(response.getStatus()))
        {
            return new ResponseEntity<Response<List<LoadAllBusinessDTO>>>(response, HttpStatus.OK);
        }
        else
        {
            return new ResponseEntity<Response<List<LoadAllBusinessDTO>>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/loadAllBusinessByRole")
    public ResponseEntity<Response<List<LoadAllBusinessByRoleDTO>>> loadAllBusinessByRole(
            @AuthenticationPrincipal SecurityToken token)
    {

        Response<List<LoadAllBusinessByRoleDTO>> response = businessService
                .loadAllBusinessByRole(token.getUserInfo().getEmployPk());
        if (StatusEnum.STATUS_SUCCESSFULL.isCode(response.getStatus()))
        {
            return new ResponseEntity<Response<List<LoadAllBusinessByRoleDTO>>>(response, HttpStatus.OK);
        }
        else
        {
            return new ResponseEntity<Response<List<LoadAllBusinessByRoleDTO>>>(response,
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/loadBusiness")
    @SuppressWarnings("unchecked")
    public ResponseEntity<Response<LoadBusinessDTO>> loadBusiness(
            @Valid @RequestBody LoadBusinessRequest loadBusinessRequest, Errors error)
    {

        if (error.hasErrors())
        {
            return StatusEnum.BAD_FORMAT.internalError(((Class<LoadBusinessDTO>) (Object) List.class));

        }
        else
        {
            Response<LoadBusinessDTO> response = businessService.loadBusiness(loadBusinessRequest);

            if (StatusEnum.STATUS_SUCCESSFULL.isCode(response.getStatus()))
            {
                return new ResponseEntity<Response<LoadBusinessDTO>>(response, HttpStatus.OK);
            }
            else
            {
                return new ResponseEntity<Response<LoadBusinessDTO>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }
    }

    @PostMapping("/updateBusiness")
    public ResponseEntity<Response<String>> updateBusiness(
            @Valid @RequestBody UpdateBusinessRequest updateBusinessRequest, Errors error)
    {

        if (error.hasErrors())
        {
            return StatusEnum.BAD_FORMAT.internalError(String.class);

        }
        else
        {
            Response<String> response = businessService.updateBusiness(updateBusinessRequest);

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

    @PostMapping("/addBusiness")
    public ResponseEntity<Response<String>> addBusiness(@Valid @RequestBody AddBusinessRequest businessRequest,
            Errors error)
    {

        if (error.hasErrors())
        {
            return StatusEnum.BAD_FORMAT.internalError(String.class);

        }
        else
        {
            Response<String> response = businessService.addBusiness(businessRequest);

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
