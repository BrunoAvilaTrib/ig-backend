
package pe.com.synopsis.imgrabber.business;

import java.util.List;

import javax.validation.Valid;

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

public interface AssignedBL
{

    public void changeAssignedChat(@Valid ChangeAssignedChatRequest changeAssignedChatRequest);

    public void listChangeAssignedChat(@Valid ListChangeAssignedChatRequest listChangeAssignedChatRequest);

    public void automaticReassigned(@Valid AutomaticReassignedRequest automaticReassignedRequest);

    public void updateAssigned(@Valid UpdateAssignedRequest updateAssignedRequest);

    public List<LoadAllReassignedChatsDTO> loadAllReassignedChats(
            @Valid LoadAllReassignedChatsRequest loadAllReassignedChatsRequest);

    public List<LoadChatsReassignedEmployDTO> loadChatsReassignedEmploy(
            @Valid LoadChatsReassignedEmployRequest loadChatsReassignedEmployRequest);

    public List<UploadAssignedDTO> uploadAssigned(@Valid UploadAssignedRequest uploadAssignedRequest);

    public void defuseChangeAssignedChat(@Valid DefuseChangeAssignedChatRequest defuseChangeAssignedChatRequest);

    public void listDefuseChangeAssignedChat(
            @Valid ListDefuseChangeAssignedChatRequest listDefuseChangeAssignedChatRequest);
}
