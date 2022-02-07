
package pe.com.synopsis.imgrabber.enumeration;

import pe.com.synopsis.imgrabber.beans.response.Status;

public enum SPCodeEnum
{
    RESULT_OK("0000", "Procesado exitosamente."), LOGIN_ATTEMPT("0001", "Intento fallido de login."), USER_NOT_EXIST(
            "0002", "Usuario no existe."), USER_MAX_ATTEMPT("0003",
                    "El usuario ah supera el limite de intentos."), USER_LOCKOUT("0004",
                            "El usuario se encuentra bloqueado."), LOGER_DESBLOCK("0005",
                                    "desbloqueo exitoso"), RUC_AND_NAME_IN_USE("0006",
                                            "El nombre y el ruc se encuentran en uso"), EMAIL_AND_NAME_IN_USE("0007",
                                                    "El nombre y el email se encuentran en uso"), RUC_IN_USE("0008",
                                                            "El ruc ya en uso"), BUSINESS_NAME_IN_USE("0009",
                                                                    "El nombre ya se encuentran en uso"), AREA_NAME_IN_USE(
                                                                            "0010",
                                                                            "El nombre del area ya se encuentra en uso"), NUMBER_IN_USE(
                                                                                    "0011",
                                                                                    "numero ya en uso"), EMAIL_AND_RUC_IN_USE(
                                                                                            "0012",
                                                                                            "El ruc y el email se encuentran en uso"), EMAIL_AND_RUC_AND_NAME_IN_USE(
                                                                                                    "0013",
                                                                                                    "El ruc, email y ruc se encuentran en uso"), EMAIL_NOT_EXIST(
                                                                                                            "0014",
                                                                                                            "Email no existe"), MOBILE_AND_EMAIL_IN_USE(
                                                                                                                    "0023",
                                                                                                                    "telefono y email ya en uso"), PHONE_IN_USE(
                                                                                                                            "0026",
                                                                                                                            "telfono ya en uso"), EMAIL_IN_USE(
                                                                                                                                    "0027",
                                                                                                                                    "Email ya en uso"), AREA_WITH_CHATS(
                                                                                                                                            "0028",
                                                                                                                                            "El area cuenta con chats no atendidos"), AREA_WITH_EMPLOY(
                                                                                                                                                    "0029",
                                                                                                                                                    "El area cuenta con empleados"), NO_SERVICE_AREA(
                                                                                                                                                            "0030",
                                                                                                                                                            "El area no cuenta con servicios en estos momentos"), EMAIL_AND_MOBILE_IN_USE(
                                                                                                                                                                    "0041",
                                                                                                                                                                    "email y telefono en uso"), EMAI_IN_USE(
                                                                                                                                                                            "0042",
                                                                                                                                                                            "telefono  ya esta en uso"), MOBILE_IN_USE(
                                                                                                                                                                                    "0043",
                                                                                                                                                                                    "email en uso"), NOT_CHANGE_OFFICER(
                                                                                                                                                                                            "0044",
                                                                                                                                                                                            "Supervisor cuenta con operadores a su cargo"), OPERATOR_WITH_CHATS(
                                                                                                                                                                                                    "0060",
                                                                                                                                                                                                    "el operador tiene chats asignados"), ONLY_ONE_SUPERVISOR(
                                                                                                                                                                                                            "0061",
                                                                                                                                                                                                            "Empresa solo cuenta con 1 supervisor de area"), MAX_BUSINESS_ADMINISTRATOR(
                                                                                                                                                                                                                    "0062",
                                                                                                                                                                                                                    "Cantidad maxima de administradores por empresa es 2"), EXCLUDED_PHONE(
                                                                                                                                                                                                                            "0063",
                                                                                                                                                                                                                            "El telefono ya fue excluido"), EMPLOY_IN_USE(
                                                                                                                                                                                                                                    "0064",
                                                                                                                                                                                                                                    "El empleado ya fue asignado"), EMPLOYEE_ON_VACATION(
                                                                                                                                                                                                                                            "0065",
                                                                                                                                                                                                                                            "El empleado se encuentra de vacaciones"), INCORRECT_BUSINESS_EMAIL(
                                                                                                                                                                                                                                                    "0066",
                                                                                                                                                                                                                                                    "El correo no corresponde a la empresa"), CHAT_ALREADY_ASSIGNED(
                                                                                                                                                                                                                                                            "0067",
                                                                                                                                                                                                                                                            "El chat ya fue asignado"), INACTIVE_BUSINESS(
                                                                                                                                                                                                                                                                    "0068",
                                                                                                                                                                                                                                                                    "Empresa inactiva"), ONLY_ONE_ADMIN_BUSINESS(
                                                                                                                                                                                                                                                                            "0069",
                                                                                                                                                                                                                                                                            "Empresa solo cuenta con 1 administrador"), INCORRECT_ROL(
                                                                                                                                                                                                                                                                                    "0070",
                                                                                                                                                                                                                                                                                    "Empleado no tiene permiso para realizar este proceso"), ERROR_PROCESS(
                                                                                                                                                                                                                                                                                            "8888",
                                                                                                                                                                                                                                                                                            "Error en el proceso.");

    private String code;
    private String message;

    private SPCodeEnum(String code, String message)
    {
        this.code = code;
        this.message = message;
    }

    public Status create()
    {
        return new Status(this.code, this.message);
    }

    public boolean isCode(String code)
    {
        return this.code.equals(code);
    }

    public String getMessage()
    {
        return message;
    }

    public String getCode()
    {
        return code;
    }

    public static SPCodeEnum find(String code)
    {
        for (SPCodeEnum codeEnum : values())
        {
            if (codeEnum.isCode(code))
            {
                return codeEnum;
            }
        }
        return null;
    }

}
