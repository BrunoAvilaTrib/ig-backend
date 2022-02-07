
package pe.com.synopsis.imgrabber.support;

import java.util.Base64;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import pe.com.synopsis.imgrabber.enumeration.PropsEnum;

@Component
public class IMGrabberUtils
{

    @SuppressWarnings("unused")
    private static final Logger logger = LoggerFactory.getLogger(IMGrabberUtils.class);

    @Autowired
    private Environment env;

    public String decodeBase64(String contrasena)
    {
        byte[] decodedBytes = Base64.getDecoder().decode(contrasena);
        String decodedString = new String(decodedBytes);
        return decodedString;
    }

    public String clearTokenJWT(String bearerToken)
    {

        String prefix = PropsEnum.JWT_PREFIX.getString(env);
        // si
        if (StringUtils.isNotEmpty(bearerToken) && bearerToken.startsWith(prefix))
        {
            return bearerToken.substring(prefix.length() + 1, bearerToken.length());
        }

        return null;
    }

}
