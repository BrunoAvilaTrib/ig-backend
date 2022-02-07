
package pe.com.synopsis.imgrabber.converter;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import pe.com.synopsis.imgrabber.beans.domain.LoadEmployConfig;
import pe.com.synopsis.imgrabber.beans.dto.LoadEmployConfigDTO;

@Component
public class LoadEmployConfigConverter implements Converter<List<LoadEmployConfig>, List<LoadEmployConfigDTO>>
{

    @Override
    public List<LoadEmployConfigDTO> convert(List<LoadEmployConfig> source)
    {

        return source.stream().map(LoadEmployConfigDTO::new).collect(Collectors.toList());
    }

}
