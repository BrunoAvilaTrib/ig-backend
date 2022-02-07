
package pe.com.synopsis.imgrabber.converter;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import pe.com.synopsis.imgrabber.beans.domain.LoadAllBusinessByRole;
import pe.com.synopsis.imgrabber.beans.dto.LoadAllBusinessByRoleDTO;

@Component
public class LoadAllBusinessByRoleConverter
        implements Converter<List<LoadAllBusinessByRole>, List<LoadAllBusinessByRoleDTO>>
{

    @Override
    public List<LoadAllBusinessByRoleDTO> convert(List<LoadAllBusinessByRole> source)
    {
        return source.stream().map(LoadAllBusinessByRoleDTO::new).collect(Collectors.toList());
    }
}
