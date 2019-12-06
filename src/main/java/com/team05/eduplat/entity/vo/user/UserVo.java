package com.team05.eduplat.entity.vo.user;

import com.team05.eduplat.entity.vo.user.RoleVo;
import lombok.Data;
import lombok.NonNull;

import java.util.Date;
import java.util.List;

/**
 * @program: eduplat
 * @description: TODO
 * @author: chen wenliang
 * @Date 2019/11/12
 **/
@Data
public class UserVo {
    private int id;
    private String username;
    private String password;
    private String nickname;
    private int gender; //1为男 ，0为女
//    private String photo;
    private String mail;
    private String phone;
    private String address;
    private Date registertime;
    private String remark;
    private int enable;
    private List<RoleVo> roles;

}
