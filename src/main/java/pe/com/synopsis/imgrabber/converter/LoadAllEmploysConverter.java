
package pe.com.synopsis.imgrabber.converter;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import pe.com.synopsis.imgrabber.beans.domain.LoadAllEmploy;
import pe.com.synopsis.imgrabber.beans.dto.LoadAllEmployDTO;

@Component
public class LoadAllEmploysConverter implements Converter<List<LoadAllEmploy>, List<LoadAllEmployDTO>>
{

    @Override
    public List<LoadAllEmployDTO> convert(List<LoadAllEmploy> source)
    {
        return source.stream().map(LoadAllEmployDTO::new).collect(Collectors.toList());
    }

}
