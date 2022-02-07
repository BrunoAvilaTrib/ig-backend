
package pe.com.synopsis.imgrabber.converter;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import pe.com.synopsis.imgrabber.beans.domain.LoadArea;
import pe.com.synopsis.imgrabber.beans.dto.LoadAreaDTO;

@Component
public class LoadAreaConverter implements Converter<List<LoadArea>, List<LoadAreaDTO>>
{

    @Override
    public List<LoadAreaDTO> convert(List<LoadArea> source)
    {
        return source.stream().map(LoadAreaDTO::new).collect(Collectors.toList());
    }

}
