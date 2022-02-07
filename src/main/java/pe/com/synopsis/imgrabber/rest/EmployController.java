
package pe.com.synopsis.imgrabber.rest;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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

import pe.com.synopsis.imgrabber.beans.dto.LoadAllEmployByRoleDTO;
import pe.com.synopsis.imgrabber.beans.dto.LoadAllEmployDTO;
import pe.com.synopsis.imgrabber.beans.dto.LoadEmployDTO;
import pe.com.synopsis.imgrabber.beans.request.AddAdminEmployRequest;
import pe.com.synopsis.imgrabber.beans.request.AddOfficerEmployRequest;
import pe.com.synopsis.imgrabber.beans.request.AddSupervisorEmployRequest;
import pe.com.synopsis.imgrabber.beans.request.DefuseEmployRequest;
import pe.com.synopsis.imgrabber.beans.request.DefuseSupervisorRequest;
import pe.com.synopsis.imgrabber.beans.request.LoadAreaRequest;
import pe.com.synopsis.imgrabber.beans.request.LoadEmployRequest;
import pe.com.synopsis.imgrabber.beans.request.UpdateAdminEmployRequest;
import pe.com.synopsis.imgrabber.beans.request.UpdateAdminGlobalPasswordRequest;
import pe.com.synopsis.imgrabber.beans.request.UpdateOfficerEmployRequest;
import pe.com.synopsis.imgrabber.beans.request.UpdateSupervisorEmployRequest;
import pe.com.synopsis.imgrabber.beans.response.Response;
import pe.com.synopsis.imgrabber.enumeration.StatusEnum;
import pe.com.synopsis.imgrabber.security.SecurityToken;
import pe.com.synopsis.imgrabber.service.EmployService;
import pe.com.synopsis.imgrabber.support.IMGrabberUtils;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/employ/v1")
public class EmployController
{

    @SuppressWarnings("unused")
    private static final Logger logger = LoggerFactory.getLogger(EmployController.class);

    @Autowired
    private EmployService employService;

    @Autowired
    private IMGrabberUtils iMGrabberUtils;

