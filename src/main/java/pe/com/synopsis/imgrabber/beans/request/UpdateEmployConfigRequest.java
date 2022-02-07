/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pe.com.synopsis.imgrabber.beans.request;

import java.io.Serializable;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

/**
 *
 * @author synopsis
 */
public class UpdateEmployConfigRequest implements Serializable
{
    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    @NotNull
    private Long configPk;
    @NotNull
    private Long employPk;
    @NotNull
    @Pattern(regexp = "^[AB]{1,1}+$")
    private String state;

    public Long getConfigPk()
    {
        return configPk;
    }

    public void setConfigPk(Long configPk)
    {
        this.configPk = configPk;
    }

    public Long getEmployPk()
    {
        return employPk;
    }

    public void setEmployPk(Long employPk)
    {
        this.employPk = employPk;
    }

    public String getState()
    {
        return state;
    }

    public void setState(String state)
    {
        this.state = state;
    }

}
