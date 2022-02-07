
package pe.com.synopsis.imgrabber.security;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.web.filter.OncePerRequestFilter;

import pe.com.synopsis.imgrabber.dao.impl.ValidTokenAndStatusDAOImpl;
import pe.com.synopsis.imgrabber.enumeration.PropsEnum;
import pe.com.synopsis.imgrabber.enumeration.StatusEnum;
import pe.com.synopsis.imgrabber.support.IMGrabberUtils;

public class JwtAuthenticationFilter extends OncePerRequestFilter
{

    private static final Logger logger = LoggerFactory.getLogger(JwtAuthenticationFilter.class);

    @Autowired
    private JwtTokenProvider tokenProvider;

    @Autowired
    private ValidTokenAndStatusDAOImpl validTokenDao;

    @Autowired
    private Environment env;

    @Autowired
    private IMGrabberUtils utils;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException
    {
        try
        {
            String jwt = getJwtFromRequest(request);

            // valida si el token no esta vacio y si si cumple pla validacion de jwt
            if (StringUtils.isNotEmpty(jwt) && tokenProvider.validateToken(jwt))
            {

                UserInfo userInfo = tokenProvider.getUserFromJWT(jwt);

                UserDetails userDetails = new SecurityInfo(userInfo);

                String status = validTokenDao.devolverStatus(userInfo, jwt);

                if (StatusEnum.STATUS_SUCCESSFULL.isCode(status))
                { // espera un objeto que extienda de granted autoritires
                    UsernamePasswordAuthenticationToken authentication = new SecurityToken(userDetails, null,
                            userDetails.getAuthorities(), userInfo);
                    authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));

                    SecurityContextHolder.getContext().setAuthentication(authentication);
                }
            }
        }
        catch (Exception ex)
        {
            logger.error("Could not set user authentication in security context", ex);
        }

        filterChain.doFilter(request, response);
    }

    private String getJwtFromRequest(HttpServletRequest request)
    {
        String bearerToken = "";
        if (HttpMethod.GET.matches(request.getMethod()))
        {
            bearerToken = request.getParameter(PropsEnum.JWT_HEADER.getString(env));

        }
        else
        {
            bearerToken = request.getHeader(PropsEnum.JWT_HEADER.getString(env));
        }
        return utils.clearTokenJWT(bearerToken);
    }
}
