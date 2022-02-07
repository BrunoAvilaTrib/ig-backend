
package pe.com.synopsis.imgrabber.converter;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import pe.com.synopsis.imgrabber.beans.domain.LoadAllExcluid;
import pe.com.synopsis.imgrabber.beans.dto.LoadAllExcluidDTO;

@Component
public class LoadAllExcluidConverter implements Converter<List<LoadAllExcluid>, List<LoadAllExcluidDTO>>
{

    @Override
    public List<LoadAllExcluidDTO> convert(List<LoadAllExcluid> source)
    {

        return source.stream().map(LoadAllExcluidDTO::new).collect(Collectors.toList());
    }

}
