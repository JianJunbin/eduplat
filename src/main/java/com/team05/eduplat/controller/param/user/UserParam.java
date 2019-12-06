package com.team05.eduplat.controller.param.user;

import lombok.Data;

/**
 * @program: eduplat
 * @description: 用于登陆、注册的
 * @author: chen wenliang
 * @Date 2019/11/25
 **/
@Data
public class UserParam {
    private String username;
    private String password;
    private String code;
}
