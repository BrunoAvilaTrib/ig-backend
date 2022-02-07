
package pe.com.synopsis.imgrabber.converter;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import pe.com.synopsis.imgrabber.beans.domain.LoadAllAreaByRole;
import pe.com.synopsis.imgrabber.beans.dto.LoadAllAreaByRoleDTO;

@Component
public class LoadAllAreaByRoleConverter implements Converter<List<LoadAllAreaByRole>, List<LoadAllAreaByRoleDTO>>
{

    @Override
    public List<LoadAllAreaByRoleDTO> convert(List<LoadAllAreaByRole> source)
    {
        return source.stream().map(LoadAllAreaByRoleDTO::new).collect(Collectors.toList());
    }
}
