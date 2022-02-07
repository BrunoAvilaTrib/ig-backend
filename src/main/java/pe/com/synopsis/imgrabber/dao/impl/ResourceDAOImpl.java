
package pe.com.synopsis.imgrabber.dao.impl;

import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Component;

import pe.com.synopsis.imgrabber.beans.domain.Resource;
import pe.com.synopsis.imgrabber.beans.request.UploadPhotoRequest;
import pe.com.synopsis.imgrabber.dao.ResourceDAO;
import pe.com.synopsis.imgrabber.dao.sp.SPResource;
import pe.com.synopsis.imgrabber.dao.sp.SPUploadPhoto;
import pe.com.synopsis.imgrabber.dao.sp.SPVideo;
import pe.com.synopsis.imgrabber.enumeration.PropsEnum;
import pe.com.synopsis.imgrabber.enumeration.SPCodeEnum;
import pe.com.synopsis.imgrabber.exception.RulesException;

@Component
@SuppressWarnings({ "unchecked" })
public class ResourceDAOImpl implements ResourceDAO
{

    private static final Logger logger = LoggerFactory.getLogger(ResourceDAOImpl.class);

    @Autowired
    SPUploadPhoto sPUploadPhoto;

    @Autowired
    private SPVideo spVideo;

    @Autowired
    private SPResource spResource;

    @Autowired
    private Environment env;

    @Override
    public void uploadPhoto(UploadPhotoRequest uploadPhotoRequest)
    {

        SqlParameterSource in = new MapSqlParameterSource()
                .addValue(SPUploadPhoto.IN_ID_CHAT, uploadPhotoRequest.getIdChat())
                .addValue(SPUploadPhoto.IN_PHOTO, uploadPhotoRequest.getPhoto())
                .addValue(SPUploadPhoto.IN_MODE, uploadPhotoRequest.getMode());

        Map<String, Object> result = sPUploadPhoto.execute(in);
        String status = (String) result.get(SPUploadPhoto.OUT_STATUS);

        if (!SPCodeEnum.RESULT_OK.isCode(status))
        {
            throw new RulesException(status);
        }
    }

    @Override
    public byte[] loadVideo(String idMessage)
    {
        SqlParameterSource in = new MapSqlParameterSource().addValue(SPVideo.IN_MESSAGEID, idMessage);

        Map<String, Object> result = spVideo.execute(in);
        List<Resource> video = (List<Resource>) result.get(SPVideo.OUT_CURSOR);
        String status = (String) result.get(SPVideo.OUT_STATUS);

        if (!SPCodeEnum.RESULT_OK.isCode(status))
        {
            throw new RulesException(status);
        }
        return video.get(0).getContent();
    }

    @Override
    public byte[] loadResource(String idResource)
    {
        SqlParameterSource in = new MapSqlParameterSource().addValue(SPResource.IN_RESOURCEID, idResource)
                .addValue(SPResource.IN_MODE, SPResource.MODE_RESOURCE);

        Map<String, Object> result = spResource.execute(in);
        List<Resource> resource = (List<Resource>) result.get(SPResource.OUT_CURSOR);
        String status = (String) result.get(SPResource.OUT_STATUS);

        if (!SPCodeEnum.RESULT_OK.isCode(status))
        {
            throw new RulesException(status);
        }
        return resource.get(0).getContent();
    }

    @Override
    public byte[] loadDownload(String idResource)
    {
        SqlParameterSource in = new MapSqlParameterSource().addValue(SPResource.IN_RESOURCEID, idResource)
                .addValue(SPResource.IN_MODE, SPResource.MODE_DOWNLOAD);

        Map<String, Object> result = spResource.execute(in);
        List<Resource> resource = (List<Resource>) result.get(SPResource.OUT_CURSOR);
        String status = (String) result.get(SPResource.OUT_STATUS);

        if (!SPCodeEnum.RESULT_OK.isCode(status))
        {
            throw new RulesException(status);
        }

        byte[] data = resource.get(0).getContent();
        String path = PropsEnum.DEV_HOME.getString(env) + "/download.file";

        try (OutputStream os = new FileOutputStream(path);)
        {
            os.write(data);
        }
        catch (Exception e)
        {
            logger.error(e.getMessage(), e);
        }
        return data;
    }
}
