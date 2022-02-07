
package pe.com.synopsis.imgrabber.business;

import java.util.List;

import pe.com.synopsis.imgrabber.beans.dto.HeaderDTO;

public interface HeaderBL
{
    public List<HeaderDTO> loadHeader(String login);
}
