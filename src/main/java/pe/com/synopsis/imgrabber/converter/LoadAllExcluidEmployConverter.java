
package pe.com.synopsis.imgrabber.converter;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import pe.com.synopsis.imgrabber.beans.domain.LoadAllExcluidEmploy;
import pe.com.synopsis.imgrabber.beans.dto.LoadAllExcluidEmployDTO;

@Component
public class LoadAllExcluidEmployConverter
        implements Converter<List<LoadAllExcluidEmploy>, List<LoadAllExcluidEmployDTO>>
{

    @Override
    public List<LoadAllExcluidEmployDTO> convert(List<LoadAllExcluidEmploy> source)
    {
        return source.stream().map(LoadAllExcluidEmployDTO::new).collect(Collectors.toList());
    }
}
