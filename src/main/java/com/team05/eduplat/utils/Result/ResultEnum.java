package com.team05.eduplat.utils.Result;


/**
 * @program: gdouStadium
 * @description:
 * @author: $(USER)
 * @create: $(TIME)
 **/
public enum ResultEnum implements ResultInfo {
    METHOD_ERROR(-1, "METHOD ERROR"),
    SERVER_ERROR(0, "ERROR"),
    SUCCESS(1, "SUCCESS"),
    PARAM_ERROR(2, "PARAM ERROR"),
    NO_AUTH(3, "NO AUTH"),
    INTERFACE_ERROR(4, "INTERFACE ERROR"),
    PASSWORD_ERROR(101, "PASSWORD ERROR"),
    LOCKUP_USER(102, "LOCKUP USER"),
    PHONE_EXIST(103, "PHONE EXIST"),
    USERNAME_EXIST(104, "USERNAME EXIST"),
    USERNAME_NOT_FOUND(105, "USERNAME NOT FOUND"),
    DISABLE_USER(106, "DISABLE USER");

    private Integer code;
    private String msg;

    private ResultEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Integer getCode() {
        return this.code;
    }

    public String getMsg() {
        return this.msg;
    }
}
