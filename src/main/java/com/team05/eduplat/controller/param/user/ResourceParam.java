package com.team05.eduplat.controller.param.user;

import lombok.Data;

/**
 * @program: eduplat
 * @description: TODO
 * @author: chen wenliang
 * @Date 2019/11/22
 **/
@Data
public class ResourceParam {
    private long id;
    private String path;
    private String url;//访问路径
    private String icon;
    private String component;
    private String resourcename;
    //    private String requireauth;
    private long parent;
    private long roleId;
}
