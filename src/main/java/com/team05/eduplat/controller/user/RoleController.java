package com.team05.eduplat.controller.user;

import com.team05.eduplat.controller.param.user.AddRoleParam;
import com.team05.eduplat.service.user.RoleService;
import com.team05.eduplat.utils.Result.ResultMessage;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;


/**
 * @program: eduplat
 * @description: TODO
 * @author: chen wenliang
 * @Date 2019/11/28
 **/
@RestController
public class RoleController {
    @Autowired
    private RoleService roleService;
    //增加角色
    @ApiOperation("增加角色")
    @PostMapping("/addRole")
    public ResultMessage addRole(@RequestBody AddRoleParam param, HttpServletRequest request) throws Exception{
        return roleService.addRole("ROLE_"+param.getRolename(),param.getNamezh());
    }

    //删除角色
    @ApiOperation("删除角色")
    @PostMapping("/deleteRole")
    public ResultMessage deleteRole(@RequestBody long id) throws Exception{
        return roleService.deleteRole(id);
    }
    //查询角色
    @ApiOperation("查询角色")
    @PostMapping("/getRoles")
    public ResultMessage getRoles() throws Exception{
        return roleService.queryRole();
    }
}
