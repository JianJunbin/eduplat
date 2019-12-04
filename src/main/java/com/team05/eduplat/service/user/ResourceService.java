package com.team05.eduplat.service.user;

import com.team05.eduplat.controller.param.CategoryParam;
import com.team05.eduplat.entity.po.user.ResourcePo;
import com.team05.eduplat.entity.po.user.RolePo;
import com.team05.eduplat.entity.po.user.RoleResourcePo;
import com.team05.eduplat.entity.vo.PageinfoVo;
import com.team05.eduplat.controller.param.user.ResourceParam;
import com.team05.eduplat.entity.vo.user.ResourceVo;
import com.team05.eduplat.repository.user.ResourceDao;
import com.team05.eduplat.repository.user.RoleDao;
import com.team05.eduplat.repository.user.RoleResourceDao;
import com.team05.eduplat.utils.PageHelper;
import com.team05.eduplat.utils.Result.ResultEnum;
import com.team05.eduplat.utils.Result.ResultHelper;
import com.team05.eduplat.utils.Result.ResultMessage;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

/**
 * @program: eduplat
 * @description: 权限资源业务逻辑
 * @author: chen wenliang
 * @Date 2019/11/23
 **/
@Service
@Transactional
public class ResourceService {
    @Autowired
    private ResourceDao resourceDao;
    @Autowired
    private RoleResourceDao roleResourceDao;
    @Autowired
    private RoleDao roleDao;

    //增加权限资源
    public ResultMessage addResource(ResourceParam resourceParam){
        ResourcePo resourcePo=new ResourcePo();
        resourcePo.setPath(resourceParam.getPath());
        resourcePo.setUrl(resourceParam.getUrl());
        resourcePo.setComponent(resourceParam.getComponent());
        resourcePo.setResourcename(resourceParam.getResourcename());
        ResourcePo resourcePo1=resourceDao.save(resourcePo);
        if (resourcePo1==null){
            return ResultHelper.result(ResultEnum.FAIL).setMsg("增加失败");
        }else {
            roleToResource(resourceParam.getRoleId(),resourcePo1.getId());
            return ResultHelper.result(ResultEnum.SUCCESS).setMsg("增加成功");
        }
    }
    //删除权限资源
    public ResultMessage deleteResource(long id){
        try{
            resourceDao.deleteById(id);
            return ResultHelper.result(ResultEnum.SUCCESS).setMsg("删除成功");
        }catch (Exception e){
            return ResultHelper.result(ResultEnum.FAIL).setMsg("删除失败");
        }
    }
    //查询权限资源
    public ResultMessage queryResource(CategoryParam categoryParam){
        //获取页面信息
        PageinfoVo pageinfoVo = categoryParam.getPageinfoVo();
        //根据页面信息查询数据
        Page<ResourcePo> resourcePos=resourceDao.findAll(PageHelper.initPage(pageinfoVo));
        return ResultHelper.result(ResultEnum.SUCCESS).put("resources",resourcePos);
    }
    public ResultMessage queryResourceByRole(String roleName){
        RolePo rolePo=roleDao.findByRolenameEquals(roleName);
        List<RoleResourcePo> roleResourcePos=null;
        List<Long> ids=new ArrayList<>();
        if (rolePo!=null){
            roleResourcePos=roleResourceDao.findByRoleId(rolePo.getId());
            for (RoleResourcePo roleResourcePo:roleResourcePos) {
                ids.add(roleResourcePo.getResourceId());
            }
        }
        List<ResourceVo> resourceVos=new ArrayList<>();
        if (!roleName.equals("ROLE_user")){
            ResourcePo resourceP=resourceDao.findByIdEquals(1);
            ResourceVo resourceVo = new ResourceVo();
            BeanUtils.copyProperties(resourceP,resourceVo);
            resourceVos.add(resourceVo);
        }
        for (Long id:ids) {
            ResourcePo resourcePo=resourceDao.findByIdEquals(id);
            if (resourcePo.getParentId()==1){
                ResourceVo resourceVo = new ResourceVo();
                BeanUtils.copyProperties(resourcePo,resourceVo);
                resourceVos.add(resourceVo);
            }else {
                ResourcePo resourcePo1=resourceDao.findByIdEquals(resourcePo.getParentId());
                ResourceVo resourceVo = new ResourceVo();
                BeanUtils.copyProperties(resourcePo1,resourceVo);
                ResourceVo resourceVo1 = new ResourceVo();
                BeanUtils.copyProperties(resourcePo,resourceVo1);
                resourceVo.setChildren(resourceVo1);
                if (resourcePo1.getParentId()!=1){
                    ResourcePo resourcePo2=resourceDao.findByIdEquals(resourcePo1.getParentId());
                    ResourceVo resourceVo2 = new ResourceVo();
                    BeanUtils.copyProperties(resourcePo2,resourceVo2);
                    ResourceVo resourceVo3 = new ResourceVo();
                    BeanUtils.copyProperties(resourcePo,resourceVo3);
                    resourceVo1.setChildren(resourceVo3);
                    resourceVos.add(resourceVo2);
                }else {
                    resourceVos.add(resourceVo);
                }
            }
        }
       if (resourceVos.size()>0){
           return ResultHelper.result(ResultEnum.SUCCESS).put("resources",resourceVos);
       }else {
           return ResultHelper.result(ResultEnum.FAIL).setMsg("失败");
       }
    }
    //更改权限资源
    //todo
    public ResultMessage updateResource(ResourceParam param){
        ResourcePo resourcePo=resourceDao.findByIdEquals(param.getId());
        if (resourcePo!=null){
            if (param.getPath()!=null){
                resourcePo.setPath(param.getPath());
            }
            if (param.getUrl()!=null){
                resourcePo.setUrl(param.getUrl());
            }
            if (param.getIcon()!=null){
                resourcePo.setIcon(param.getIcon());
            }
            if (param.getComponent()!=null){
                resourcePo.setComponent(param.getComponent());
            }
            if (param.getResourcename()!=null){
                resourcePo.setResourcename(param.getResourcename());
            }
            if (param.getParent()!=0){
                resourcePo.setParentId(param.getParent());
            }
            ResourcePo resourcePo1=resourceDao.save(resourcePo);
            if (resourcePo1!=null){
                return ResultHelper.result(ResultEnum.SUCCESS).setMsg("更改成功");
            }else {
                return ResultHelper.result(ResultEnum.FAIL).setMsg("更改失败");
            }
        }else {
            return ResultHelper.result(ResultEnum.FAIL).setMsg("失败");
        }
    }
    //关联角色与权限资源
    public RoleResourcePo roleToResource(long roleId,long resourceId){
        RoleResourcePo roleResourcePo=new RoleResourcePo();
        roleResourcePo.setRoleId(roleId);
        roleResourcePo.setResourceId(resourceId);
        return roleResourceDao.save(roleResourcePo);
    }

    public List<ResourcePo> findAll() {
        return resourceDao.findAll();
    }
}
