
package pe.com.synopsis.imgrabber.dao.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Component;

import pe.com.synopsis.imgrabber.beans.domain.LoadAllArea;
import pe.com.synopsis.imgrabber.beans.domain.LoadAllAreaByRole;
import pe.com.synopsis.imgrabber.beans.domain.LoadArea;
import pe.com.synopsis.imgrabber.beans.request.AddAreaRequest;
import pe.com.synopsis.imgrabber.beans.request.DefuseAreaRequest;
import pe.com.synopsis.imgrabber.beans.request.LoadAreaRequest;
import pe.com.synopsis.imgrabber.beans.request.UpdateAreaRequest;
import pe.com.synopsis.imgrabber.dao.AreaDAO;
import pe.com.synopsis.imgrabber.dao.sp.SPAddArea;
import pe.com.synopsis.imgrabber.dao.sp.SPDefuseArea;
import pe.com.synopsis.imgrabber.dao.sp.SPLoadAllArea;
import pe.com.synopsis.imgrabber.dao.sp.SPLoadAllAreaByRole;
import pe.com.synopsis.imgrabber.dao.sp.SPLoadArea;
import pe.com.synopsis.imgrabber.dao.sp.SPUpdateArea;
import pe.com.synopsis.imgrabber.enumeration.SPCodeEnum;
import pe.com.synopsis.imgrabber.exception.RulesException;

@Component
@SuppressWarnings("unchecked")
public class AreaDAOImpl implements AreaDAO
{

    @Autowired
    private SPUpdateArea sPUpdateArea;

    @Autowired
    private SPAddArea sPAddArea;

    @Autowired
    private SPDefuseArea sPDefuseArea;

    @Autowired
    private SPLoadAllArea sPLoadAllArea;

    @Autowired
    private SPLoadArea sPLoadArea;

    @Autowired
    private SPLoadAllAreaByRole sPLoadAllAreaByRole;

    @Override
    public void updateArea(UpdateAreaRequest updateAreaRequest)
    {
        SqlParameterSource in = new MapSqlParameterSource()
                .addValue(SPUpdateArea.IN_AREA_PK, updateAreaRequest.getAreaPk())
                .addValue(SPUpdateArea.IN_AREA_NAME, updateAreaRequest.getAreaName())
                .addValue(SPUpdateArea.IN_AREA_COMMENT, updateAreaRequest.getAreaComment())
                .addValue(SPUpdateArea.IN_AREA_SUPPORT, updateAreaRequest.getAreaSupport());

        Map<String, Object> result = sPUpdateArea.execute(in);
        String status = (String) result.get(SPUpdateArea.OUT_STATUS);
        if (!SPCodeEnum.RESULT_OK.isCode(status))
        {
            throw new RulesException(status);
        }
    }

    @Override
    public void addArea(AddAreaRequest addAreaRequest)
    {
        SqlParameterSource in = new MapSqlParameterSource()
                .addValue(SPAddArea.IN_AREA_NAME, addAreaRequest.getAreaName())
                .addValue(SPAddArea.IN_AREA_COMMENT, addAreaRequest.getAreaComment())
                .addValue(SPAddArea.IN_BUSINESS_FK, addAreaRequest.getBusinessFK());

        Map<String, Object> result = sPAddArea.execute(in);
        String status = (String) result.get(SPAddArea.OUT_STATUS);

        if (!SPCodeEnum.RESULT_OK.isCode(status))
        {
            throw new RulesException(status);
        }
    }

    @Override
    public void defuseArea(DefuseAreaRequest defuseAreaRequest)
    {
        SqlParameterSource in = new MapSqlParameterSource().addValue(SPDefuseArea.IN_AREA_PK,
                defuseAreaRequest.getAreaPk());

        Map<String, Object> result = sPDefuseArea.execute(in);
        String status = (String) result.get(SPDefuseArea.OUT_STATUS);

        if (!SPCodeEnum.RESULT_OK.isCode(status))
        {
            throw new RulesException(status);
        }
    }

    @Override
    public List<LoadAllArea> loadAllArea(Long loginEmployFK)
    {
        SqlParameterSource in = new MapSqlParameterSource().addValue(SPLoadAllArea.IN_LOGIN_EMPLOY_PK, loginEmployFK);

        Map<String, Object> result = sPLoadAllArea.execute(in);
        String status = (String) result.get(SPLoadAllArea.OUT_STATUS);

        if (!SPCodeEnum.RESULT_OK.isCode(status))
        {
            throw new RulesException(status);
        }

        List<LoadAllArea> areas = (List<LoadAllArea>) result.get(SPLoadAllArea.OUT_CURSOR);
        return areas;
    }

    @Override
    public List<LoadAllAreaByRole> loadAllAreaByRole(Long loginEmployFK)
    {
        SqlParameterSource in = new MapSqlParameterSource().addValue(SPLoadAllAreaByRole.IN_LOGIN_EMPLOY_PK,
                loginEmployFK);

        Map<String, Object> result = sPLoadAllAreaByRole.execute(in);
        String status = (String) result.get(SPLoadAllAreaByRole.OUT_STATUS);

        if (!SPCodeEnum.RESULT_OK.isCode(status))
        {
            throw new RulesException(status);
        }

        List<LoadAllAreaByRole> areas = (List<LoadAllAreaByRole>) result.get(SPLoadAllAreaByRole.OUT_CURSOR);
        return areas;
    }

    @Override
    public List<LoadArea> loadArea(LoadAreaRequest loadAreaRequest)
    {
        SqlParameterSource in = new MapSqlParameterSource().addValue(SPLoadArea.IN_AREA_PK,
                loadAreaRequest.getAreaPk());

        Map<String, Object> result = sPLoadArea.execute(in);
        String status = (String) result.get(SPLoadArea.OUT_STATUS);

        if (!SPCodeEnum.RESULT_OK.isCode(status))
        {
            throw new RulesException(status);
        }

        List<LoadArea> areas = (List<LoadArea>) result.get(SPLoadArea.OUT_CURSOR);
        return areas;
    }
}
