
package pe.com.synopsis.imgrabber.converter;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import pe.com.synopsis.imgrabber.beans.domain.UploadAssigned;
import pe.com.synopsis.imgrabber.beans.dto.UploadAssignedDTO;

@Component
public class UploadAssignedConverter implements Converter<List<UploadAssigned>, List<UploadAssignedDTO>>
{

    @Override
    public List<UploadAssignedDTO> convert(List<UploadAssigned> source)
    {

        return source.stream().map(UploadAssignedDTO::new).collect(Collectors.toList());
    }
}
