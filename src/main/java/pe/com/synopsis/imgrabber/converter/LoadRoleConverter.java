
package pe.com.synopsis.imgrabber.converter;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import pe.com.synopsis.imgrabber.beans.domain.LoadRole;
import pe.com.synopsis.imgrabber.beans.dto.LoadRoleDTO;

@Component
public class LoadRoleConverter implements Converter<List<LoadRole>, List<LoadRoleDTO>>
{

    @Override
    public List<LoadRoleDTO> convert(List<LoadRole> source)
    {

        return source.stream().map(LoadRoleDTO::new).collect(Collectors.toList());
    }

}