    @PostMapping(value = "/loadAllEmployByArea")
    public ResponseEntity<Response<List<LoadAllEmployByRoleDTO>>> loadAllEmployByArea(
            @Valid @RequestBody LoadAreaRequest loadAreaRequest, @AuthenticationPrincipal SecurityToken token)
    {
        
        
        Response<List<LoadAllEmployByRoleDTO>> response = employService.loadAllEmployByArea(loadAreaRequest,
                token.getUserInfo().getEmployPk());

        if (StatusEnum.STATUS_SUCCESSFULL.isCode(response.getStatus()))
        {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        else
        {
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping(value = "/loadAllSupervisorByArea")
    @SuppressWarnings("unchecked")
    public ResponseEntity<Response<List<LoadAllEmployByRoleDTO>>> loadAllSupervisorByArea(
            @Valid @RequestBody LoadAreaRequest loadAreaRequest, Errors error)
    {

        if (error.hasErrors())
        {
            return StatusEnum.BAD_FORMAT.internalError(((Class<List<LoadAllEmployByRoleDTO>>) (Object) List.class));
        }
        else
        {
            Response<List<LoadAllEmployByRoleDTO>> response = employService.loadAllSupervisorByArea(loadAreaRequest);
            if (StatusEnum.STATUS_SUCCESSFULL.isCode(response.getStatus()))
            {
                return new ResponseEntity<Response<List<LoadAllEmployByRoleDTO>>>(response, HttpStatus.OK);
            }
            else
            {
                return new ResponseEntity<Response<List<LoadAllEmployByRoleDTO>>>(response,
                        HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }
    }

    @PostMapping(value = "/loadAllOfficerBySupervisor")
    @SuppressWarnings("unchecked")
    public ResponseEntity<Response<List<LoadAllEmployByRoleDTO>>> loadAllOfficerBySupervisor(
            @Valid @RequestBody LoadEmployRequest loadEmployRequest, Errors error)
    {

        if (error.hasErrors())
        {
            return StatusEnum.BAD_FORMAT.internalError(((Class<List<LoadAllEmployByRoleDTO>>) (Object) List.class));
        }
        else
        {
            Response<List<LoadAllEmployByRoleDTO>> response = employService
                    .loadAllOfficerBySupervisor(loadEmployRequest);

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

    @PostMapping(value = "/loadAllEmploy")
    public ResponseEntity<Response<List<LoadAllEmployDTO>>> loadAllEmploy(@AuthenticationPrincipal SecurityToken token)
    {

        Response<List<LoadAllEmployDTO>> response = employService.loadAllEmploy(token.getUserInfo().getEmployPk());
        if (StatusEnum.STATUS_SUCCESSFULL.isCode(response.getStatus()))
        {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        else
        {
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping(value = "/loadRoleEmploy")
    public ResponseEntity<Response<LoadEmployDTO>> loadEmploy(@AuthenticationPrincipal SecurityToken token)
    {

        Response<LoadEmployDTO> response = employService.loadRoleEmploy(token.getUserInfo().getEmployPk());
        if (StatusEnum.STATUS_SUCCESSFULL.isCode(response.getStatus()))
        {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        else
        {
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @PostMapping("/loadEmploy")
    public ResponseEntity<Response<LoadEmployDTO>> loadEmploy(@Valid @RequestBody LoadEmployRequest loadEmployRequest,
            Errors error)
    {

        if (error.hasErrors())
        {
            return StatusEnum.BAD_FORMAT.internalError(LoadEmployDTO.class);

        }
        else
        {
            Response<LoadEmployDTO> response = employService.loadEmploy(loadEmployRequest);
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

    @PostMapping(value = "/addAdminEmploy")
    public ResponseEntity<Response<String>> addAdminEmploy(
            @Valid @RequestBody AddAdminEmployRequest addAdminEmployRequest,
            @AuthenticationPrincipal SecurityToken token, Errors errors)
    {

        addAdminEmployRequest.setPassword(iMGrabberUtils.decodeBase64(addAdminEmployRequest.getPassword()));
        Pattern pattern = Pattern.compile("^(?=.*[A-Z])(?=.*[a-z])(?=.*\\d)([A-Za-z\\d]){8,60}$|^$");
        Matcher matcher = pattern.matcher(addAdminEmployRequest.getPassword());
        boolean result = matcher.find();

        if (errors.hasErrors() || result == false)
        {
            return StatusEnum.BAD_FORMAT.internalError(String.class);
        }
        else
        {
            Response<String> response = employService.addAdminEmploy(addAdminEmployRequest,
                    token.getUserInfo().getEmployPk());
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

    @PostMapping(value = "/addSupervisorEmploy")
    public ResponseEntity<Response<String>> addSupervisorEmploy(
            @Valid @RequestBody AddSupervisorEmployRequest addSupervisorEmployRequest,
            @AuthenticationPrincipal SecurityToken token, Errors errors)
    {

        addSupervisorEmployRequest.setPassword(iMGrabberUtils.decodeBase64(addSupervisorEmployRequest.getPassword()));
        Pattern pattern = Pattern.compile("^(?=.*[A-Z])(?=.*[a-z])(?=.*\\d)([A-Za-z\\d]){8,60}$");
        Matcher matcher = pattern.matcher(addSupervisorEmployRequest.getPassword());
        boolean result = matcher.find();

        if (errors.hasErrors() || result == false)
        {
            return StatusEnum.BAD_FORMAT.internalError(String.class);
        }
        else
        {
            Response<String> response = employService.addSupervisorEmploy(addSupervisorEmployRequest,
                    token.getUserInfo().getEmployPk());
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

    @PostMapping(value = "/addOfficerEmploy")
    public ResponseEntity<Response<String>> addOfficerEmploy(
            @Valid @RequestBody AddOfficerEmployRequest addOfficerEmployRequest,
            @AuthenticationPrincipal SecurityToken token, Errors errors)
    {

 
        
        addOfficerEmployRequest.setPassword(iMGrabberUtils.decodeBase64(addOfficerEmployRequest.getPassword()));
        Pattern pattern = Pattern.compile("^(?=.*[A-Z])(?=.*[a-z])(?=.*\\d)([A-Za-z\\d]){8,60}$");
        Matcher matcher = pattern.matcher(addOfficerEmployRequest.getPassword());
        boolean result = matcher.find();

        if (errors.hasErrors() || result == false)
        {
            return StatusEnum.BAD_FORMAT.internalError(String.class);
        }
        else
        {
            Response<String> response = employService.addOfficerEmploy(addOfficerEmployRequest,
                    token.getUserInfo().getEmployPk());
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

    @PostMapping(value = "/updateAdminGlobalPassword")
    public ResponseEntity<Response<String>> updateAdminGlobalPassword(
            @Valid @RequestBody UpdateAdminGlobalPasswordRequest updateAdminGlobalPasswordRequest,
            @AuthenticationPrincipal SecurityToken token, Errors errors)
    {
        logger.info(updateAdminGlobalPasswordRequest.toString());
        
        updateAdminGlobalPasswordRequest
                .setPassword(iMGrabberUtils.decodeBase64(updateAdminGlobalPasswordRequest.getPassword()));
        Pattern pattern = Pattern.compile("^(?=.*[A-Z])(?=.*[a-z])(?=.*\\d)([A-Za-z\\d]){8,60}$");
        Matcher matcher = pattern.matcher(updateAdminGlobalPasswordRequest.getPassword());
        boolean result = matcher.find();

        if (errors.hasErrors() || result == false)
        {
            return StatusEnum.BAD_FORMAT.internalError(String.class);
        }
        else
        {
            Response<String> response = employService.updateAdminGlobalPassword(updateAdminGlobalPasswordRequest,
                    token);
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

    @PostMapping(value = "/updateAdminBusinessEmploy")
    public ResponseEntity<Response<String>> updateAdminBusinessEmploy(
            @Valid @RequestBody UpdateAdminEmployRequest updateAdminEmployRequest,
            @AuthenticationPrincipal SecurityToken token, Errors errors)
    {

        updateAdminEmployRequest.setPassword(iMGrabberUtils.decodeBase64(updateAdminEmployRequest.getPassword()));
        Pattern pattern = Pattern.compile("^(?=.*[A-Z])(?=.*[a-z])(?=.*\\d)([A-Za-z\\d]){8,60}$");
        Matcher matcher = pattern.matcher(updateAdminEmployRequest.getPassword());
        boolean result = matcher.find();

        if (errors.hasErrors() || result == false)
        {
            return StatusEnum.BAD_FORMAT.internalError(String.class);
            
        }
        else
        {
            Response<String> response = employService.updateAdminBusinessEmploy(updateAdminEmployRequest, token);
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

    @PostMapping(value = "/updateSupervisorEmploy")
    public ResponseEntity<Response<String>> updateSupervisorEmploy(
            @Valid @RequestBody UpdateSupervisorEmployRequest updateSupervisorEmployRequest,
            @AuthenticationPrincipal SecurityToken token, Errors errors)
    {

        updateSupervisorEmployRequest
                .setPassword(iMGrabberUtils.decodeBase64(updateSupervisorEmployRequest.getPassword()));
        
        Pattern pattern = Pattern.compile("");
        Matcher matcher = pattern.matcher(updateSupervisorEmployRequest.getPassword());
        boolean result = matcher.find();

        if (errors.hasErrors() || result == false)
        {
            return StatusEnum.BAD_FORMAT.internalError(String.class);
        }
        else
        {
            Response<String> response = employService.updateSupervisorEmploy(updateSupervisorEmployRequest,
                    token.getUserInfo().getEmployPk());
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

    @PostMapping(value = "/updateOfficerEmploy")
    public ResponseEntity<Response<String>> updateOfficerEmploy(
            @Valid @RequestBody UpdateOfficerEmployRequest updateOfficerEmployRequest,
            @AuthenticationPrincipal SecurityToken token, Errors errors)
    {

        updateOfficerEmployRequest.setPassword(iMGrabberUtils.decodeBase64(updateOfficerEmployRequest.getPassword()));
        Pattern pattern = Pattern.compile("");
        Matcher matcher = pattern.matcher(updateOfficerEmployRequest.getPassword());
        boolean result = matcher.find();

        if (errors.hasErrors() || result == false)
        {
            return StatusEnum.BAD_FORMAT.internalError(String.class);
        }
        else
        {
            Response<String> response = employService.updateOfficerEmploy(updateOfficerEmployRequest,
                    token.getUserInfo().getEmployPk());
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

    @PostMapping(value = "/defuseOfficerEmploy")
    public ResponseEntity<Response<String>> defuseOfficerEmploy(
            @Valid @RequestBody DefuseEmployRequest defuseEmployRequest, @AuthenticationPrincipal SecurityToken token,
            Errors errors)
    {

        if (errors.hasErrors())
        {
            return StatusEnum.BAD_FORMAT.internalError(String.class);
        }
        else
        {
            Response<String> response = employService.defuseOfficerEmploy(defuseEmployRequest,
                    token.getUserInfo().getEmployPk());
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

    @PostMapping(value = "/loadAllSupervisorForDefuse")
    @SuppressWarnings("unchecked")
    public ResponseEntity<Response<List<LoadAllEmployByRoleDTO>>> loadAllSupervisorForDefuse(
            @Valid @RequestBody LoadEmployRequest loadEmployRequest, @AuthenticationPrincipal SecurityToken token,
            Errors error)
    {

        if (error.hasErrors())
        {
            return StatusEnum.BAD_FORMAT.internalError(((Class<List<LoadAllEmployByRoleDTO>>) (Object) List.class));
        }
        else
        {
            Response<List<LoadAllEmployByRoleDTO>> response = employService
                    .loadAllSupervisorForDefuse(loadEmployRequest, token.getUserInfo().getEmployPk());
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

    @PostMapping(value = "/defuseSupervisorEmploy")
    public ResponseEntity<Response<String>> defuseSupervisorEmploy(
            @Valid @RequestBody DefuseSupervisorRequest defuseSupervisorRequest,
            @AuthenticationPrincipal SecurityToken token, Errors errors)
    {

        if (errors.hasErrors())
        {
            return StatusEnum.BAD_FORMAT.internalError(String.class);
        }
        else
        {
            Response<String> response = employService.defuseSupervisorEmploy(defuseSupervisorRequest,
                    token.getUserInfo().getEmployPk());
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

    @PostMapping(value = "/defuseAdminBusinessEmploy")
    public ResponseEntity<Response<String>> defuseAdminBusinessEmploy(
            @Valid @RequestBody DefuseEmployRequest defuseEmployRequest, @AuthenticationPrincipal SecurityToken token,
            Errors errors)
    {

        if (errors.hasErrors())
        {
            return StatusEnum.BAD_FORMAT.internalError(String.class);
        }
        else
        {
            Response<String> response = employService.defuseAdminBusinessEmploy(defuseEmployRequest,
                    token.getUserInfo().getEmployPk());
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