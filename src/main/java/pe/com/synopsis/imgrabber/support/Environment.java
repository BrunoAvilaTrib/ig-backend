
package pe.com.synopsis.imgrabber.support;

public enum Environment
{

    WEB("W", "001"), MOBILE("M", "002");

    private String key;
    private String code;

    Environment(String key, String code)
    {
        this.key = key;
        this.code = code;
    }

    public String key()
    {
        return key;
    }

    public String code()
    {
        return code;
    }

}
