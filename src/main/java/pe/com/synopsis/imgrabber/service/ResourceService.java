
package pe.com.synopsis.imgrabber.service;

import javax.validation.Valid;

import pe.com.synopsis.imgrabber.beans.request.ResourceRequest;
import pe.com.synopsis.imgrabber.beans.request.UploadPhotoRequest;
import pe.com.synopsis.imgrabber.beans.response.Response;

public interface ResourceService
{
    public Response<String> uploadPhoto(@Valid UploadPhotoRequest uploadPhotoRequest);

    public Response<byte[]> loadVideo(ResourceRequest request);

    public Response<byte[]> loadResource(ResourceRequest request);

    public Response<byte[]> loadCdnWhatsapp(String resource);

    public Response<byte[]> loadDownload(ResourceRequest request);
}
