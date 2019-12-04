package com.team05.eduplat.utils.user;

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;

/**
 * @program: test
 * @description: 验证邮箱账号和授权码
 * @author: chen wenliang
 * @Date 2019/11/19
 **/
public class VerifyEmailAuthentication extends Authenticator {
    //账号
    private String userName;
    //密码
    private String password;

    public String getUserName() {
        return userName;
    }
    public void setUserName(String userName) {
        this.userName = userName;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    //构造方法
    public VerifyEmailAuthentication(){
        super();

    }
    public VerifyEmailAuthentication(String userName, String password) {
        super();
        this.userName = userName;
        this.password = password;
    }
    protected PasswordAuthentication getPasswordAuthentication(){
        return new PasswordAuthentication(userName, password);
    }
}
