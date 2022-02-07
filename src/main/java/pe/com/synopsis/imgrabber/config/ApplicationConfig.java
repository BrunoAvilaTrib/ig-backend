
package pe.com.synopsis.imgrabber.config;

import java.util.Locale;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;

import pe.com.synopsis.imgrabber.support.MessageInventory;

@Configuration
@PropertySource(value = { "file://${ig.folder}/config/ig-base.properties",
        "file://${ig.folder}/config/ig-web-service.properties" })
public class ApplicationConfig
{

    @Bean(name = "messageSource")
    public MessageSource getMessageSource()
    {
        ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
        messageSource.setBasename("classpath:messages");
        messageSource.setDefaultEncoding("UTF-8");
        messageSource.setCacheSeconds(10);
        messageSource.setUseCodeAsDefaultMessage(true);
        return messageSource;
    }

    @Bean(name = "messageInventory")
    public MessageInventory getMessageInventory()
    {
        return new MessageInventory(getMessageSource(), new Locale("es", "PE"));
    }

}
