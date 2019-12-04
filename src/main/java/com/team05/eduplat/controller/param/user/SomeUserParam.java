package com.team05.eduplat.controller.param.user;

import lombok.Data;

/**
 * @program: eduplat
 * @description: TODO
 * @author: chen wenliang
 * @Date 2019/11/29
 **/
@Data
public class SomeUserParam {
    private String username;
    private String nickname;
    private int gender;
    //    private String photo;
    private String phone;
    private String address;
    private String remark;
}
