
package pe.com.synopsis.imgrabber.converter;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import pe.com.synopsis.imgrabber.beans.domain.LoadBySupervisorPrivilege;
import pe.com.synopsis.imgrabber.beans.dto.LoadBySupervisorPrivilegeDTO;

@Component
public class LoadBySupervisorPrivilegeConverter
        implements Converter<List<LoadBySupervisorPrivilege>, List<LoadBySupervisorPrivilegeDTO>>
{

    @Override
    public List<LoadBySupervisorPrivilegeDTO> convert(List<LoadBySupervisorPrivilege> source)
    {

        return source.stream().map(LoadBySupervisorPrivilegeDTO::new).collect(Collectors.toList());
    }

}
