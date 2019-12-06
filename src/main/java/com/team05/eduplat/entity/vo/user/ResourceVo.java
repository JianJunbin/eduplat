package com.team05.eduplat.entity.vo.user;

import com.team05.eduplat.entity.po.user.ResourcePo;
import com.team05.eduplat.entity.po.user.RolePo;
import lombok.Data;
import lombok.NonNull;

import java.util.List;

/**
 * @program: eduplat
 * @description: TODO
 * @author: chen wenliang
 * @Date 2019/11/22
 **/
@Data
public class ResourceVo {
    private long id;
    private String path;
    private String url;//访问路径
    private String component;
    private String resourcename;
    private String requireauth;
    private long parentId;
    private ResourceVo children;
}
