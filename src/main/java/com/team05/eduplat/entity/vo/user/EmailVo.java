package com.team05.eduplat.entity.vo.user;

import lombok.Data;


/**
 * @program: eduplat
 * @description: TODO
 * @author: chen wenliang
 * @Date 2019/11/25
 **/
@Data
public class EmailVo {
    //邮箱服务器地址
    private String host;//smtp.qq.com
    //主机端口
    private Integer port;//25
    //发送者的邮箱账号
    private String userName;
    //发送者的密码
    private String password;//授权码
    //发送者的邮箱地址
    private String fromAddress;
    //接收者的邮箱地址
    private String toAddress;
    //设置邮件主题
    private String subject;
    //设置邮件内容
    private String context;
    //设置邮件类型
    private String contextType;
}
