
package pe.com.synopsis.imgrabber.dao.impl;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Component;

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
import pe.com.synopsis.imgrabber.dao.AssignedDAO;
import pe.com.synopsis.imgrabber.dao.sp.SPAutomaticReassigned;
import pe.com.synopsis.imgrabber.dao.sp.SPChangeAssignedChat;
import pe.com.synopsis.imgrabber.dao.sp.SPDefuseChangeAssignedChat;
import pe.com.synopsis.imgrabber.dao.sp.SPLoadAllReassignedChats;
import pe.com.synopsis.imgrabber.dao.sp.SPLoadChatsReassignedEmploy;
import pe.com.synopsis.imgrabber.dao.sp.SPUpdateAssigned;
import pe.com.synopsis.imgrabber.dao.sp.SPUploadAssigned;
import pe.com.synopsis.imgrabber.enumeration.SPCodeEnum;
import pe.com.synopsis.imgrabber.exception.RulesException;

@Component
@SuppressWarnings({ "unchecked", "unused" })
public class AssignedDAOImpl implements AssignedDAO
{

    private static final Logger logger = LoggerFactory.getLogger(AssignedDAOImpl.class);

    @Autowired
    SPChangeAssignedChat sPChangeAssignedChat;

    @Autowired
    SPAutomaticReassigned sPAutomaticReassigned;

    @Autowired
    SPUpdateAssigned sPUpdateAssigned;

    @Autowired
    SPLoadChatsReassignedEmploy sPLoadChatsReassignedEmploy;

    @Autowired
    SPLoadAllReassignedChats sPLoadAllReassignedChats;

    @Autowired
    SPUploadAssigned sPUploadAssigned;

    @Autowired
    SPDefuseChangeAssignedChat sPDefuseChangeAssignedChat;

    @Override
    public void changeAssignedChat(ChangeAssignedChatRequest changeAssignedChatRequest)
    {

        SqlParameterSource in = new MapSqlParameterSource()
                .addValue(SPChangeAssignedChat.IN_CHAT_FK, changeAssignedChatRequest.getChatFK()).addValue(
                        SPChangeAssignedChat.IN_REASIGNED_EMPLOY_FK, changeAssignedChatRequest.getReasignedEmployFK());

        Map<String, Object> result = sPChangeAssignedChat.execute(in);
        String status = (String) result.get(SPChangeAssignedChat.OUT_STATUS);

        if (!SPCodeEnum.RESULT_OK.isCode(status))
        {
            throw new RulesException(status);
        }
    }

    @Override
    public void listChangeAssignedChat(ListChangeAssignedChatRequest listChangeAssignedChatRequest)
    {

        for (ChangeAssignedChatRequest changeAssignedChatRequest : listChangeAssignedChatRequest
                .getChangeAssignedChatRequest())
        {
            changeAssignedChat(changeAssignedChatRequest);
        }
    }

    @Override
    public void automaticReassigned(AutomaticReassignedRequest automaticReassignedRequest)
    {

        SqlParameterSource in = new MapSqlParameterSource()
                .addValue(SPAutomaticReassigned.IN_EMPLOY_FK, automaticReassignedRequest.getEmployFK())
                .addValue(SPAutomaticReassigned.IN_DATE, automaticReassignedRequest.getDate());

        Map<String, Object> result = sPAutomaticReassigned.execute(in);
        String status = (String) result.get(SPAutomaticReassigned.OUT_STATUS);

        if (!SPCodeEnum.RESULT_OK.isCode(status))
        {
            throw new RulesException(status);
        }
    }

    @Override
    public void updateAssigned(UpdateAssignedRequest updateAssignedRequest)
    {

        SqlParameterSource in = new MapSqlParameterSource()
                .addValue(SPUpdateAssigned.IN_CHAT_FK, updateAssignedRequest.getChatFK())
                .addValue(SPUpdateAssigned.IN_EMPLOY_FK, updateAssignedRequest.getEmployFK());

        Map<String, Object> result = sPUpdateAssigned.execute(in);
        String status = (String) result.get(SPUpdateAssigned.OUT_STATUS);

        if (!SPCodeEnum.RESULT_OK.isCode(status))
        {
            throw new RulesException(status);
        }
    }

