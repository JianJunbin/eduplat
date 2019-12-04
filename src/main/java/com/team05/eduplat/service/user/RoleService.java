package com.team05.eduplat.service.user;

import com.team05.eduplat.entity.po.user.RolePo;
import com.team05.eduplat.entity.vo.user.RoleVo;
import com.team05.eduplat.repository.user.RoleDao;
import com.team05.eduplat.utils.Result.ResultEnum;
import com.team05.eduplat.utils.Result.ResultHelper;
import com.team05.eduplat.utils.Result.ResultMessage;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

/**
 * @program: eduplat
 * @description: TODO
 * @author: chen wenliang
 * @Date 2019/11/28
 **/
@Service
@Transactional
public class RoleService {
    @Autowired
    private RoleDao roleDao;

    public ResultMessage addRole(String rolename,String namezh)throws Exception{
        RolePo rolePo=new RolePo();
        rolePo.setRolename(rolename);
        rolePo.setNamezh(namezh);
        RolePo rolePo1=roleDao.save(rolePo);
        if (rolePo1!=null){
            return ResultHelper.result(ResultEnum.SUCCESS).setMsg("增加成功");
        }else {
            return ResultHelper.result(ResultEnum.FAIL).setMsg("增加失败");
        }
    }

    public ResultMessage deleteRole(long id){
        try{
            roleDao.deleteById(id);
            return ResultHelper.result(ResultEnum.FAIL).setMsg("删除成功");
        }catch(Exception e) {
            return ResultHelper.result(ResultEnum.FAIL).setMsg("删除失败");
        }
    }
    public ResultMessage queryRole(){
        List<RolePo> rolePos=roleDao.findAll();
        List<RoleVo> roleVos=new ArrayList<>();
        if (rolePos!=null){
            rolePos.forEach(e ->{
                RoleVo roleVo= new RoleVo();
                BeanUtils.copyProperties(e,roleVo);
                roleVos.add(roleVo);
            });
            return ResultHelper.result(ResultEnum.SUCCESS).put("roleVos",roleVos);
        }else {
            return ResultHelper.result(ResultEnum.FAIL).setMsg("查询失败");
        }
    }
}
