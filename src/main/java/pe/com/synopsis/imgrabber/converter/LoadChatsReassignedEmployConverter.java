
package pe.com.synopsis.imgrabber.converter;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import pe.com.synopsis.imgrabber.beans.domain.LoadChatsReassignedEmploy;
import pe.com.synopsis.imgrabber.beans.dto.LoadChatsReassignedEmployDTO;

@Component
public class LoadChatsReassignedEmployConverter
        implements Converter<List<LoadChatsReassignedEmploy>, List<LoadChatsReassignedEmployDTO>>
{

    @Override
    public List<LoadChatsReassignedEmployDTO> convert(List<LoadChatsReassignedEmploy> source)
    {
        return source.stream().map(LoadChatsReassignedEmployDTO::new).collect(Collectors.toList());
    }

}
