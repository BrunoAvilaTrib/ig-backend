
package pe.com.synopsis.imgrabber.enumeration;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import pe.com.synopsis.imgrabber.beans.response.Response;
import pe.com.synopsis.imgrabber.beans.response.Status;

public enum StatusEnum
{
    /**
     * Errores de logica.
     */
    NOT_AUTHENTICATED("7777", "Acceso denegado."), STATUS_SUCCESSFULL("0000",
            "El servicio se ha ejecutado de forma correcta."), BAD_FORMAT("0052",
                    "Valide los par\u00E1metros."), TOKEN_FAIL("6666",
                            "El token no es v\u00E1lido."), STATUS_FAIL("9999", "Ocurri\u00F3 un error en el proceso."),

    /**
     * Errores de store.
     */

    USER_NOT_EXIST("0002", "Usuario no existe."), USER_LOCKOUT("0004",
            "El usuario se encuentra bloqueado."), USER_MAX_ATTEMPT("0003",
                    "Usuario ah supera el limite de intentos."), ERROR_PROCESS("8888",
                            "Error en el proceso."), LOGIN_ATTEMPT("0001", "Intento fallido de login."),;

    private String code;
    private String message;

    private StatusEnum(String code, String message)
    {
        this.code = code;
        this.message = message;
    }

    public Status create()
    {
        return new Status(this.code, this.message);
    }

    public boolean isCode(String code)
    {
        return this.code.equals(code);
    }

    public boolean isCode(Status status)
    {
        return isCode(status.getCode());
    }

    public StatusEnum find(String code)
    {
        for (StatusEnum codeEnum : values())
        {
            if (codeEnum.isCode(code))
            {
                return codeEnum;
            }
        }
        return null;
    }

    public StatusEnum find(Status status)
    {
        return find(status.getCode());
    }

    public <T> ResponseEntity<Response<T>> internalError(Class<T> clazz)
    {
        Response<T> response = new Response<>();
        response.setStatus(this.create());
        return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
