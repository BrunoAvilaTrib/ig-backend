
package pe.com.synopsis.imgrabber.dao.impl;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import pe.com.synopsis.imgrabber.beans.domain.LoadAllEmploy;
import pe.com.synopsis.imgrabber.beans.domain.LoadAllEmployByRole;
import pe.com.synopsis.imgrabber.beans.domain.LoadEmploy;
import pe.com.synopsis.imgrabber.beans.request.AddAdminEmployRequest;
import pe.com.synopsis.imgrabber.beans.request.AddExcluidRequest;
import pe.com.synopsis.imgrabber.beans.request.AddOfficerEmployRequest;
import pe.com.synopsis.imgrabber.beans.request.AddSupervisorEmployRequest;
import pe.com.synopsis.imgrabber.beans.request.DefuseEmployRequest;
import pe.com.synopsis.imgrabber.beans.request.DefuseSupervisorRequest;
import pe.com.synopsis.imgrabber.beans.request.LoadAreaRequest;
import pe.com.synopsis.imgrabber.beans.request.LoadEmployRequest;
import pe.com.synopsis.imgrabber.beans.request.UpdateAdminEmployRequest;
import pe.com.synopsis.imgrabber.beans.request.UpdateAdminGlobalPasswordRequest;
import pe.com.synopsis.imgrabber.beans.request.UpdateOfficerEmployRequest;
import pe.com.synopsis.imgrabber.beans.request.UpdateSupervisorEmployRequest;
import pe.com.synopsis.imgrabber.converter.LoadAuthoritiesConverter;
import pe.com.synopsis.imgrabber.converter.LoadRolesConverter;
import pe.com.synopsis.imgrabber.dao.EmployDAO;
import pe.com.synopsis.imgrabber.dao.ExcluidDAO;
import pe.com.synopsis.imgrabber.dao.ValidTokenAndStatusDAO;
import pe.com.synopsis.imgrabber.dao.sp.SPAddAdminBusinessEmploy;
import pe.com.synopsis.imgrabber.dao.sp.SPAddOfficerEmploy;
import pe.com.synopsis.imgrabber.dao.sp.SPAddSupervisorEmploy;
import pe.com.synopsis.imgrabber.dao.sp.SPChangeSupervisor;
import pe.com.synopsis.imgrabber.dao.sp.SPDefuseAdminBusinessEmploy;
import pe.com.synopsis.imgrabber.dao.sp.SPDefuseOfficerEmploy;
import pe.com.synopsis.imgrabber.dao.sp.SPDefuseSupervisorEmploy;
import pe.com.synopsis.imgrabber.dao.sp.SPLoadAllEmploy;
import pe.com.synopsis.imgrabber.dao.sp.SPLoadAllEmployByArea;
import pe.com.synopsis.imgrabber.dao.sp.SPLoadAllOfficerBySupervisor;
import pe.com.synopsis.imgrabber.dao.sp.SPLoadAllSupervisorByArea;
import pe.com.synopsis.imgrabber.dao.sp.SPLoadAllSupervisorForDefuse;
import pe.com.synopsis.imgrabber.dao.sp.SPLoadEmploy;
import pe.com.synopsis.imgrabber.dao.sp.SPLoadExcluidEmploy;
import pe.com.synopsis.imgrabber.dao.sp.SPUpdateAdminBusinessEmploy;
import pe.com.synopsis.imgrabber.dao.sp.SPUpdateAdminGlobalPassword;
import pe.com.synopsis.imgrabber.dao.sp.SPUpdateOfficerEmploy;
import pe.com.synopsis.imgrabber.dao.sp.SPUpdateSupervisorEmploy;
import pe.com.synopsis.imgrabber.enumeration.SPCodeEnum;
import pe.com.synopsis.imgrabber.exception.RulesException;
import pe.com.synopsis.imgrabber.security.SecurityToken;

@Component
@SuppressWarnings({ "unchecked", "unused" })
public class EmployDAOImpl implements EmployDAO
{

