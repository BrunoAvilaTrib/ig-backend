
package pe.com.synopsis.imgrabber.converter;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import pe.com.synopsis.imgrabber.beans.domain.LoadAllBusiness;
import pe.com.synopsis.imgrabber.beans.dto.LoadAllBusinessDTO;

@Component
public class LoadAllBusinessConverter implements Converter<List<LoadAllBusiness>, List<LoadAllBusinessDTO>>
{

    @Override
    public List<LoadAllBusinessDTO> convert(List<LoadAllBusiness> source)
    {
        return source.stream().map(LoadAllBusinessDTO::new).collect(Collectors.toList());
    }
}
