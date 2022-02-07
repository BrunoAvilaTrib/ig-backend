
package pe.com.synopsis.imgrabber.converter;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import pe.com.synopsis.imgrabber.beans.domain.LoadAllEmployByRole;
import pe.com.synopsis.imgrabber.beans.dto.LoadAllEmployByRoleDTO;

@Component
public class LoadAllEmployByRoleConverter implements Converter<List<LoadAllEmployByRole>, List<LoadAllEmployByRoleDTO>>
{

    @Override
    public List<LoadAllEmployByRoleDTO> convert(List<LoadAllEmployByRole> source)
    {
        return source.stream().map(LoadAllEmployByRoleDTO::new).collect(Collectors.toList());
    }
}
