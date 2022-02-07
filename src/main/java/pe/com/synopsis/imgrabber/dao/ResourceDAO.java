
package pe.com.synopsis.imgrabber.dao;

import pe.com.synopsis.imgrabber.beans.request.UploadPhotoRequest;

public interface ResourceDAO
{

    public void uploadPhoto(UploadPhotoRequest uploadPhotoRequest);

    public byte[] loadVideo(String idMessage);

    public byte[] loadResource(String idResource);

    public byte[] loadDownload(String idResource);
}
