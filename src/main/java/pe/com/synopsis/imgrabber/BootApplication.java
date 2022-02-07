
package pe.com.synopsis.imgrabber;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.servlet.WebMvcAutoConfiguration;
import org.springframework.boot.autoconfigure.web.servlet.error.ErrorMvcAutoConfiguration;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableAutoConfiguration(exclude = { WebMvcAutoConfiguration.class, ErrorMvcAutoConfiguration.class })
@EnableCaching
public class BootApplication
{

    @Autowired
    DataSource dataSource;

    public static void main(String[] args)
    {
        SpringApplication.run(BootApplication.class, args);
    }
}
