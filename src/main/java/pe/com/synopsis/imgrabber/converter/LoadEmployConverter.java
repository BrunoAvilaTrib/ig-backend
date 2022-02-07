
package pe.com.synopsis.imgrabber.converter;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import pe.com.synopsis.imgrabber.beans.domain.LoadEmploy;
import pe.com.synopsis.imgrabber.beans.dto.LoadEmployDTO;

@Component
public class LoadEmployConverter implements Converter<List<LoadEmploy>, List<LoadEmployDTO>>
{

    @Override
    public List<LoadEmployDTO> convert(List<LoadEmploy> source)
    {
        return source.stream().map(LoadEmployDTO::new).collect(Collectors.toList());
    }

}
