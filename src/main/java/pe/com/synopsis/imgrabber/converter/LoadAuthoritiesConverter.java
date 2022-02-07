
package pe.com.synopsis.imgrabber.converter;

import java.util.ArrayList;
import java.util.List;

import org.springframework.core.convert.converter.Converter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;

import pe.com.synopsis.imgrabber.beans.dto.RoleDTO;

@Component
public class LoadAuthoritiesConverter implements Converter<List<RoleDTO>, List<GrantedAuthority>>
{

    @Override
    public List<GrantedAuthority> convert(List<RoleDTO> roles)
    {

        List<GrantedAuthority> auths = new ArrayList<GrantedAuthority>();
        for (RoleDTO role : roles)
        {
            auths.add(new SimpleGrantedAuthority(role.getAuthority()));

        }
        return auths;
    }

}