    private static final Logger logger = LoggerFactory.getLogger(EmployDAOImpl.class);

    @Autowired
    private SPLoadAllSupervisorByArea sPLoadAllSupervisorByArea;

    @Autowired
    private SPLoadAllEmployByArea sPLoadAllEmployByArea;

    @Autowired
    private SPLoadAllOfficerBySupervisor sPLoadAllOfficerBySupervisor;

    @Autowired
    private SPLoadAllEmploy sPLoadAllEmploy;

    @Autowired
    private SPLoadEmploy sPLoadEmploy;

    @Autowired
    private SPAddAdminBusinessEmploy sPAddAdminBusinessEmploy;

    @Autowired
    private SPAddSupervisorEmploy sPAddSupervisorEmploy;

    @Autowired
    private SPAddOfficerEmploy sPAddOfficerEmploy;

    @Autowired
    private SPUpdateAdminBusinessEmploy sPUpdateAdminBusinessEmploy;

    @Autowired
    private SPUpdateSupervisorEmploy sPUpdateSupervisorEmploy;

    @Autowired
    private SPUpdateOfficerEmploy sPUpdateOfficerEmploy;

    @Autowired
    private SPLoadAllSupervisorForDefuse sPLoadAllSupervisorForDefuse;

    @Autowired
    private SPDefuseOfficerEmploy sPDefuseOfficerEmploy;

    @Autowired
    private SPDefuseSupervisorEmploy sPDefuseSupervisorEmploy;

    @Autowired
    private SPUpdateAdminGlobalPassword sPUpdateAdminGlobalPassword;

    @Autowired
    private SPDefuseAdminBusinessEmploy sPDefuseAdminBusinessEmploy;

    @Autowired
    private LoadRolesConverter loadRolesConverter;

    @Autowired
    private SPChangeSupervisor sPChangeSupervisor;

    @Autowired
    private LoadAuthoritiesConverter loadRolsConverter;

    @Autowired
    private ValidTokenAndStatusDAO validTokenAndStatusDAO;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    private ExcluidDAO excluidDAO;

    @Override
    public List<LoadAllEmployByRole> loadAllEmployByArea(LoadAreaRequest loadAreaRequest, Long loginEmployFK)
    {

        SqlParameterSource in = new MapSqlParameterSource()
                .addValue(SPLoadAllEmployByArea.IN_AREA_FK, loadAreaRequest.getAreaPk())
                .addValue(SPLoadAllEmployByArea.IN_LOGIN_EMPLOY_PK, loginEmployFK);

        Map<String, Object> result = sPLoadAllEmployByArea.execute(in);
        List<LoadAllEmployByRole> employ = (List<LoadAllEmployByRole>) result.get(SPLoadAllEmployByArea.OUT_CURSOR);
        String status = (String) result.get(SPLoadAllEmployByArea.OUT_STATUS);

        if (!SPCodeEnum.RESULT_OK.isCode(status))
        {
            throw new RulesException(status);
        }
        return employ;
    }

    @Override
    public List<LoadAllEmployByRole> loadAllSupervisorByArea(LoadAreaRequest loadAreaRequest)
    {

        SqlParameterSource in = new MapSqlParameterSource().addValue(SPLoadAllSupervisorByArea.IN_AREA_FK,
                loadAreaRequest.getAreaPk());

        Map<String, Object> result = sPLoadAllSupervisorByArea.execute(in);
        String status = (String) result.get(SPLoadAllSupervisorByArea.OUT_STATUS);

        if (!SPCodeEnum.RESULT_OK.isCode(status))
        {
            throw new RulesException(status);
        }

        List<LoadAllEmployByRole> employ = (List<LoadAllEmployByRole>) result.get(SPLoadAllSupervisorByArea.OUT_CURSOR);
        return employ;
    }

