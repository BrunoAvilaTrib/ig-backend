
package pe.com.synopsis.imgrabber.beans.dto;

import org.springframework.beans.BeanUtils;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import pe.com.synopsis.imgrabber.beans.domain.LoadAllExcluidCust;

@JsonInclude(Include.NON_NULL)
public class LoadAllExcluidCustDTO
{

    private Long excluidCustPK;
    private String nameOper;
    private String emailOper;
    private String phoneCust;
    private String reason;
    private String date;
    private String nameArea;
    private String sexo;

    public Long getExcluidCustPK()
    {
        return excluidCustPK;
    }

    public void setExcluidCustPK(Long excluidCustPK)
    {
        this.excluidCustPK = excluidCustPK;
    }

    public String getNameOper()
    {
        return nameOper;
    }

    public void setNameOper(String nameOper)
    {
        this.nameOper = nameOper;
    }

    public String getEmailOper()
    {
        return emailOper;
    }

    public void setEmailOper(String emailOper)
    {
        this.emailOper = emailOper;
    }

    public String getPhoneCust()
    {
        return phoneCust;
    }

    public void setPhoneCust(String phoneCust)
    {
        this.phoneCust = phoneCust;
    }

    public String getReason()
    {
        return reason;
    }

    public void setReason(String reason)
    {
        this.reason = reason;
    }

    public String getDate()
    {
        return date;
    }

    public void setDate(String date)
    {
        this.date = date;
    }

    public String getNameArea()
    {
        return nameArea;
    }

    public void setNameArea(String nameArea)
    {
        this.nameArea = nameArea;
    }

    public String getSexo()
    {
        return sexo;
    }

    public void setSexo(String sexo)
    {
        this.sexo = sexo;
    }

    public LoadAllExcluidCustDTO(LoadAllExcluidCust loadAllExcluidCust)
    {
        BeanUtils.copyProperties(loadAllExcluidCust, this);
    }
}
