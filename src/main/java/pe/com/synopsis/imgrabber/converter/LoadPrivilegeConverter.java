
package pe.com.synopsis.imgrabber.converter;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import pe.com.synopsis.imgrabber.beans.domain.LoadPrivilege;
import pe.com.synopsis.imgrabber.beans.dto.LoadPrivilegeDTO;

@Component
public class LoadPrivilegeConverter implements Converter<List<LoadPrivilege>, List<LoadPrivilegeDTO>>
{

    @Override
    public List<LoadPrivilegeDTO> convert(List<LoadPrivilege> source)
    {

        return source.stream().map(LoadPrivilegeDTO::new).collect(Collectors.toList());
    }

}
