
package pe.com.synopsis.imgrabber.converter;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import pe.com.synopsis.imgrabber.beans.domain.LoadEmployTraze;
import pe.com.synopsis.imgrabber.beans.dto.LoadEmployTrazeDTO;

@Component
public class LoadEmployTraceConverter implements Converter<List<LoadEmployTraze>, List<LoadEmployTrazeDTO>>
{

    @Override
    public List<LoadEmployTrazeDTO> convert(List<LoadEmployTraze> source)
    {
        return source.stream().map(LoadEmployTrazeDTO::new).collect(Collectors.toList());

    }

}
