package com.team05.eduplat.service.user;

import com.team05.eduplat.controller.param.CategoryParam;
import com.team05.eduplat.controller.param.user.RegisterUserParam;
import com.team05.eduplat.controller.param.user.SomeUserParam;
import com.team05.eduplat.entity.po.user.RolePo;
import com.team05.eduplat.entity.po.user.UserPo;
import com.team05.eduplat.entity.po.user.UserRolePo;
import com.team05.eduplat.entity.vo.PageinfoVo;
import com.team05.eduplat.entity.vo.user.RoleVo;
import com.team05.eduplat.entity.vo.user.UserVo;
import com.team05.eduplat.repository.user.UserDao;
import com.team05.eduplat.repository.user.UserRoleDao;
import com.team05.eduplat.utils.PageHelper;
import com.team05.eduplat.utils.Result.ResultEnum;
import com.team05.eduplat.utils.Result.ResultHelper;
import com.team05.eduplat.utils.Result.ResultMessage;
import com.team05.eduplat.utils.user.UserUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


/**
 * @program: eduplat
 * @description: 用户业务逻辑
 * @author: chen wenliang
 * @Date 2019/11/12
 **/
@Service
@Transactional
public class UserService implements UserDetailsService {
    @Autowired
    private UserDao userDao;
    @Autowired
    private UserRoleDao userRoleDao;

