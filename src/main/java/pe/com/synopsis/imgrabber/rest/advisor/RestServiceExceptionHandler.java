
package pe.com.synopsis.imgrabber.rest.advisor;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import pe.com.synopsis.imgrabber.beans.response.Status;

@ControllerAdvice
@RestController
public class RestServiceExceptionHandler extends ResponseEntityExceptionHandler
{

    private static final HttpHeaders headers = new HttpHeaders();

    static
    {
        headers.setContentType(MediaType.APPLICATION_JSON);
    }

    @ResponseStatus(code = HttpStatus.BAD_REQUEST, reason = "No se han ingresado los parametros requeridos de forma correcta.")
    @ExceptionHandler({ IllegalArgumentException.class })
    public ResponseEntity<Object> BadRequestHandler(RuntimeException e, WebRequest request)
    {
        Status status = new Status("9999", "BadRequest");
        return handleExceptionInternal(e, status, headers, HttpStatus.BAD_REQUEST, request);

    }

    @ResponseStatus(code = HttpStatus.INTERNAL_SERVER_ERROR, reason = "Ocurrió un error interno.")
    @ExceptionHandler({ Exception.class })
    public ResponseEntity<Object> IternalServerErrorHandler(RuntimeException e, WebRequest request)
    {
        Status status = new Status("5555", "Internal server error");
        return handleExceptionInternal(e, status, headers, HttpStatus.BAD_REQUEST, request);

    }
}
