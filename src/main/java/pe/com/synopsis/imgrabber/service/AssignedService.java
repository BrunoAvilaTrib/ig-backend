
package pe.com.synopsis.imgrabber.service;

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
import pe.com.synopsis.imgrabber.beans.response.Response;

public interface AssignedService
{

    public Response<String> changeAssignedChat(@Valid ChangeAssignedChatRequest changeAssignedChatRequest);

    public Response<String> listChangeAssignedChat(@Valid ListChangeAssignedChatRequest listChangeAssignedChatRequest);

    public Response<String> automaticReassigned(@Valid AutomaticReassignedRequest automaticReassignedRequest);

    public Response<String> updateAssigned(@Valid UpdateAssignedRequest updateAssignedRequest);

    public Response<List<LoadChatsReassignedEmployDTO>> loadChatsReassignedEmploy(
            LoadChatsReassignedEmployRequest loadChatsReassignedEmployRequest);

    public Response<List<LoadAllReassignedChatsDTO>> loadAllReassignedChats(
            LoadAllReassignedChatsRequest loadAllReassignedChatsRequest);

    public Response<List<UploadAssignedDTO>> uploadAssigned(UploadAssignedRequest uploadAssignedRequest);

    public Response<String> defuseChangeAssignedChat(
            @Valid DefuseChangeAssignedChatRequest defuseChangeAssignedChatRequest);

    public Response<String> listDefuseChangeAssignedChat(
            @Valid ListDefuseChangeAssignedChatRequest listDefuseChangeAssignedChatRequest);

}
