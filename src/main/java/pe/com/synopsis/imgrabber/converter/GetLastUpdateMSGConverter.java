
package pe.com.synopsis.imgrabber.converter;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import pe.com.synopsis.imgrabber.beans.domain.GetLastUpdateMSG;
import pe.com.synopsis.imgrabber.beans.dto.GetLastUpdateMSGDTO;

@Component
public class GetLastUpdateMSGConverter implements Converter<List<GetLastUpdateMSG>, List<GetLastUpdateMSGDTO>>
{

    @Override
    public List<GetLastUpdateMSGDTO> convert(List<GetLastUpdateMSG> source)
    {
        return source.stream().map(GetLastUpdateMSGDTO::new).collect(Collectors.toList());
    }

}
