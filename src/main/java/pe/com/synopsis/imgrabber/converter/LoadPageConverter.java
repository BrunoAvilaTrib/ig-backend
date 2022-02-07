
package pe.com.synopsis.imgrabber.converter;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import pe.com.synopsis.imgrabber.beans.domain.Page;
import pe.com.synopsis.imgrabber.beans.dto.PageDTO;

@Component
public class LoadPageConverter implements Converter<List<Page>, List<PageDTO>>
{

    @Override
    public List<PageDTO> convert(List<Page> source)
    {
        return source.stream().map(PageDTO::new).collect(Collectors.toList());
    }

}
