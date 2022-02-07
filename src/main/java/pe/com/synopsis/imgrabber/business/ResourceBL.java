
package pe.com.synopsis.imgrabber.business;

import javax.validation.Valid;

import pe.com.synopsis.imgrabber.beans.request.ResourceRequest;
import pe.com.synopsis.imgrabber.beans.request.UploadPhotoRequest;

public interface ResourceBL
{
    public void uploadPhoto(@Valid UploadPhotoRequest uploadPhotoRequest);

    public byte[] loadVideo(ResourceRequest login);

    public byte[] loadResource(ResourceRequest login);

    public byte[] loadDownload(ResourceRequest request);

}
