package com.team05.eduplat.controller.user;

import com.team05.eduplat.controller.param.*;
import com.team05.eduplat.controller.param.user.*;
import com.team05.eduplat.service.user.UserService;
import com.team05.eduplat.utils.Result.ParamCheckUtil;
import com.team05.eduplat.utils.Result.ResultEnum;
import com.team05.eduplat.utils.Result.ResultHelper;
import com.team05.eduplat.utils.Result.ResultMessage;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * @program: eduplat
 * @description: TODO
 * @author: chen wenliang
 * @Date 2019/11/12
 **/
@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @ApiOperation("分页查询所有用户")
    @PostMapping("/getUsers")
    public ResultMessage getUsers(@RequestBody @Validated CategoryParam categoryParam, BindingResult errors) throws Exception{
        ResultMessage resultMessage = ParamCheckUtil.checkParam(errors);
        if (resultMessage != null) return resultMessage;
        return userService.getUsers(categoryParam);
    }
    @ApiOperation("根据用户名查询用户")
    @PostMapping("/getUserByUsername")
        public ResultMessage getUserByUsername(@RequestBody @Validated String username) throws Exception{
        System.out.println(username);
        return userService.getUserByUsername(username.replace("\"","").trim());
    }
    @ApiOperation("用户注册")
    @PostMapping("/registerUser")
    public ResultMessage registerUser(@RequestBody @Validated RegisterUserParam registerUserParam, BindingResult errors, HttpServletRequest request) throws Exception{
        ResultMessage resultMessage = ParamCheckUtil.checkParam(errors);
        if (resultMessage != null) return resultMessage;
        return userService.registerUser(registerUserParam);

    }
    @ApiOperation("用户登陆")
    @PostMapping("/loginUser")
    public ResultMessage loginUser(@RequestBody @Validated UserParam userParam) throws Exception {
        System.out.print(userParam.getPassword()+"::"+userParam.getUsername());
        return userService.loginUser(userParam.getPassword(),userParam.getUsername());
    }

    @ApiOperation("修改密码")
    @PostMapping("/updatePassword")
    public ResultMessage updatePassword(@RequestBody @Validated ChangePasswordParam changePasswordParam) throws Exception{

            return userService.updatePassword(changePasswordParam.getOldPassword(),changePasswordParam.getNewPassword(),changePasswordParam.getUsername());
    }
    @ApiOperation("修改邮箱")
    @PostMapping("/updateEmail")
    public ResultMessage updateEmail(@RequestBody @Validated ChangeEmailParam changeEmailParam) throws Exception{
        return userService.updateEmail(changeEmailParam.getOldEmail(),changeEmailParam.getNewEmail(),changeEmailParam.getUsername());
    }
    @ApiOperation("修改部分用户个人信息")
    @PostMapping("/updateUser")
    public ResultMessage updateUser(@RequestBody @Validated SomeUserParam someUserParam) throws Exception{
        return userService.updateUser(someUserParam);
    }
    @ApiOperation("禁用用户,0为不可用，1为可用")
    @PostMapping("/disableUser")
    public ResultMessage disableUser(@RequestBody @Validated DisableUserParam disableUserParam) throws Exception{
        return userService.disableUser(disableUserParam.getEnable(),disableUserParam.getUsername());
    }
    @ApiOperation("忘记密码")
    @PostMapping("/forgetPassword")
    public ResultMessage forgetPassword(@RequestBody @Validated ForgetPasswordParam forgetPasswordParam, HttpServletRequest request) throws Exception{
        String sessionEmailCode=request.getSession().getAttribute("emailCode")+"";
        if (sessionEmailCode==null || forgetPasswordParam.getEmailCode()==null){
            return ResultHelper.result(ResultEnum.FAIL).setMsg("请获取验证码");
        }
        System.out.println("emailCode"+ forgetPasswordParam.getEmailCode());
        System.out.println("sessionEmailCode"+sessionEmailCode);
        if (sessionEmailCode.equals(forgetPasswordParam.getEmailCode())){
            return userService.forgetPassword(forgetPasswordParam.getNewPassword(),forgetPasswordParam.getUsername());
        }else {
            return ResultHelper.result(ResultEnum.FAIL).setMsg("验证码错误");
        }
    }
    @ApiOperation("为用户增加角色")
    @PostMapping("/addRoleToUser")
    public ResultMessage addRoleToUser(@RequestBody @Validated AddRoleToUserParam param) throws Exception{
        return userService.addRoleToUser(param.getUserId(),param.getRoleId());
    }
    @GetMapping("/loginP")
    public String loginP(){
        return "loginP";
    }
}
