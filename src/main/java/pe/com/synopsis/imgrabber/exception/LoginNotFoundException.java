
package pe.com.synopsis.imgrabber.exception;

import pe.com.synopsis.imgrabber.beans.domain.ValidateEmploy;
import pe.com.synopsis.imgrabber.enumeration.SPCodeEnum;

public class LoginNotFoundException extends LoginAttemptException
{

    private static final long serialVersionUID = 829968504269800186L;

    public LoginNotFoundException(SPCodeEnum msg, Throwable t, ValidateEmploy validateUser)
    {
        super(msg, t, validateUser);
    }

    public LoginNotFoundException(SPCodeEnum msg, ValidateEmploy validateUser)
    {
        super(msg, validateUser);
    }

}
