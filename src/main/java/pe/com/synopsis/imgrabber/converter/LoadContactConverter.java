
package pe.com.synopsis.imgrabber.converter;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import pe.com.synopsis.imgrabber.beans.domain.Contact;
import pe.com.synopsis.imgrabber.beans.dto.ContactDTO;

@Component
public class LoadContactConverter implements Converter<List<Contact>, List<ContactDTO>>
{

    @Override
    public List<ContactDTO> convert(List<Contact> source)
    {
        return source.stream().map(ContactDTO::new).collect(Collectors.toList());
    }

}
