
package pe.com.synopsis.imgrabber.dao;

import java.util.List;

import pe.com.synopsis.imgrabber.beans.domain.LoadAllReassignedChats;
import pe.com.synopsis.imgrabber.beans.domain.LoadChatsReassignedEmploy;
import pe.com.synopsis.imgrabber.beans.domain.UploadAssigned;
import pe.com.synopsis.imgrabber.beans.request.AutomaticReassignedRequest;
import pe.com.synopsis.imgrabber.beans.request.ChangeAssignedChatRequest;
import pe.com.synopsis.imgrabber.beans.request.DefuseChangeAssignedChatRequest;
import pe.com.synopsis.imgrabber.beans.request.ListChangeAssignedChatRequest;
import pe.com.synopsis.imgrabber.beans.request.ListDefuseChangeAssignedChatRequest;
import pe.com.synopsis.imgrabber.beans.request.LoadAllReassignedChatsRequest;
import pe.com.synopsis.imgrabber.beans.request.LoadChatsReassignedEmployRequest;
import pe.com.synopsis.imgrabber.beans.request.UpdateAssignedRequest;
import pe.com.synopsis.imgrabber.beans.request.UploadAssignedRequest;

public interface AssignedDAO
{

    public void changeAssignedChat(ChangeAssignedChatRequest changeAssignedChatRequest);

    public void listChangeAssignedChat(ListChangeAssignedChatRequest listChangeAssignedChatRequest);

    public void automaticReassigned(AutomaticReassignedRequest automaticReassignedRequest);

    public void updateAssigned(UpdateAssignedRequest updateAssignedRequest);

    public List<LoadAllReassignedChats> loadAllReassignedChats(
            LoadAllReassignedChatsRequest loadAllReassignedChatsRequest);

    public List<LoadChatsReassignedEmploy> loadChatsReassignedEmploy(
            LoadChatsReassignedEmployRequest loadChatsReassignedEmployRequest);

    public List<UploadAssigned> uploadAssigned(UploadAssignedRequest UploadAssignedRequest);

    public void defuseChangeAssignedChat(DefuseChangeAssignedChatRequest defuseChangeAssignedChatRequest);

    public void listDefuseChangeAssignedChat(ListDefuseChangeAssignedChatRequest listDefuseChangeAssignedChatRequest);
}