    public ResultMessage getUsers(CategoryParam categoryParam){
        //获取页面信息
        PageinfoVo pageinfoVo = categoryParam.getPageinfoVo();
        //根据页面信息查询数据
        Page<UserPo> userPos=userDao.findAll(PageHelper.initPage(pageinfoVo));
        List<UserVo> userVos = new ArrayList<>();
        userPos.forEach(e ->{
            UserVo userVo = new UserVo();
            BeanUtils.copyProperties(e,userVo);
            userVos.add(userVo);
        });
        return ResultHelper.result(ResultEnum.SUCCESS).put("users",userVos);
    }
    //注册
    public ResultMessage registerUser(RegisterUserParam registerUserParam){
        if (userDao.findByUsername(registerUserParam.getUsername())!=null){
            return ResultHelper.result(ResultEnum.USERNAME_EXIST).setMsg("该用户名已存在");
        }
        if (userDao.findByMail(registerUserParam.getMail())!=null){
            return ResultHelper.result(ResultEnum.EMAIL_EXIST).setMsg("该邮箱已注册");
        }
        UserPo userPo=new UserPo();
        userPo.setUsername(registerUserParam.getUsername());
        userPo.setPassword(UserUtil.passwordEcode(registerUserParam.getPassword()));
        userPo.setMail(registerUserParam.getMail());
        //是否可用
        userPo.setEnable(1);
        //注册时间
        userPo.setRegistertime(new Date());
        UserPo userPo1 = userDao.save(userPo);
        if (userPo1==null){
            return ResultHelper.result(ResultEnum.USER_REGISTER_FAIL).setMsg("注册失败");
        }else{
            //关联角色，2为普通用户
            UserRolePo userRolePo=userToRole(userPo1.getId(),2);
            return ResultHelper.result(ResultEnum.SUCCESS).setMsg("注册成功");
        }
    }
    //登陆
    public ResultMessage loginUser(String password,String username){
        System.out.println(username);
        UserPo userPo=userDao.findByUsername(username);
        if (userPo==null){
            return ResultHelper.result(ResultEnum.USERNAME_NOT_FOUND).setMsg("用户名不存在");
        }else {
            if (UserUtil.passwordIsSame(password,userPo.getPassword())){
                return ResultHelper.result(ResultEnum.SUCCESS).put("userPo",userPo);
            }else {
                return ResultHelper.result(ResultEnum.PASSWORD_ERROR).setMsg("密码输入错误");
            }

        }
    }
    //修改密码
    public ResultMessage updatePassword(String oldPassword,String newPassword,String username){
        UserPo userPo=userDao.findByUsername(username);
        if (userPo!=null){
            if (UserUtil.passwordIsSame(oldPassword,userPo.getPassword())){
                System.out.println(username);
                userPo.setPassword(UserUtil.passwordEcode(newPassword));
                UserPo userPo1=userDao.save(userPo);
                if (userPo1!=null){
                    return ResultHelper.result(ResultEnum.SUCCESS).setMsg("修改密码成功");
                }else {
                    return ResultHelper.result(ResultEnum.FAIL).setMsg("修改密码失败");
                }
            }else {
                return ResultHelper.result(ResultEnum.FAIL).setMsg("旧密码输入错误");
            }

        }else {
            return ResultHelper.result(ResultEnum.USERNAME_NOT_FOUND).setMsg("用户名不存在");
        }
    }
    //忘记密码
    public ResultMessage forgetPassword(String newPassword,String username){
        UserPo userPo=userDao.findByUsername(username);
        if (userPo!=null){
                userPo.setPassword(UserUtil.passwordEcode(newPassword));
                UserPo userPo1=userDao.save(userPo);
                if (userPo1!=null){
                    return ResultHelper.result(ResultEnum.SUCCESS).setMsg("修改密码成功");
                }else {
                    return ResultHelper.result(ResultEnum.FAIL).setMsg("修改密码失败");
                }
        }else {
            return ResultHelper.result(ResultEnum.USERNAME_NOT_FOUND).setMsg("用户名不存在");
        }
    }
    //禁用用户
    public ResultMessage disableUser(int disable,String username){
        UserPo userPo=userDao.findByUsername(username);
        if (userPo!=null){
            userPo.setEnable(disable);
            UserPo userPo1=userDao.save(userPo);
            if (userPo1!=null){
                return ResultHelper.result(ResultEnum.SUCCESS).setMsg("禁用成功");
            }else {
                return ResultHelper.result(ResultEnum.FAIL).setMsg("禁用失败");
            }
        }else {
            return ResultHelper.result(ResultEnum.USERNAME_NOT_FOUND).setMsg("用户名不存在");
        }
    }
    //修改部分用户个人信息
    public ResultMessage updateUser(SomeUserParam someUserParam){
        UserPo userPo=userDao.findByUsername(someUserParam.getUsername());
        if (userPo!=null){
            if (someUserParam.getGender()==0||someUserParam.getGender()==1){
                userPo.setGender(someUserParam.getGender());
            }
            if (!someUserParam.getNickname().equals("")){
                userPo.setNickname(someUserParam.getNickname());
            }
            if (!someUserParam.getAddress().equals("")){
                userPo.setAddress(someUserParam.getAddress());
            }
            if (!someUserParam.getPhone().equals("")){
                userPo.setPhone(someUserParam.getPhone());
            }
            if (!someUserParam.getRemark().equals("")){
                userPo.setRemark(someUserParam.getRemark());
            }
            UserPo userPo1=userDao.save(userPo);
            if (userPo1!=null){
                return ResultHelper.result(ResultEnum.SUCCESS).setMsg("修改成功");
            }else {
                return ResultHelper.result(ResultEnum.FAIL).setMsg("修改失败");
            }
        }else {
            return ResultHelper.result(ResultEnum.USERNAME_NOT_FOUND).setMsg("用户名不存在");
        }
    }
    //修改邮箱
    public ResultMessage updateEmail(String oldEmail,String newEmail,String username){
        UserPo userPo=userDao.findByUsername(username);
        if (userPo!=null){
           if (oldEmail.equals(userPo.getMail())){
               userPo.setMail(newEmail);
               UserPo userPo1=userDao.save(userPo);
               if (userPo1==null){
                   return ResultHelper.result(ResultEnum.FAIL).setMsg("修改邮箱失败");
               }
               return ResultHelper.result(ResultEnum.SUCCESS).setMsg("修改邮箱成功");
           }else {
               return ResultHelper.result(ResultEnum.FAIL).setMsg("请输入该用户绑定的邮箱");
           }
        }else {
            return ResultHelper.result(ResultEnum.USERNAME_NOT_FOUND).setMsg("用户名不存在");
        }
    }
    //关联用户角色
    public UserRolePo userToRole(long userId, long roleId){
        UserRolePo userRolePo=new UserRolePo();
        userRolePo.setU_id(userId);
        userRolePo.setR_id(roleId);
        return userRoleDao.save(userRolePo);
    }
    public ResultMessage getUserByUsername(String username){
        UserPo userPo=userDao.findByUsername(username);

        if (userPo==null){
            return ResultHelper.result(ResultEnum.FAIL).setMsg("失败");
        }else {
            UserVo userVo=new UserVo();
            userVo.setId(userPo.getId());
            userVo.setUsername(userPo.getUsername());
            userVo.setNickname(userPo.getNickname());
            userVo.setGender(userPo.getGender());
            userVo.setMail(userPo.getMail());
            List<RoleVo> roleVos=new ArrayList<>();
            if (userPo.getRoles().size()>0){
                for (int i=0;i<userPo.getRoles().size();i++){
                    RolePo rolePo=userPo.getRoles().get(i);
                    RoleVo roleVo=new RoleVo();
                    roleVo.setId(rolePo.getId());
                    roleVo.setRolename(rolePo.getRolename());
                    roleVo.setNamezh(rolePo.getNamezh());
                    roleVos.add(roleVo);
                }

            }
            userVo.setRoles(roleVos);
            return ResultHelper.result(ResultEnum.SUCCESS).put("user",userVo);
        }
    }
    public ResultMessage addRoleToUser(long userId,long roleId){
        UserRolePo userRolePo=new UserRolePo();
        userRolePo.setU_id(userId);
        userRolePo.setR_id(roleId);
        userRoleDao.save(userRolePo);
        return ResultHelper.result(ResultEnum.SUCCESS).setMsg("成功");
    }
    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        UserPo user=userDao.findByUsername(s);
        if (user==null){
            throw new UsernameNotFoundException("用户不存在");
        }
        return user;
    }

}
