
package pe.com.synopsis.imgrabber.converter;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import pe.com.synopsis.imgrabber.beans.domain.GetLastUpdate;
import pe.com.synopsis.imgrabber.beans.dto.GetLastUpdateDTO;

@Component
public class GetLastUpdateConverter implements Converter<List<GetLastUpdate>, List<GetLastUpdateDTO>>
{

    @Override
    public List<GetLastUpdateDTO> convert(List<GetLastUpdate> source)
    {
        return source.stream().map(GetLastUpdateDTO::new).collect(Collectors.toList());
    }

}
