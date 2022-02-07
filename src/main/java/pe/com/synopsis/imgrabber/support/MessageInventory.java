
package pe.com.synopsis.imgrabber.support;

import java.util.Locale;

import org.springframework.context.MessageSource;

public class MessageInventory
{

    private MessageSource messageSource;
    private Locale locale;

    public MessageInventory(MessageSource messageSource, Locale locale)
    {
        this.messageSource = messageSource;
        this.locale = locale;
    }

    public String getMessage(String code)
    {
        return messageSource.getMessage(code, null, locale);
    }

    public String getMessage(String code, String... params)
    {
        return messageSource.getMessage(code, params, locale);
    }
}
