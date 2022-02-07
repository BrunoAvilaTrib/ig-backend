
package pe.com.synopsis.imgrabber.service.impl;

import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.net.URL;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import pe.com.synopsis.imgrabber.beans.request.ResourceRequest;
import pe.com.synopsis.imgrabber.beans.request.UploadPhotoRequest;
import pe.com.synopsis.imgrabber.beans.response.Response;
import pe.com.synopsis.imgrabber.beans.response.Status;
import pe.com.synopsis.imgrabber.business.ResourceBL;
import pe.com.synopsis.imgrabber.converter.LoadMessageConverter;
import pe.com.synopsis.imgrabber.enumeration.StatusEnum;
import pe.com.synopsis.imgrabber.exception.RulesException;
import pe.com.synopsis.imgrabber.service.ResourceService;

@Service
public class ResourceServiceImpl implements ResourceService
{

    private static final Logger logger = LoggerFactory.getLogger(ResourceServiceImpl.class);

    @Autowired
    LoadMessageConverter converter;

    @Autowired
    private ResourceBL resourceBl;

    @Autowired
    private Environment env;

    @Override
    public Response<String> uploadPhoto(@Valid UploadPhotoRequest uploadPhotoRequest)
    {

        Response<String> response = new Response<>();

        try
        {
            resourceBl.uploadPhoto(uploadPhotoRequest);
            response.setStatus(StatusEnum.STATUS_SUCCESSFULL.create());

        }
        catch (RulesException e)
        {
            logger.error(e.getMessage(), e);
            response.setStatus(new Status(e.getErrorcode(), e.getMessage()));

        }
        catch (Exception e)
        {
            logger.error(e.getMessage(), e);
            response.setStatus(StatusEnum.STATUS_FAIL.create());
        }
        return response;
    }

    @Override
    public Response<byte[]> loadVideo(ResourceRequest request)
    {

        Response<byte[]> response = new Response<byte[]>();

        try
        {
            response.setData(resourceBl.loadVideo(request));
            response.setStatus(StatusEnum.STATUS_SUCCESSFULL.create());

        }
        catch (RulesException e)
        {
            logger.error(e.getMessage(), e);
            response.setStatus(new Status(e.getErrorcode(), e.getMessage()));

        }
        catch (Exception e)
        {
            logger.error(e.getMessage(), e);
            response.setStatus(StatusEnum.STATUS_FAIL.create());
        }
        return response;
    }

    @Override
    public Response<byte[]> loadResource(ResourceRequest request)
    {

        Response<byte[]> response = new Response<byte[]>();
        try
        {
            response.setData(resourceBl.loadResource(request));
            response.setStatus(StatusEnum.STATUS_SUCCESSFULL.create());

        }
        catch (RulesException e)
        {
            logger.error(e.getMessage(), e);
            response.setStatus(new Status(e.getErrorcode(), e.getMessage()));

        }
        catch (Exception e)
        {
            logger.error(e.getMessage(), e);
            response.setStatus(StatusEnum.STATUS_FAIL.create());
        }
        return response;
    }

    @Override
    public Response<byte[]> loadDownload(ResourceRequest request)
    {

        Response<byte[]> response = new Response<byte[]>();
        try
        {
            response.setData(resourceBl.loadDownload(request));
            response.setStatus(StatusEnum.STATUS_SUCCESSFULL.create());

        }
        catch (RulesException e)
        {
            logger.error(e.getMessage(), e);
            response.setStatus(new Status(e.getErrorcode(), e.getMessage()));

        }
        catch (Exception e)
        {
            logger.error(e.getMessage(), e);
            response.setStatus(StatusEnum.STATUS_FAIL.create());
        }
        return response;
    }

    @Override
    public Response<byte[]> loadCdnWhatsapp(String resource)
    {

        Response<byte[]> response = new Response<byte[]>();
        String whatsAppCdn = env.getProperty("WHATSAPP_CDN").concat("/").concat(resource);

        if (!whatsAppCdn.contains(".png"))
        {
            whatsAppCdn = whatsAppCdn.concat(".png");
        }

        try
        {
            URL url = new URL(whatsAppCdn);

            try (InputStream in = new BufferedInputStream(url.openStream());
                    ByteArrayOutputStream out = new ByteArrayOutputStream();)
            {

                byte[] buf = new byte[1024];
                int n = 0;
                while (-1 != (n = in.read(buf)))
                {
                    out.write(buf, 0, n);
                }
                response.setStatus(StatusEnum.STATUS_SUCCESSFULL.create());
                response.setData(out.toByteArray());
            }

        }
        catch (Exception e)
        {
            logger.error(e.getMessage(), e);
            response.setStatus(StatusEnum.STATUS_FAIL.create());
        }
        return response;
    }

}
