
package pe.com.synopsis.imgrabber.security;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Component;

import pe.com.synopsis.imgrabber.beans.domain.ValidateEmploy;
import pe.com.synopsis.imgrabber.beans.request.LoginRequest;
import pe.com.synopsis.imgrabber.converter.LoadAuthoritiesConverter;
import pe.com.synopsis.imgrabber.converter.LoadRolesConverter;
import pe.com.synopsis.imgrabber.dao.LoginDAO;

@Component
public class JwtAuthenticationProvider implements AuthenticationProvider
{

    private static final Logger logger = LoggerFactory.getLogger(JwtAuthenticationProvider.class);
    @Autowired
    private LoginDAO loginDAO;
    @Autowired
    private LoadAuthoritiesConverter loadRolsConverter;
    @Autowired
    private LoadRolesConverter loadRolesConverter;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException
    {

        SecurityRequest request = (SecurityRequest) authentication;
        LoginRequest login = request.getRequest();
        String username = login.getEmail();
        ValidateEmploy validateEmploy = loginDAO.login(login.getEmail(), login.getPassword());
        UserInfo userInfo = new UserInfo(validateEmploy.getEmail(), validateEmploy.getEmployPk(),
                validateEmploy.getIsGlobalAdmin(), validateEmploy.getSex(), validateEmploy.getNameEmploy(),
                loadRolesConverter.convert(validateEmploy.getCredentialsNonExpired()));
        List<GrantedAuthority> listaautorities;

        try
        {
            listaautorities = loadRolsConverter.convert(userInfo.getRole());
        }
        catch (Exception e)
        {
            logger.error(e.getMessage(), e);
            listaautorities = null;
        }
        return new SecurityToken(username, null, listaautorities, userInfo);
    }

    @Override
    public boolean supports(Class<?> authentication)
    {
        return (UsernamePasswordAuthenticationToken.class.isAssignableFrom(authentication));
    }

}
