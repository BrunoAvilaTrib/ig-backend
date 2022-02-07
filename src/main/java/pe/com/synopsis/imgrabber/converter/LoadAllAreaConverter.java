
package pe.com.synopsis.imgrabber.converter;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import pe.com.synopsis.imgrabber.beans.domain.LoadAllArea;
import pe.com.synopsis.imgrabber.beans.dto.LoadAllAreaDTO;

@Component
public class LoadAllAreaConverter implements Converter<List<LoadAllArea>, List<LoadAllAreaDTO>>
{

    @Override
    public List<LoadAllAreaDTO> convert(List<LoadAllArea> source)
    {
        return source.stream().map(LoadAllAreaDTO::new).collect(Collectors.toList());
    }

}
