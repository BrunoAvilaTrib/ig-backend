
package pe.com.synopsis.imgrabber.security;

import java.io.Serializable;
import java.util.List;

import com.google.gson.Gson;

import lombok.Getter;
import pe.com.synopsis.imgrabber.beans.dto.RoleDTO;

@Getter
public class UserInfo implements Serializable
{

    private static final long serialVersionUID = -4943465268794839517L;

    private final String email;
    private final Long employPk;
    private final String isGlobalAdmin;
    private final String sex;
    private final String nameEmploy;
    private final List<RoleDTO> role;

    public UserInfo(String email, Long employPk, String isGlobalAdmin, String sex, String nameEmploy,
            List<RoleDTO> role)
    {
        this.email = email;
        this.role = role;
        this.employPk = employPk;
        this.isGlobalAdmin = isGlobalAdmin;
        this.sex = sex;
        this.nameEmploy = nameEmploy;

    }

    public static UserInfo fromJson(String json)
    {
        Gson gson = new Gson();
        UserInfo userInfo = gson.fromJson(json, UserInfo.class);
        return userInfo;
    }

}
