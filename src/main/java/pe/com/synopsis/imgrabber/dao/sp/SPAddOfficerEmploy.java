
package pe.com.synopsis.imgrabber.dao.sp;

import java.sql.Types;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.SqlOutParameter;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.stereotype.Component;

@Component
public class SPAddOfficerEmploy extends CPStoredProcedure
{

    private static final String SP_NAME = "P_ADD_OFFICER_EMPLOY";
    public static final String OUT_STATUS = "@saltStatus";
    public static final String OUT_EMPLOY_PK = "@outEmployPK";
    public static final String IN_NAME = "@inName";
    public static final String IN_APPAT = "@inApePat";
    public static final String IN_APMAT = "@inApeMat";
    public static final String IN_EMAIL = "@inEmail";
    public static final String IN_PASSWORD = "@inPassword";
    public static final String IN_GENDER = "@inGender";
    public static final String IN_MOBILE = "@inMobile";
    public static final String IN_BUSINESS_FK = "@inBusinessFk";
    public static final String IN_ROLE_FK = "@inRoleFk";
    public static final String IN_AREA_FK = "@inAreaFk";
    public static final String IN_SUPERVISOR_FK = "@inSupervisorFk";
    public static final String IN_PRIVILEGE_STATE = "@inPrivilegeState";
    public static final String IN_LOGIN_EMPLOY_PK = "@inLoginEmployPK";

    @Autowired
    public SPAddOfficerEmploy(JdbcTemplate jdbcTemplate)
    {
        super(jdbcTemplate, SP_NAME);
    }

    @Override
    public void configSP()
    {
        getSimpleJdbcCall()
                .useInParameterNames(IN_NAME, IN_APPAT, IN_APMAT, IN_EMAIL, IN_PASSWORD, IN_GENDER, IN_MOBILE,
                        IN_BUSINESS_FK, IN_ROLE_FK, IN_AREA_FK, IN_SUPERVISOR_FK, IN_PRIVILEGE_STATE,
                        IN_LOGIN_EMPLOY_PK)
                .declareParameters(new SqlOutParameter(OUT_STATUS, Types.VARCHAR),
                        new SqlOutParameter(OUT_EMPLOY_PK, Types.VARCHAR), new SqlParameter(IN_NAME, Types.VARCHAR),
                        new SqlParameter(IN_APPAT, Types.VARCHAR), new SqlParameter(IN_APMAT, Types.VARCHAR),
                        new SqlParameter(IN_EMAIL, Types.VARCHAR), new SqlParameter(IN_PASSWORD, Types.VARCHAR),
                        new SqlParameter(IN_GENDER, Types.VARCHAR), new SqlParameter(IN_MOBILE, Types.VARCHAR),
                        new SqlParameter(IN_BUSINESS_FK, Types.BIGINT), new SqlParameter(IN_ROLE_FK, Types.BIGINT),
                        new SqlParameter(IN_AREA_FK, Types.BIGINT), new SqlParameter(IN_SUPERVISOR_FK, Types.BIGINT),
                        new SqlParameter(IN_PRIVILEGE_STATE, Types.VARCHAR),
                        new SqlParameter(IN_LOGIN_EMPLOY_PK, Types.BIGINT));
    }

}