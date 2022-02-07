
package pe.com.synopsis.imgrabber.security;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class SecurityInfo implements UserDetails
{
    // como le agreagas autorities? si no tiene ni setters ni constructor
    private static final long serialVersionUID = -4943465268794839517L;

    private final UserInfo userInfo;

    public SecurityInfo(UserInfo userInfo)
    {
        this.userInfo = userInfo;

    }

    // get de autorities
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities()
    {
        return this.userInfo.getRole();
    }

    @Override
    public String getPassword()
    {
        throw new UnsupportedOperationException();
    }

    @Override
    public String getUsername()
    {
        return this.getUserInfo().getEmail();
    }

    @Override
    public boolean isAccountNonExpired()
    {
        return true;
    }

    @Override
    public boolean isAccountNonLocked()
    {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired()
    {
        return true;
    }

    @Override
    public boolean isEnabled()
    {
        return true;
    }

    public UserInfo getUserInfo()
    {
        return userInfo;
    }

}