    @Override
    public List<LoadAllEmployByRole> loadAllOfficerBySupervisor(LoadEmployRequest loadEmployRequest)
    {

        SqlParameterSource in = new MapSqlParameterSource().addValue(SPLoadAllOfficerBySupervisor.IN_EMPLOY_FK,
                loadEmployRequest.getEmployPk());

        Map<String, Object> result = sPLoadAllOfficerBySupervisor.execute(in);
        String status = (String) result.get(SPLoadAllOfficerBySupervisor.OUT_STATUS);

        if (!SPCodeEnum.RESULT_OK.isCode(status))
        {
            throw new RulesException(status);
        }

        List<LoadAllEmployByRole> employ = (List<LoadAllEmployByRole>) result
                .get(SPLoadAllOfficerBySupervisor.OUT_CURSOR);
        return employ;
    }

    @Override
    public List<LoadAllEmploy> loadAllEmploy(Long loginEmployPK)
    {

        SqlParameterSource in = new MapSqlParameterSource().addValue(SPLoadAllEmploy.IN_LOGIN_EMPLOY_PK, loginEmployPK);

        Map<String, Object> result = sPLoadAllEmploy.execute(in);
        String status = (String) result.get(SPLoadAllEmploy.OUT_STATUS);

        if (!SPCodeEnum.RESULT_OK.isCode(status))
        {
            throw new RulesException(status);
        }

        List<LoadAllEmploy> employees = (List<LoadAllEmploy>) result.get(SPLoadAllEmploy.OUT_CURSOR);
        return employees;
    }

    @Override
    public List<LoadEmploy> loadRoleEmploy(Long loginEmployPK)
    {

        SqlParameterSource in = new MapSqlParameterSource().addValue(SPLoadEmploy.IN_EMPLOY_PK, loginEmployPK);

        Map<String, Object> result = sPLoadEmploy.execute(in);
        String status = (String) result.get(SPLoadEmploy.OUT_STATUS);

        if (!SPCodeEnum.RESULT_OK.isCode(status))
        {
            throw new RulesException(status);
        }

        List<LoadEmploy> employ = (List<LoadEmploy>) result.get(SPLoadEmploy.OUT_CURSOR);
        return employ;
    }

    @Override
    public List<LoadEmploy> loadEmploy(LoadEmployRequest LoadEmployRequest)
    {

        SqlParameterSource in = new MapSqlParameterSource().addValue(SPLoadEmploy.IN_EMPLOY_PK,
                LoadEmployRequest.getEmployPk());

        Map<String, Object> result = sPLoadEmploy.execute(in);
        String status = (String) result.get(SPLoadExcluidEmploy.OUT_STATUS);

        if (!SPCodeEnum.RESULT_OK.isCode(status))
        {
            throw new RulesException(status);
        }

        List<LoadEmploy> traceuser = (List<LoadEmploy>) result.get(SPLoadExcluidEmploy.OUT_CURSOR);
        return traceuser;
    }

    @Override
    public void addAdminEmploy(AddAdminEmployRequest addAdminEmployRequest, Long loginEmployPK)
    {

        SqlParameterSource in = new MapSqlParameterSource()
                .addValue(SPAddAdminBusinessEmploy.IN_NAME, addAdminEmployRequest.getName())
                .addValue(SPAddAdminBusinessEmploy.IN_APPAT, addAdminEmployRequest.getApePat())
                .addValue(SPAddAdminBusinessEmploy.IN_APMAT, addAdminEmployRequest.getApeMat())
                .addValue(SPAddAdminBusinessEmploy.IN_EMAIL, addAdminEmployRequest.getEmail())
                .addValue(SPAddAdminBusinessEmploy.IN_PASSWORD,
                        bCryptPasswordEncoder.encode(addAdminEmployRequest.getPassword()))
                .addValue(SPAddAdminBusinessEmploy.IN_SEX, addAdminEmployRequest.getSex())
                .addValue(SPAddAdminBusinessEmploy.IN_MOBILE, addAdminEmployRequest.getMobile())
                .addValue(SPAddAdminBusinessEmploy.IN_BUSINESS_FK, addAdminEmployRequest.getBusinessFK())
                .addValue(SPAddAdminBusinessEmploy.IN_ROLE_FK, addAdminEmployRequest.getRoleFK())
                .addValue(SPAddAdminBusinessEmploy.IN_LOGIN_EMPLOY_PK, loginEmployPK);

        Map<String, Object> result = sPAddAdminBusinessEmploy.execute(in);
        String status = (String) result.get(SPAddAdminBusinessEmploy.OUT_STATUS);

        if (!SPCodeEnum.RESULT_OK.isCode(status))
        {
            throw new RulesException(status);
        }
    }

