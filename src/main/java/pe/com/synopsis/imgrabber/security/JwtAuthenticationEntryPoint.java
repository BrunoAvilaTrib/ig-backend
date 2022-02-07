
package pe.com.synopsis.imgrabber.security;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import com.google.gson.Gson;

import pe.com.synopsis.imgrabber.beans.domain.ValidateEmploy;
import pe.com.synopsis.imgrabber.beans.response.Response;
import pe.com.synopsis.imgrabber.enumeration.StatusEnum;
import pe.com.synopsis.imgrabber.exception.LoginAttemptException;

@Component
public class JwtAuthenticationEntryPoint implements AuthenticationEntryPoint
{

    private static final Logger logger = LoggerFactory.getLogger(JwtAuthenticationEntryPoint.class);

    // este metodo solo ejecuta accioness
    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException e)
            throws IOException, ServletException
    {
        logger.error("Responding with unauthorized error. Message - {}", e.getMessage());
        response.setStatus(HttpServletResponse.SC_FORBIDDEN);
        try (PrintWriter pw = response.getWriter())
        {

            Response<ValidateEmploy> webResponse = new Response<ValidateEmploy>();

            if (e instanceof LoginAttemptException)
            {
                LoginAttemptException attemptException = (LoginAttemptException) e;
                webResponse.setData(attemptException.getValidateUser());
                webResponse.setStatus(attemptException.getStatus());
            }
            else
            {
                webResponse.setStatus(StatusEnum.NOT_AUTHENTICATED.create());
            }

            String message = new Gson().toJson(webResponse);

            response.setContentType("application/json;charset=UTF-8");
            pw.write(message);
        }
    }
}
