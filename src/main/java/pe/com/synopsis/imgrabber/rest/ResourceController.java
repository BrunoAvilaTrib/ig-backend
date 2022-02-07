
package pe.com.synopsis.imgrabber.rest;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import pe.com.synopsis.imgrabber.beans.request.ResourceRequest;
import pe.com.synopsis.imgrabber.beans.request.UploadPhotoRequest;
import pe.com.synopsis.imgrabber.beans.response.Response;
import pe.com.synopsis.imgrabber.enumeration.StatusEnum;
import pe.com.synopsis.imgrabber.service.ResourceService;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/resource/v1")
@Api(value = "Recursos Web Imgrabber")
public class ResourceController
{

    @Autowired
    private ResourceService resourceService;

    @PostMapping("/uploadPhoto")
    public ResponseEntity<Response<String>> uploadPhoto(@Valid @RequestBody UploadPhotoRequest uploadPhotoRequest,
            Errors error)
    {

        if (error.hasErrors())
        {
            return StatusEnum.BAD_FORMAT.internalError(String.class);

        }
        else
        {
            Response<String> response = resourceService.uploadPhoto(uploadPhotoRequest);

            if (StatusEnum.STATUS_SUCCESSFULL.isCode(response.getStatus()))
            {
                return new ResponseEntity<Response<String>>(response, HttpStatus.OK);
            }
            else
            {
                return new ResponseEntity<Response<String>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }
    }

    @ApiOperation(value = "Permite al usuario consultar datos del chat")
    @GetMapping(value = "/video/{idVideo}")
    public @ResponseBody byte[] loadContact(@PathVariable("idVideo") String idVideo)
    {

        ResourceRequest request = new ResourceRequest();
        request.setIdMessage(idVideo);
        return resourceService.loadVideo(request).getData();
    }

    @ApiOperation(value = "Permite al usuario consultar datos del chat")
    @GetMapping(value = "/load/{idResource}")
    public @ResponseBody byte[] loadResource(@PathVariable("idResource") String idResource)
    {

        ResourceRequest request = new ResourceRequest();
        request.setIdMessage(idResource);
        return resourceService.loadResource(request).getData();
    }

    @ApiOperation(value = "Permite al usuario consultar datos del chat")
    @GetMapping(value = "/download/{idResource}/{fileName}/", produces = MediaType.APPLICATION_OCTET_STREAM_VALUE)
    public @ResponseBody byte[] loadDownload(@PathVariable("idResource") String idResource,
            @PathVariable String fileName, HttpServletResponse response)
    {

        ResourceRequest request = new ResourceRequest();
        request.setIdMessage(idResource);
        response.setHeader("Content-Disposition", "attachment; filename=\"" + fileName + "\"");
        byte[] data = resourceService.loadDownload(request).getData();
        return data;
    }

    @GetMapping(value = "/img/{idResource}")
    public @ResponseBody byte[] loadCdn(@PathVariable("idResource") String idResource)
    {

        return resourceService.loadCdnWhatsapp(idResource).getData();
    }
}