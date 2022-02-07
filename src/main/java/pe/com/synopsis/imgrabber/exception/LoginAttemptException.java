
package pe.com.synopsis.imgrabber.exception;

import pe.com.synopsis.imgrabber.beans.domain.ValidateEmploy;
import pe.com.synopsis.imgrabber.beans.response.Status;
import pe.com.synopsis.imgrabber.enumeration.SPCodeEnum;
import pe.com.synopsis.imgrabber.security.JwtAuthenticationException;

public class LoginAttemptException extends JwtAuthenticationException
{

    private static final long serialVersionUID = 6348836920508891072L;

    private final ValidateEmploy validateUser;
    private final Status status;

    public LoginAttemptException(SPCodeEnum status, Throwable t, ValidateEmploy validateUser)
    {
        super(status.getMessage(), t);
        this.validateUser = validateUser;
        this.status = status.create();
    }

    public LoginAttemptException(SPCodeEnum status, ValidateEmploy validateUser)
    {
        super(status.getMessage());
        this.validateUser = validateUser;
        this.status = status.create();
    }

    public ValidateEmploy getValidateUser()
    {
        return validateUser;
    }

    public Status getStatus()
    {
        return status;
    }

}
