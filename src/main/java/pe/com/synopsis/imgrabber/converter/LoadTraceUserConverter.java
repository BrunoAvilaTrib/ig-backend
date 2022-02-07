
package pe.com.synopsis.imgrabber.converter;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import pe.com.synopsis.imgrabber.beans.domain.LoadEmployTraze;
import pe.com.synopsis.imgrabber.beans.dto.TraceUserDTO;

@Component
public class LoadTraceUserConverter implements Converter<List<LoadEmployTraze>, List<TraceUserDTO>>
{

    @Override
    public List<TraceUserDTO> convert(List<LoadEmployTraze> source)
    {

        return source.stream().map(TraceUserDTO::new).collect(Collectors.toList());

    }

}
