
package pe.com.synopsis.imgrabber.converter;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import pe.com.synopsis.imgrabber.beans.domain.LoadRole;
import pe.com.synopsis.imgrabber.beans.dto.RoleDTO;

@Component
public class LoadRolesConverter implements Converter<List<LoadRole>, List<RoleDTO>>
{

    @Override
    public List<RoleDTO> convert(List<LoadRole> source)
    {
        return source.stream().map(RoleDTO::new).collect(Collectors.toList());
    }

}
