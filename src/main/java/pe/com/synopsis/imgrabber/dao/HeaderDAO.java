
package pe.com.synopsis.imgrabber.dao;

import java.util.List;

import pe.com.synopsis.imgrabber.beans.domain.Header;

public interface HeaderDAO
{
    public List<Header> loadHeader(String login);

}
