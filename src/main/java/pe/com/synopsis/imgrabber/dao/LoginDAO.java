
package pe.com.synopsis.imgrabber.dao;

import pe.com.synopsis.imgrabber.beans.domain.ValidateEmploy;
import pe.com.synopsis.imgrabber.exception.RulesException;

public interface LoginDAO
{

    public ValidateEmploy login(String userName, String password);

    public void validateEmail(String requiredEmail) throws RulesException;

    public String generateToken(String requiredEmail);
}
