
package pe.com.synopsis.imgrabber.security;

import java.io.Serializable;
import java.util.Collection;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;

public class SecurityToken extends UsernamePasswordAuthenticationToken implements Serializable
{

    private static final long serialVersionUID = -4943465268794839517L;

    private final UserInfo userInfo;

    public SecurityToken(Object principal, Object credentials, Collection<? extends GrantedAuthority> authorities,
            UserInfo userInfo)
    {
        super(principal, credentials, authorities);
        this.userInfo = userInfo;
    }

    public UserInfo getUserInfo()
    {
        return userInfo;
    }

}