
package pe.com.synopsis.imgrabber.dao.sp;

import java.util.Map;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;

public abstract class CPStoredProcedure
{

    private SimpleJdbcCall simpleJdbcCall;

    public CPStoredProcedure(JdbcTemplate jdbcTemplate, String name)
    {
        setSimpleJdbcCall(
                new SimpleJdbcCall(jdbcTemplate).withProcedureName(name).withoutProcedureColumnMetaDataAccess());
    }

    // este excecute usa al simplejdccall de la calse padre CPStoredProcedure
    @Transactional
    public Map<String, Object> execute(SqlParameterSource parameters)
    {
        return getSimpleJdbcCall().execute(parameters);
    }

    @PostConstruct
    public abstract void configSP();

    public SimpleJdbcCall getSimpleJdbcCall()
    {
        return simpleJdbcCall;
    }

    public void setSimpleJdbcCall(SimpleJdbcCall simpleJdbcCall)
    {
        this.simpleJdbcCall = simpleJdbcCall;
    }
}
