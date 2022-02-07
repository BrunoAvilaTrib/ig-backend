
package pe.com.synopsis.imgrabber.business.impl;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import pe.com.synopsis.imgrabber.beans.request.ResourceRequest;
import pe.com.synopsis.imgrabber.beans.request.UploadPhotoRequest;
import pe.com.synopsis.imgrabber.business.ResourceBL;
import pe.com.synopsis.imgrabber.dao.ResourceDAO;

@Component
public class ResourceBLImpl implements ResourceBL
{

    @Autowired
    private ResourceDAO resourceDao;

    @Override
    public void uploadPhoto(@Valid UploadPhotoRequest uploadPhotoRequest)
    {
        resourceDao.uploadPhoto(uploadPhotoRequest);
    }

    @Override
    public byte[] loadVideo(ResourceRequest request)
    {
        return resourceDao.loadVideo(request.getIdMessage());
    }

    @Override
    public byte[] loadResource(ResourceRequest request)
    {
        return resourceDao.loadResource(request.getIdMessage());
    }

    @Override
    public byte[] loadDownload(ResourceRequest request)
    {
        return resourceDao.loadDownload(request.getIdMessage());
    }
}
