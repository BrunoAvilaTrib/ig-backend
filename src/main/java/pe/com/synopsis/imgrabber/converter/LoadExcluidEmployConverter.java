
package pe.com.synopsis.imgrabber.converter;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import pe.com.synopsis.imgrabber.beans.domain.LoadExcluidEmploy;
import pe.com.synopsis.imgrabber.beans.dto.LoadExcluidEmployDTO;

@Component
public class LoadExcluidEmployConverter implements Converter<List<LoadExcluidEmploy>, List<LoadExcluidEmployDTO>>
{

    @Override
    public List<LoadExcluidEmployDTO> convert(List<LoadExcluidEmploy> source)
    {
        return source.stream().map(LoadExcluidEmployDTO::new).collect(Collectors.toList());
    }

}
