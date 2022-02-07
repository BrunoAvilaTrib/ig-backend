
package pe.com.synopsis.imgrabber.converter;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import pe.com.synopsis.imgrabber.beans.domain.LoadAllReassignedChats;
import pe.com.synopsis.imgrabber.beans.dto.LoadAllReassignedChatsDTO;

@Component
public class LoadAllReassignedChatsConverter
        implements Converter<List<LoadAllReassignedChats>, List<LoadAllReassignedChatsDTO>>
{

    @Override
    public List<LoadAllReassignedChatsDTO> convert(List<LoadAllReassignedChats> source)
    {
        return source.stream().map(LoadAllReassignedChatsDTO::new).collect(Collectors.toList());
    }
}
