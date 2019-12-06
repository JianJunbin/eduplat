package com.team05.eduplat.controller.user;

import com.team05.eduplat.controller.param.CategoryParam;
import com.team05.eduplat.controller.param.user.ResourceParam;
import com.team05.eduplat.entity.po.user.ResourcePo;
import com.team05.eduplat.service.user.ResourceService;
import com.team05.eduplat.utils.Result.ParamCheckUtil;
import com.team05.eduplat.utils.Result.ResultMessage;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @program: eduplat
 * @description: 权限资源控制类
 * @author: chen wenliang
 * @Date 2019/11/28
 **/
@RestController
public class ResourceController {
    @Autowired
    private ResourceService resourceService;
    //增加权限资源
    @ApiOperation("增加权限资源")
    @PostMapping("/addResource")
    public ResultMessage addResource(@RequestBody @Validated ResourceParam resourceParam, BindingResult errors) throws Exception{
        ResultMessage resultMessage = ParamCheckUtil.checkParam(errors);
        if (resultMessage != null) return resultMessage;
        return resourceService.addResource(resourceParam);
    }
    //删除权限资源
    @ApiOperation("删除权限资源")
    @PostMapping("/deleteResource")
    public ResultMessage deleteResource(@RequestBody @Validated long resourceId , BindingResult errors) throws Exception{
        ResultMessage resultMessage = ParamCheckUtil.checkParam(errors);
        if (resultMessage != null) return resultMessage;
        return resourceService.deleteResource(resourceId);
    }
    //分页查询权限资源
    @ApiOperation("分页查询所有资源")
    @PostMapping("/getResources")
    public ResultMessage getResources(@RequestBody @Validated CategoryParam categoryParam, BindingResult errors) throws Exception{
        ResultMessage resultMessage = ParamCheckUtil.checkParam(errors);
        if (resultMessage != null) return resultMessage;
        return resourceService.queryResource(categoryParam);
    }
    @ApiOperation("查询所有资源")
    @PostMapping("/getResourceList")
    public List<ResourcePo> getResourceList() throws Exception{
        return resourceService.findAll();
    }
    //根据角色查询权限资源
    @ApiOperation("根据角色查询权限资源")
    @PostMapping("/getResourceByRole")
    public ResultMessage getResourceByRole(@RequestBody @Validated String role, BindingResult errors) throws Exception{
        ResultMessage resultMessage = ParamCheckUtil.checkParam(errors);
        if (resultMessage != null) return resultMessage;
        return resourceService.queryResourceByRole(role.replace("\"","").trim());
    }
    //更改权限资源
    @ApiOperation("更改权限资源")
    @PostMapping("/updateResources")
    public ResultMessage updateResources(@RequestBody @Validated ResourceParam resourceParam,BindingResult errors) throws Exception{
        ResultMessage resultMessage = ParamCheckUtil.checkParam(errors);
        if (resultMessage != null) return resultMessage;
        return resourceService.updateResource(resourceParam);
    }

}
