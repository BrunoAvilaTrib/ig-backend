
package pe.com.synopsis.imgrabber.converter;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import pe.com.synopsis.imgrabber.beans.domain.LoadBusiness;
import pe.com.synopsis.imgrabber.beans.dto.LoadBusinessDTO;

@Component
public class LoadBusinessConverter implements Converter<List<LoadBusiness>, List<LoadBusinessDTO>>
{

    @Override
    public List<LoadBusinessDTO> convert(List<LoadBusiness> source)
    {
        return source.stream().map(LoadBusinessDTO::new).collect(Collectors.toList());
    }

}