    @Override
    public void addSupervisorEmploy(AddSupervisorEmployRequest addSupervisorEmployRequest, Long loginEmployPK)
    {

        SqlParameterSource in = new MapSqlParameterSource()
                .addValue(SPAddSupervisorEmploy.IN_NAME, addSupervisorEmployRequest.getName())
                .addValue(SPAddSupervisorEmploy.IN_APPAT, addSupervisorEmployRequest.getApePat())
                .addValue(SPAddSupervisorEmploy.IN_APMAT, addSupervisorEmployRequest.getApeMat())
                .addValue(SPAddSupervisorEmploy.IN_EMAIL, addSupervisorEmployRequest.getEmail())
                .addValue(SPAddSupervisorEmploy.IN_PASSWORD,
                        bCryptPasswordEncoder.encode(addSupervisorEmployRequest.getPassword()))
                .addValue(SPAddSupervisorEmploy.IN_SEX, addSupervisorEmployRequest.getSex())
                .addValue(SPAddSupervisorEmploy.IN_MOBILE, addSupervisorEmployRequest.getMobile())
                .addValue(SPAddSupervisorEmploy.IN_BUSINESS_FK, addSupervisorEmployRequest.getBusinessFK())
                .addValue(SPAddSupervisorEmploy.IN_ROLE_FK, addSupervisorEmployRequest.getRoleFK())
                .addValue(SPAddSupervisorEmploy.IN_AREA_FK, addSupervisorEmployRequest.getAreaFK())
                .addValue(SPAddSupervisorEmploy.IN_PRIVILEGE_STATE, addSupervisorEmployRequest.getStatePrivilege())
                .addValue(SPAddSupervisorEmploy.IN_LOGIN_EMPLOY_PK, loginEmployPK);

        Map<String, Object> result = sPAddSupervisorEmploy.execute(in);
        String status = (String) result.get(SPAddSupervisorEmploy.OUT_STATUS);

        if (!SPCodeEnum.RESULT_OK.isCode(status))
        {
            throw new RulesException(status);
        }
    }

    @Override
    public void addOfficerEmploy(AddOfficerEmployRequest addOfficerEmployRequest, Long loginEmployPK)
    {

        SqlParameterSource in = new MapSqlParameterSource()
                .addValue(SPAddOfficerEmploy.IN_NAME, addOfficerEmployRequest.getName())
                .addValue(SPAddOfficerEmploy.IN_APPAT, addOfficerEmployRequest.getApePat())
                .addValue(SPAddOfficerEmploy.IN_APMAT, addOfficerEmployRequest.getApeMat())
                .addValue(SPAddOfficerEmploy.IN_EMAIL, addOfficerEmployRequest.getEmail())
                .addValue(SPAddOfficerEmploy.IN_PASSWORD,
                        bCryptPasswordEncoder.encode(addOfficerEmployRequest.getPassword()))
                .addValue(SPAddOfficerEmploy.IN_GENDER, addOfficerEmployRequest.getSex())
                .addValue(SPAddOfficerEmploy.IN_MOBILE, addOfficerEmployRequest.getMobile())
                .addValue(SPAddOfficerEmploy.IN_BUSINESS_FK, addOfficerEmployRequest.getBusinessFK())
                .addValue(SPAddOfficerEmploy.IN_ROLE_FK, addOfficerEmployRequest.getRoleFK())
                .addValue(SPAddOfficerEmploy.IN_AREA_FK, addOfficerEmployRequest.getAreaFK())
                .addValue(SPAddOfficerEmploy.IN_SUPERVISOR_FK, addOfficerEmployRequest.getEmployFk())
                .addValue(SPAddOfficerEmploy.IN_PRIVILEGE_STATE, addOfficerEmployRequest.getStatePrivilege())
                .addValue(SPAddOfficerEmploy.IN_LOGIN_EMPLOY_PK, loginEmployPK);

        Map<String, Object> result = sPAddOfficerEmploy.execute(in);
        String status = (String) result.get(SPAddOfficerEmploy.OUT_STATUS);

        if (!SPCodeEnum.RESULT_OK.isCode(status))
        {
            throw new RulesException(status);
        }
       
    }

