
package pe.com.synopsis.imgrabber.exception;

import pe.com.synopsis.imgrabber.enumeration.SPCodeEnum;

public class RulesException extends RuntimeException
{

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    protected SPCodeEnum status;

    public RulesException(SPCodeEnum status, Exception ex)
    {
        super(status.getMessage(), ex);
        this.status = status;
    }

    public RulesException(SPCodeEnum status)
    {
        this(status, null);
    }

    public RulesException(String code, Exception ex)
    {
        this(SPCodeEnum.find(code), ex);
    }

    public RulesException(String code)
    {
        this(code, null);
    }

    public SPCodeEnum getStatus()
    {
        return this.status;
    }

    public String getErrorcode()
    {
        return this.status.getCode();
    }
}
