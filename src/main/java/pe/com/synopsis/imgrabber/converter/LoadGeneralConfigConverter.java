
package pe.com.synopsis.imgrabber.converter;
//modified

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import pe.com.synopsis.imgrabber.beans.domain.LoadGeneralConfig;
import pe.com.synopsis.imgrabber.beans.dto.LoadGeneralConfigDTO;

@Component
public class LoadGeneralConfigConverter implements Converter<List<LoadGeneralConfig>, List<LoadGeneralConfigDTO>>
{

    @Override
    public List<LoadGeneralConfigDTO> convert(List<LoadGeneralConfig> source)
    {

        return source.stream().map(LoadGeneralConfigDTO::new).collect(Collectors.toList());

    }

}