    @Override
    public void updateAdminGlobalPassword(UpdateAdminGlobalPasswordRequest updateAdminGlobalPasswordRequest,
            SecurityToken token)
    {

        SqlParameterSource in = new MapSqlParameterSource()
                .addValue(SPUpdateAdminGlobalPassword.IN_PASSWORD,
                        bCryptPasswordEncoder.encode(updateAdminGlobalPasswordRequest.getPassword()))
                .addValue(SPUpdateAdminGlobalPassword.IN_EMPLOY_PK, updateAdminGlobalPasswordRequest.getEmployPK())
                .addValue(SPUpdateAdminGlobalPassword.IN_LOGIN_EMPLOY_PK, token.getUserInfo().getEmployPk());

        Map<String, Object> result = sPUpdateAdminGlobalPassword.execute(in);
        String status = (String) result.get(SPUpdateAdminGlobalPassword.OUT_STATUS);

        if (!SPCodeEnum.RESULT_OK.isCode(status))
        {
            throw new RulesException(status);
        }
    }

    @Override
    public void updateAdminBusinessEmploy(UpdateAdminEmployRequest updateAdminEmployRequest, SecurityToken token)
    {

        SqlParameterSource in = new MapSqlParameterSource()
                .addValue(SPUpdateAdminBusinessEmploy.IN_EMPLOY_PK, updateAdminEmployRequest.getEmployPk())
                .addValue(SPUpdateAdminBusinessEmploy.IN_NAME, updateAdminEmployRequest.getName())
                .addValue(SPUpdateAdminBusinessEmploy.IN_APPAT, updateAdminEmployRequest.getApePat())
                .addValue(SPUpdateAdminBusinessEmploy.IN_APMAT, updateAdminEmployRequest.getApeMat())
                .addValue(SPUpdateAdminBusinessEmploy.IN_EMAIL, updateAdminEmployRequest.getEmail())
                .addValue(SPUpdateAdminBusinessEmploy.IN_PASSWORD,
                        bCryptPasswordEncoder.encode(updateAdminEmployRequest.getPassword()))
                .addValue(SPUpdateAdminBusinessEmploy.IN_SEX, updateAdminEmployRequest.getSex())
                .addValue(SPUpdateAdminBusinessEmploy.IN_MOBILE, updateAdminEmployRequest.getMobile())
                .addValue(SPUpdateAdminBusinessEmploy.IN_LOGIN_EMPLOY_PK, token.getUserInfo().getEmployPk());

        Map<String, Object> result = sPUpdateAdminBusinessEmploy.execute(in);
        String status = (String) result.get(SPUpdateAdminBusinessEmploy.OUT_STATUS);

        if (!SPCodeEnum.RESULT_OK.isCode(status))
        {
            throw new RulesException(status);
        }
    }

