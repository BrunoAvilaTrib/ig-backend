
package pe.com.synopsis.imgrabber.converter;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import pe.com.synopsis.imgrabber.beans.domain.LoadAllExcluidCust;
import pe.com.synopsis.imgrabber.beans.dto.LoadAllExcluidCustDTO;

@Component
public class LoadAllExcluidCustConverter implements Converter<List<LoadAllExcluidCust>, List<LoadAllExcluidCustDTO>>
{

    @Override
    public List<LoadAllExcluidCustDTO> convert(List<LoadAllExcluidCust> source)
    {
        return source.stream().map(LoadAllExcluidCustDTO::new).collect(Collectors.toList());
    }
}
