
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

import pe.com.synopsis.imgrabber.beans.dto.LoadAllAreaByRoleDTO;
import pe.com.synopsis.imgrabber.beans.dto.LoadAllAreaDTO;
import pe.com.synopsis.imgrabber.beans.dto.LoadAreaDTO;
import pe.com.synopsis.imgrabber.beans.request.AddAreaRequest;
import pe.com.synopsis.imgrabber.beans.request.DefuseAreaRequest;
import pe.com.synopsis.imgrabber.beans.request.LoadAreaRequest;
import pe.com.synopsis.imgrabber.beans.request.UpdateAreaRequest;
import pe.com.synopsis.imgrabber.beans.response.Response;
import pe.com.synopsis.imgrabber.enumeration.StatusEnum;
import pe.com.synopsis.imgrabber.security.SecurityToken;
import pe.com.synopsis.imgrabber.service.AreaService;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/area/v1")
public class AreaController
{
    
    @SuppressWarnings("unused")
    private static final Logger logger = LoggerFactory.getLogger(AreaController.class);

    @Autowired
    private AreaService areaService;

    @PostMapping("/loadAllArea")
    public ResponseEntity<Response<List<LoadAllAreaDTO>>> loadAllArea(@AuthenticationPrincipal SecurityToken token)
    {

        Response<List<LoadAllAreaDTO>> response = areaService.loadAllArea(token.getUserInfo().getEmployPk());

        if (StatusEnum.STATUS_SUCCESSFULL.isCode(response.getStatus()))
        {
            return new ResponseEntity<Response<List<LoadAllAreaDTO>>>(response, HttpStatus.OK);
        }
        else
        {
            return new ResponseEntity<Response<List<LoadAllAreaDTO>>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/loadAllAreaByRole")
    public ResponseEntity<Response<List<LoadAllAreaByRoleDTO>>> loadAllAreaByRole(
            @AuthenticationPrincipal SecurityToken token)
    {

        Response<List<LoadAllAreaByRoleDTO>> response = areaService
                .loadAllAreaByRole(token.getUserInfo().getEmployPk());

        if (StatusEnum.STATUS_SUCCESSFULL.isCode(response.getStatus()))
        {
            return new ResponseEntity<Response<List<LoadAllAreaByRoleDTO>>>(response, HttpStatus.OK);
        }
        else
        {
            return new ResponseEntity<Response<List<LoadAllAreaByRoleDTO>>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @PostMapping("/loadArea")
    @SuppressWarnings("unchecked")
    public ResponseEntity<Response<LoadAreaDTO>> loadArea(@Valid @RequestBody LoadAreaRequest loadAreaRequest,
            Errors error)
    {

        if (error.hasErrors())
        {
            return StatusEnum.BAD_FORMAT.internalError(((Class<LoadAreaDTO>) (Object) List.class));

        }
        else
        {
            
            Response<LoadAreaDTO> response = areaService.loadArea(loadAreaRequest);
            logger.info(loadAreaRequest.toString());
            

            if (StatusEnum.STATUS_SUCCESSFULL.isCode(response.getStatus()))
            {
                return new ResponseEntity<Response<LoadAreaDTO>>(response, HttpStatus.OK);
            }
            else
            {
                return new ResponseEntity<Response<LoadAreaDTO>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }
    }

    @PostMapping("/updateArea")
    public ResponseEntity<Response<String>> updateArea(@Valid @RequestBody UpdateAreaRequest areaRequest, Errors error)
    {

        if (error.hasErrors())
        {
            return StatusEnum.BAD_FORMAT.internalError(String.class);

        }
        else
        {
            Response<String> response = areaService.updateArea(areaRequest);

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

    @PostMapping("/addArea")
    public ResponseEntity<Response<String>> addArea(@Valid @RequestBody AddAreaRequest areaRequest, Errors error)
    {

        if (error.hasErrors())
        {
            return StatusEnum.BAD_FORMAT.internalError(String.class);

        }
        else
        {
            Response<String> response = areaService.addArea(areaRequest);

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

    @PostMapping("/defuseArea")
    public ResponseEntity<Response<String>> defuseArea(@Valid @RequestBody DefuseAreaRequest defuseAreaRequest,
            Errors error)
    {

        if (error.hasErrors())
        {
            return StatusEnum.BAD_FORMAT.internalError(String.class);

        }
        else
        {
            Response<String> response = areaService.defuseArea(defuseAreaRequest);

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