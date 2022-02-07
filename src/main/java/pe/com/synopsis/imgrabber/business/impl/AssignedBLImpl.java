
package pe.com.synopsis.imgrabber.business.impl;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import pe.com.synopsis.imgrabber.beans.domain.LoadAllReassignedChats;
import pe.com.synopsis.imgrabber.beans.domain.LoadChatsReassignedEmploy;
import pe.com.synopsis.imgrabber.beans.domain.UploadAssigned;
import pe.com.synopsis.imgrabber.beans.dto.LoadAllReassignedChatsDTO;
import pe.com.synopsis.imgrabber.beans.dto.LoadChatsReassignedEmployDTO;
import pe.com.synopsis.imgrabber.beans.dto.UploadAssignedDTO;
import pe.com.synopsis.imgrabber.beans.request.AutomaticReassignedRequest;
import pe.com.synopsis.imgrabber.beans.request.ChangeAssignedChatRequest;
import pe.com.synopsis.imgrabber.beans.request.DefuseChangeAssignedChatRequest;
import pe.com.synopsis.imgrabber.beans.request.ListChangeAssignedChatRequest;
import pe.com.synopsis.imgrabber.beans.request.ListDefuseChangeAssignedChatRequest;
import pe.com.synopsis.imgrabber.beans.request.LoadAllReassignedChatsRequest;
import pe.com.synopsis.imgrabber.beans.request.LoadChatsReassignedEmployRequest;
import pe.com.synopsis.imgrabber.beans.request.UpdateAssignedRequest;
import pe.com.synopsis.imgrabber.beans.request.UploadAssignedRequest;
import pe.com.synopsis.imgrabber.business.AssignedBL;
import pe.com.synopsis.imgrabber.converter.GetLastUpdateConverter;
import pe.com.synopsis.imgrabber.converter.GetLastUpdateMSGConverter;
import pe.com.synopsis.imgrabber.converter.LoadAllReassignedChatsConverter;
import pe.com.synopsis.imgrabber.converter.LoadChatsReassignedEmployConverter;
import pe.com.synopsis.imgrabber.converter.LoadContactConverter;
import pe.com.synopsis.imgrabber.converter.LoadMessageConverter;
import pe.com.synopsis.imgrabber.converter.LoadPageConverter;
import pe.com.synopsis.imgrabber.converter.UploadAssignedConverter;
import pe.com.synopsis.imgrabber.dao.AssignedDAO;

@Component
public class AssignedBLImpl implements AssignedBL
{

    @SuppressWarnings("unused")
    private static final Logger logger = LoggerFactory.getLogger(AssignedBLImpl.class);

    @Autowired
    private AssignedDAO assignedDao;

    @Autowired
    LoadMessageConverter msgConverter;

    @Autowired
    LoadContactConverter converter;

    @Autowired
    LoadPageConverter pageConverter;

    @Autowired
    GetLastUpdateConverter getLastUpdateConverter;

    @Autowired
    GetLastUpdateMSGConverter getLastUpdateMSGConverter;

    @Autowired
    LoadAllReassignedChatsConverter loadAllReassignedChatsConverter;

    @Autowired
    LoadChatsReassignedEmployConverter loadChatsReassignedEmployConverter;

    @Autowired
    UploadAssignedConverter uploadAssignedConverter;

    @Override
    public void changeAssignedChat(@Valid ChangeAssignedChatRequest changeAssignedChatRequest)
    {
        assignedDao.changeAssignedChat(changeAssignedChatRequest);
    }

    @Override
    public void listChangeAssignedChat(@Valid ListChangeAssignedChatRequest listChangeAssignedChatRequest)
    {
        assignedDao.listChangeAssignedChat(listChangeAssignedChatRequest);
    }

    @Override
    public void automaticReassigned(@Valid AutomaticReassignedRequest automaticReassignedRequest)
    {
        assignedDao.automaticReassigned(automaticReassignedRequest);
    }

    @Override
    public void updateAssigned(@Valid UpdateAssignedRequest updateAssignedRequest)
    {
        assignedDao.updateAssigned(updateAssignedRequest);
    }

    @Override
    public List<LoadChatsReassignedEmployDTO> loadChatsReassignedEmploy(
            @Valid LoadChatsReassignedEmployRequest loadChatsReassignedEmployRequest)
    {
        List<LoadChatsReassignedEmploy> response = assignedDao
                .loadChatsReassignedEmploy(loadChatsReassignedEmployRequest);
        return loadChatsReassignedEmployConverter.convert(response);
    }

    @Override
    public List<LoadAllReassignedChatsDTO> loadAllReassignedChats(
            @Valid LoadAllReassignedChatsRequest loadAllReassignedChatsRequest)
    {
        List<LoadAllReassignedChats> response = assignedDao.loadAllReassignedChats(loadAllReassignedChatsRequest);
        return loadAllReassignedChatsConverter.convert(response);
    }

    @Override
    public List<UploadAssignedDTO> uploadAssigned(UploadAssignedRequest uploadAssignedRequest)
    {
        List<UploadAssigned> response = assignedDao.uploadAssigned(uploadAssignedRequest);
        return uploadAssignedConverter.convert(response);
    }

    @Override
    public void defuseChangeAssignedChat(@Valid DefuseChangeAssignedChatRequest defuseChangeAssignedChatRequest)
    {
        assignedDao.defuseChangeAssignedChat(defuseChangeAssignedChatRequest);
    }

    @Override
    public void listDefuseChangeAssignedChat(
            @Valid ListDefuseChangeAssignedChatRequest listDefuseChangeAssignedChatRequest)
    {
        assignedDao.listDefuseChangeAssignedChat(listDefuseChangeAssignedChatRequest);
    }
}
