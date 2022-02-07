
package pe.com.synopsis.imgrabber.rest;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import pe.com.synopsis.imgrabber.beans.request.LoginRequest;
import pe.com.synopsis.imgrabber.beans.response.ResultResponse;
import pe.com.synopsis.imgrabber.beans.response.LoginResponse;
import pe.com.synopsis.imgrabber.beans.response.Response;
import pe.com.synopsis.imgrabber.beans.response.Status;
import pe.com.synopsis.imgrabber.dao.ValidTokenAndStatusDAO;
import pe.com.synopsis.imgrabber.enumeration.StatusEnum;
import pe.com.synopsis.imgrabber.security.SecurityToken;
import pe.com.synopsis.imgrabber.service.LoginService;
import pe.com.synopsis.imgrabber.support.IMGrabberUtils;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/auth/v1")
@Api(value = "Login Web Imgrabber")
public class LoginController
{

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    private LoginService loginService;

    @Autowired
    private ValidTokenAndStatusDAO validTokenAndStatusDAO;

    @Autowired
    private IMGrabberUtils utils;

    @ApiOperation(value = "Permite al usuario logearse")
    @ApiResponses(value = { @ApiResponse(code = 0000, message = "El servicio se ha ejecutado de forma correcta.") })
    @PostMapping(value = "/login")
    public ResponseEntity<Response<LoginResponse>> login(@Valid @RequestBody LoginRequest login, Errors errors)
    {

        login.setPassword(utils.decodeBase64(login.getPassword()));

        if (errors.hasErrors())
        {
            return StatusEnum.BAD_FORMAT.internalError(LoginResponse.class);

        }
        else
        {
            Response<LoginResponse> response = loginService.login(login);

            if (StatusEnum.STATUS_SUCCESSFULL.isCode(response.getStatus()))
            {
                SecurityToken authentication = (SecurityToken) SecurityContextHolder.getContext().getAuthentication();
                validTokenAndStatusDAO.addToken(authentication.getUserInfo(),
                        utils.clearTokenJWT(response.getData().getSessionId()));

                return new ResponseEntity<Response<LoginResponse>>(response, HttpStatus.OK);
            }
            else
            {
                return new ResponseEntity<Response<LoginResponse>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }
    }

    @ApiOperation(value = "Permite al usuario cerrar sesi&oacute;n")
    @ApiResponses(value = { @ApiResponse(code = 0000, message = "El servicio se ha ejecutado de forma correcta.") })
    @PostMapping(value = "/logout")
    public ResponseEntity<Status> logout(@AuthenticationPrincipal SecurityToken token, HttpServletRequest request)
    {
        return new ResponseEntity<Status>(loginService.logout(token).getData(), HttpStatus.OK);
    }

    @ApiOperation(value = "Envia un correo con un token al email del usuario para luego reestablecer su password")
    @PostMapping(value = "/changePassword")
    public ResponseEntity<ResultResponse> sendEmailForChangingPassword(@RequestParam(value = "email") String email)
    {
        return new ResponseEntity<ResultResponse>(loginService.sendEmailForPasswordChange(email), HttpStatus.OK);
    }
    
    @ApiOperation(value = "Permite al usuario cambiar su password")
    @PostMapping(value = "/resetPassword")
    public ResponseEntity<ResultResponse> resetMyPassword()
    {
        return null;
    }
}