
package pe.com.synopsis.imgrabber.exception;

import pe.com.synopsis.imgrabber.beans.domain.ValidateEmploy;
import pe.com.synopsis.imgrabber.enumeration.SPCodeEnum;

public class LoginLockoutException extends LoginAttemptException
{

    private static final long serialVersionUID = 829968504269800186L;

    public LoginLockoutException(SPCodeEnum msg, Throwable t, ValidateEmploy validateUser)
    {
        super(msg, t, validateUser);
    }

    public LoginLockoutException(SPCodeEnum msg, ValidateEmploy validateUser)
    {
        super(msg, validateUser);
    }

}
