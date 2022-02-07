
package pe.com.synopsis.imgrabber.converter;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import pe.com.synopsis.imgrabber.beans.domain.Message;
import pe.com.synopsis.imgrabber.beans.dto.MessageDTO;

@Component
public class LoadMessageConverter implements Converter<List<Message>, List<MessageDTO>>
{

    @Override
    public List<MessageDTO> convert(List<Message> source)
    {
        return source.stream().map(MessageDTO::new).collect(Collectors.toList());
    }

}