    @Override
    public void updateSupervisorEmploy(UpdateSupervisorEmployRequest updateSupervisorEmployRequest, Long loginEmployPK)
    {

        SqlParameterSource in = new MapSqlParameterSource()
                .addValue(SPUpdateSupervisorEmploy.IN_EMPLOY_PK, updateSupervisorEmployRequest.getEmployPk())
                .addValue(SPUpdateSupervisorEmploy.IN_NAME, updateSupervisorEmployRequest.getName())
                .addValue(SPUpdateSupervisorEmploy.IN_APPAT, updateSupervisorEmployRequest.getApePat())
                .addValue(SPUpdateSupervisorEmploy.IN_APMAT, updateSupervisorEmployRequest.getApeMat())
                .addValue(SPUpdateSupervisorEmploy.IN_EMAIL, updateSupervisorEmployRequest.getEmail())
                .addValue(SPUpdateSupervisorEmploy.IN_PASSWORD,
                        bCryptPasswordEncoder.encode(updateSupervisorEmployRequest.getPassword()))
                .addValue(SPUpdateSupervisorEmploy.IN_SEX, updateSupervisorEmployRequest.getSex())
                .addValue(SPUpdateSupervisorEmploy.IN_MOBILE, updateSupervisorEmployRequest.getMobile())
                .addValue(SPUpdateSupervisorEmploy.IN_AREA_FK, updateSupervisorEmployRequest.getAreaFk())
                .addValue(SPUpdateSupervisorEmploy.IN_PRIVILEGE_STATE,
                        updateSupervisorEmployRequest.getStatePrivilege())
                .addValue(SPUpdateSupervisorEmploy.IN_LOGIN_EMPLOY_PK, loginEmployPK);

        Map<String, Object> result = sPUpdateSupervisorEmploy.execute(in);
        String status = (String) result.get(SPUpdateSupervisorEmploy.OUT_STATUS);

        if (!SPCodeEnum.RESULT_OK.isCode(status))
        {
            throw new RulesException(status);
        }
    }

    @Override
    public void updateOfficerEmploy(UpdateOfficerEmployRequest updateOfficerEmployRequest, Long loginEmployPK)
    {

        SqlParameterSource in = new MapSqlParameterSource()
                .addValue(SPUpdateOfficerEmploy.IN_EMPLOY_PK, updateOfficerEmployRequest.getEmployPk())
                .addValue(SPUpdateOfficerEmploy.IN_NAME, updateOfficerEmployRequest.getName())
                .addValue(SPUpdateOfficerEmploy.IN_APPAT, updateOfficerEmployRequest.getApePat())
                .addValue(SPUpdateOfficerEmploy.IN_APMAT, updateOfficerEmployRequest.getApeMat())
                .addValue(SPUpdateOfficerEmploy.IN_EMAIL, updateOfficerEmployRequest.getEmail())
                .addValue(SPUpdateOfficerEmploy.IN_PASSWORD,
                        bCryptPasswordEncoder.encode(updateOfficerEmployRequest.getPassword()))
                .addValue(SPUpdateOfficerEmploy.IN_GENDER, updateOfficerEmployRequest.getSex())
                .addValue(SPUpdateOfficerEmploy.IN_MOBILE, updateOfficerEmployRequest.getMobile())
                .addValue(SPUpdateOfficerEmploy.IN_AREA_FK, updateOfficerEmployRequest.getAreaFk())
                .addValue(SPUpdateOfficerEmploy.IN_EMPLOY_FK, updateOfficerEmployRequest.getEmployFk())
          
                .addValue(SPUpdateOfficerEmploy.IN_LOGIN_EMPLOY_PK, loginEmployPK);

        Map<String, Object> result = sPUpdateOfficerEmploy.execute(in);
        String status = (String) result.get(SPUpdateOfficerEmploy.OUT_STATUS);

        if (!SPCodeEnum.RESULT_OK.isCode(status))
        {
            throw new RulesException(status);
        }        
    }

    @Override
    public void defuseOfficerEmploy(DefuseEmployRequest defuseEmployRequest, Long loginEmployPK)
    {

        SqlParameterSource in = new MapSqlParameterSource()
                .addValue(SPDefuseOfficerEmploy.IN_EMPLOY_PK, defuseEmployRequest.getEmployPk())
                .addValue(SPDefuseOfficerEmploy.IN_LOGIN_EMPLOY_PK, loginEmployPK);

        Map<String, Object> result = sPDefuseOfficerEmploy.execute(in);
        String status = (String) result.get(SPDefuseOfficerEmploy.OUT_STATUS);

        if (!SPCodeEnum.RESULT_OK.isCode(status))
        {
            throw new RulesException(status);
        }
    }

