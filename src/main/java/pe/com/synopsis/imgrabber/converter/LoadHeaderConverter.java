
package pe.com.synopsis.imgrabber.converter;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import pe.com.synopsis.imgrabber.beans.domain.Header;
import pe.com.synopsis.imgrabber.beans.dto.HeaderDTO;

@Component
public class LoadHeaderConverter implements Converter<List<Header>, List<HeaderDTO>>
{

    @Override
    public List<HeaderDTO> convert(List<Header> source)
    {
        return source.stream().map(HeaderDTO::new).collect(Collectors.toList());

    }

}
