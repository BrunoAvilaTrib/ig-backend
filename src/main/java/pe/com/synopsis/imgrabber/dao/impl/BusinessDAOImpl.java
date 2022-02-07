
package pe.com.synopsis.imgrabber.dao.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Component;

import pe.com.synopsis.imgrabber.beans.domain.LoadAllBusiness;
import pe.com.synopsis.imgrabber.beans.domain.LoadAllBusinessByRole;
import pe.com.synopsis.imgrabber.beans.domain.LoadBusiness;
import pe.com.synopsis.imgrabber.beans.request.AddBusinessRequest;
import pe.com.synopsis.imgrabber.beans.request.LoadBusinessRequest;
import pe.com.synopsis.imgrabber.beans.request.UpdateBusinessRequest;
import pe.com.synopsis.imgrabber.dao.BusinessDAO;
import pe.com.synopsis.imgrabber.dao.sp.SPAddBusiness;
import pe.com.synopsis.imgrabber.dao.sp.SPLoadAllBusiness;
import pe.com.synopsis.imgrabber.dao.sp.SPLoadAllBusinessByRole;
import pe.com.synopsis.imgrabber.dao.sp.SPLoadBusiness;
import pe.com.synopsis.imgrabber.dao.sp.SPLoadBusinessLogin;
import pe.com.synopsis.imgrabber.dao.sp.SPUpdateBusiness;
import pe.com.synopsis.imgrabber.enumeration.SPCodeEnum;
import pe.com.synopsis.imgrabber.exception.RulesException;

@Component
@SuppressWarnings({ "unchecked" })
public class BusinessDAOImpl implements BusinessDAO
{

    @Autowired
    private SPLoadBusinessLogin sPLoadBusinessLogin;

    @Autowired
    private SPLoadAllBusinessByRole sPLoadAllBusinessByRole;

    @Autowired
    private SPUpdateBusiness sPUpdateBusiness;

    @Autowired
    private SPAddBusiness sPAddBusiness;

    @Autowired
    private SPLoadAllBusiness sPLoadAllBusiness;

    @Autowired
    private SPLoadBusiness sPLoadBusiness;

    @Override
    public String getNameBusiness(String email)
    {

        SqlParameterSource in = new MapSqlParameterSource().addValue(SPLoadBusinessLogin.IN_LOGIN_EMAIL, email);

        Map<String, Object> result = sPLoadBusinessLogin.execute(in);
        String status = (String) result.get(SPLoadBusinessLogin.OUT_STATUS);

        if (!SPCodeEnum.RESULT_OK.isCode(status))
        {
            throw new RulesException(status);
        }

        String nameBusiness = result.get(SPLoadBusinessLogin.OUT_NAME_BUSINESS).toString();
        return nameBusiness;
    }

    @Override
    public void updateBusiness(UpdateBusinessRequest updateBusinessRequest)
    {
        SqlParameterSource in = new MapSqlParameterSource()
                .addValue(SPUpdateBusiness.IN_BUSINESS_PK, updateBusinessRequest.getBusinessPK())
                .addValue(SPUpdateBusiness.IN_NAME, updateBusinessRequest.getName())
                .addValue(SPUpdateBusiness.IN_RUC, updateBusinessRequest.getRuc())
                .addValue(SPUpdateBusiness.IN_STATE, updateBusinessRequest.getState());

        Map<String, Object> result = sPUpdateBusiness.execute(in);
        String status = (String) result.get(SPUpdateBusiness.OUT_STATUS);
        if (!SPCodeEnum.RESULT_OK.isCode(status))
        {
            throw new RulesException(status);
        }
    }

    @Override
    public void addBusiness(AddBusinessRequest addBusinessRequest)
    {
        SqlParameterSource in = new MapSqlParameterSource()
                .addValue(SPAddBusiness.IN_NAME, addBusinessRequest.getName())
                .addValue(SPAddBusiness.IN_RUC, addBusinessRequest.getRuc())
                .addValue(SPAddBusiness.IN_EMAIL, addBusinessRequest.getEmail());

        Map<String, Object> result = sPAddBusiness.execute(in);
        String status = (String) result.get(SPAddBusiness.OUT_STATUS);

        if (!SPCodeEnum.RESULT_OK.isCode(status))
        {
            throw new RulesException(status);
        }
    }

    @Override
    public List<LoadAllBusinessByRole> loadAllBusinessByRole(Long loginEmployFK)
    {

        SqlParameterSource in = new MapSqlParameterSource().addValue(SPLoadAllBusinessByRole.IN_LOGIN_EMPLOY_PK,
                loginEmployFK);

        Map<String, Object> result = sPLoadAllBusinessByRole.execute(in);
        List<LoadAllBusinessByRole> employ = (List<LoadAllBusinessByRole>) result
                .get(SPLoadAllBusinessByRole.OUT_CURSOR);
        String status = (String) result.get(SPLoadAllBusinessByRole.OUT_STATUS);

        if (!SPCodeEnum.RESULT_OK.isCode(status))
        {
            throw new RulesException(status);
        }
        return employ;
    }

    @Override
    public List<LoadAllBusiness> loadAllBusiness()
    {
        SqlParameterSource in = new MapSqlParameterSource();

        Map<String, Object> result = sPLoadAllBusiness.execute(in);
        String status = (String) result.get(SPLoadAllBusiness.OUT_STATUS);

        if (!SPCodeEnum.RESULT_OK.isCode(status))
        {
            throw new RulesException(status);
        }

        List<LoadAllBusiness> loadAllBusiness = (List<LoadAllBusiness>) result.get(SPLoadAllBusiness.OUT_CURSOR);
        return loadAllBusiness;
    }

    @Override
    public List<LoadBusiness> loadBusiness(LoadBusinessRequest loadBusinessRequest)
    {
        SqlParameterSource in = new MapSqlParameterSource().addValue(SPLoadBusiness.IN_BUSINESS_PK,
                loadBusinessRequest.getBusinessPK());

        Map<String, Object> result = sPLoadBusiness.execute(in);
        String status = (String) result.get(SPLoadBusiness.OUT_STATUS);

        if (!SPCodeEnum.RESULT_OK.isCode(status))
        {
            throw new RulesException(status);
        }

        List<LoadBusiness> loadBusiness = (List<LoadBusiness>) result.get(SPLoadBusiness.OUT_CURSOR);
        return loadBusiness;
    }

}