    @Override
    public List<LoadAllEmployByRole> loadAllSupervisorForDefuse(LoadEmployRequest loadEmployRequest, Long loginEmployPK)
    {

        SqlParameterSource in = new MapSqlParameterSource()
                .addValue(SPLoadAllSupervisorForDefuse.IN_EMPLOY_PK, loadEmployRequest.getEmployPk())
                .addValue(SPLoadAllSupervisorForDefuse.IN_LOGIN_EMPLOY_PK, loginEmployPK);

        Map<String, Object> result = sPLoadAllSupervisorForDefuse.execute(in);
        List<LoadAllEmployByRole> employ = (List<LoadAllEmployByRole>) result
                .get(SPLoadAllSupervisorForDefuse.OUT_CURSOR);
        String status = (String) result.get(SPLoadAllSupervisorForDefuse.OUT_STATUS);

        if (!SPCodeEnum.RESULT_OK.isCode(status))
        {
            throw new RulesException(status);
        }
        else
        {
            if (employ.isEmpty())
            {
                defuseSupervisorEmploy(loadEmployRequest.getEmployPk(), loginEmployPK);
            }
        }
        return employ;
    }

    @Override
    public void changeSupervisor(DefuseSupervisorRequest defuseSupervisorRequest, Long loginEmployPK)
    {

        SqlParameterSource in = new MapSqlParameterSource()
                .addValue(SPChangeSupervisor.IN_EMPLOY_PK, defuseSupervisorRequest.getEmployPK())
               .addValue(SPChangeSupervisor.IN_SUPER_EMPLOY_PK, defuseSupervisorRequest.getSuperEmployPK())
                .addValue(SPChangeSupervisor.IN_LOGIN_EMPLOY_PK, loginEmployPK);

        Map<String, Object> result = sPChangeSupervisor.execute(in);
        String status = (String) result.get(SPChangeSupervisor.OUT_STATUS);

        if (!SPCodeEnum.RESULT_OK.isCode(status))
        {
            throw new RulesException(status);
        }
        else
        {
            defuseSupervisorEmploy(defuseSupervisorRequest.getEmployPK(), loginEmployPK);
        }
    }

    @Override
    public void defuseSupervisorEmploy(Long employPK, Long loginEmployPK)
    {

        SqlParameterSource in = new MapSqlParameterSource().addValue(SPDefuseSupervisorEmploy.IN_EMPLOY_PK, employPK)
                .addValue(SPDefuseSupervisorEmploy.IN_LOGIN_EMPLOY_PK, loginEmployPK);

        Map<String, Object> result = sPDefuseSupervisorEmploy.execute(in);
        String status = (String) result.get(SPDefuseSupervisorEmploy.OUT_STATUS);

        if (!SPCodeEnum.RESULT_OK.isCode(status))
        {
            throw new RulesException(status);
        }
    }

    @Override
    public void defuseAdminBusinessEmploy(DefuseEmployRequest defuseEmployRequest, Long loginEmployPK)
    {

        SqlParameterSource in = new MapSqlParameterSource()
                .addValue(SPDefuseAdminBusinessEmploy.IN_EMPLOY_PK, defuseEmployRequest.getEmployPk())
                .addValue(SPDefuseAdminBusinessEmploy.IN_LOGIN_EMPLOY_PK, loginEmployPK);

        Map<String, Object> result = sPDefuseAdminBusinessEmploy.execute(in);
        String status = (String) result.get(SPDefuseAdminBusinessEmploy.OUT_STATUS);

        if (!SPCodeEnum.RESULT_OK.isCode(status))
        {
            throw new RulesException(status);
        }
    }
}
