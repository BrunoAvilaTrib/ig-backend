
package pe.com.synopsis.imgrabber.service;

import pe.com.synopsis.imgrabber.beans.request.LoginRequest;
import pe.com.synopsis.imgrabber.beans.response.ResultResponse;
import pe.com.synopsis.imgrabber.beans.response.LoginResponse;
import pe.com.synopsis.imgrabber.beans.response.Response;
import pe.com.synopsis.imgrabber.beans.response.Status;
import pe.com.synopsis.imgrabber.security.SecurityToken;

public interface LoginService
{

    public Response<LoginResponse> login(LoginRequest login);

    public Response<Status> logout(SecurityToken token);

    public ResultResponse sendEmailForPasswordChange(String requiredEmail);
}
