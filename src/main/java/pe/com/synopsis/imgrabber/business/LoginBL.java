
package pe.com.synopsis.imgrabber.business;

import pe.com.synopsis.imgrabber.beans.request.LoginRequest;
import pe.com.synopsis.imgrabber.beans.response.LoginResponse;
import pe.com.synopsis.imgrabber.beans.response.Response;
import pe.com.synopsis.imgrabber.security.SecurityToken;

public interface LoginBL
{
    public Response<LoginResponse> validateEmploy(LoginRequest validateEmploy) throws Exception;

    public void logout(SecurityToken token);

    public void changeMyPassword(String requiredEmail);

}
