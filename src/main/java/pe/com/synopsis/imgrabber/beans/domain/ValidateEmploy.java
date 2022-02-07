
package pe.com.synopsis.imgrabber.beans.domain;

import java.util.List;

import lombok.Data;

@Data
public class ValidateEmploy
{

    private Long employPk;
    private String email;
    private String password;
    private Boolean accountNonLocked;
    private List<LoadRole> credentialsNonExpired;
    private String isGlobalAdmin;
    private String nameEmploy;
    private String sex;

}