    @Override
    public List<LoadAllReassignedChats> loadAllReassignedChats(
            LoadAllReassignedChatsRequest loadAllReassignedChatsRequest)
    {

        SqlParameterSource in = new MapSqlParameterSource().addValue(SPLoadAllReassignedChats.IN_EMPLOY_PK,
                loadAllReassignedChatsRequest.getEmployPk());

        Map<String, Object> result = sPLoadAllReassignedChats.execute(in);
        String status = (String) result.get(SPLoadAllReassignedChats.OUT_STATUS);

        if (!SPCodeEnum.RESULT_OK.isCode(status))
        {
            throw new RulesException(status);
        }

        List<LoadAllReassignedChats> loadAllReassignedChats = (List<LoadAllReassignedChats>) result
                .get(SPLoadAllReassignedChats.OUT_CURSOR);
        return loadAllReassignedChats;
    }

    @Override
    public List<LoadChatsReassignedEmploy> loadChatsReassignedEmploy(
            LoadChatsReassignedEmployRequest loadChatsReassignedEmployRequest)
    {

        SqlParameterSource in = new MapSqlParameterSource().addValue(SPLoadChatsReassignedEmploy.IN_EMPLOY_PK,
                loadChatsReassignedEmployRequest.getEmployPK());

        Map<String, Object> result = sPLoadChatsReassignedEmploy.execute(in);
        String status = (String) result.get(SPLoadChatsReassignedEmploy.OUT_STATUS);

        if (!SPCodeEnum.RESULT_OK.isCode(status))
        {
            throw new RulesException(status);
        }

        List<LoadChatsReassignedEmploy> loadChatsReassignedEmploy = (List<LoadChatsReassignedEmploy>) result
                .get(SPLoadChatsReassignedEmploy.OUT_CURSOR);
        return loadChatsReassignedEmploy;
    }

    @Override
    public List<UploadAssigned> uploadAssigned(UploadAssignedRequest uploadAssignedRequest)
    {

        SqlParameterSource in = new MapSqlParameterSource()
                .addValue(SPUploadAssigned.ID_EMPLOY, uploadAssignedRequest.getIdEmploy())
                .addValue(SPUploadAssigned.ID_AREA, uploadAssignedRequest.getIdArea())
                .addValue(SPUploadAssigned.ID_CHAT, uploadAssignedRequest.getIdChat());

        Map<String, Object> result = sPUploadAssigned.execute(in);
        String status = (String) result.get(SPUploadAssigned.OUT_STATUS);

        if (!SPCodeEnum.RESULT_OK.isCode(status))
        {
            throw new RulesException(status);
        }

        List<UploadAssigned> uploadAssigned = (List<UploadAssigned>) result.get(SPUploadAssigned.OUT_CURSOR);
        return uploadAssigned;
    }

    @Override
    public void defuseChangeAssignedChat(DefuseChangeAssignedChatRequest defuseChangeAssignedChatRequest)
    {
        SqlParameterSource in = new MapSqlParameterSource().addValue(SPDefuseChangeAssignedChat.IN_CHAT_FK,
                defuseChangeAssignedChatRequest.getChatFK());

        Map<String, Object> result = sPDefuseChangeAssignedChat.execute(in);
        String status = (String) result.get(SPDefuseChangeAssignedChat.OUT_STATUS);

        if (!SPCodeEnum.RESULT_OK.isCode(status))
        {
            throw new RulesException(status);
        }
    }

    @Override
    public void listDefuseChangeAssignedChat(ListDefuseChangeAssignedChatRequest listDefuseChangeAssignedChatRequest)
    {
        for (DefuseChangeAssignedChatRequest defuseChangeAssignedChatRequest : listDefuseChangeAssignedChatRequest
                .getListDefuseChangeAssignedChatRequest())
        {
            defuseChangeAssignedChat(defuseChangeAssignedChatRequest);
        }
    }
}
