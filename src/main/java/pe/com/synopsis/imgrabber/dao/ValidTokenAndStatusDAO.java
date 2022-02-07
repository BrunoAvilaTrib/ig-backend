
package pe.com.synopsis.imgrabber.dao;

import pe.com.synopsis.imgrabber.security.SecurityToken;
import pe.com.synopsis.imgrabber.security.UserInfo;

public interface ValidTokenAndStatusDAO
{

    public String devolverStatus(UserInfo userinfo, String token);

    public void addToken(UserInfo userinfo, String token);

    public void deleteTokenEmploy(SecurityToken token);
}
