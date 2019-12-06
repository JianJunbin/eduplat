package com.team05.eduplat.config.security;

import com.team05.eduplat.entity.po.user.ResourcePo;
import com.team05.eduplat.entity.po.user.RolePo;
import com.team05.eduplat.service.user.ResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
import org.springframework.stereotype.Component;
import org.springframework.util.AntPathMatcher;

import java.util.Collection;
import java.util.List;

/**
 * @program: eduplat
 * @description: 获取当前的请求地址需要的用户角色
 * @author: chen wenliang
 * @Date 2019/11/23
 **/
@Component
public class MySecurityMetadataSource implements FilterInvocationSecurityMetadataSource {
    @Autowired
    private ResourceService resourceService;

    AntPathMatcher antPathMatcher=new AntPathMatcher();
    @Override
    public Collection<ConfigAttribute> getAttributes(Object o) throws IllegalArgumentException {
        //获取请求地址
        String requestUrl = ((FilterInvocation) o).getRequestUrl();

        List<ResourcePo>resourcePoList= resourceService.findAll();
        //获得请求地址的角色
        for (ResourcePo resourcePo:resourcePoList){
            if (resourcePoList.size()>0 && antPathMatcher.match(resourcePo.getUrl(),requestUrl)){
                List<RolePo> roles = resourcePo.getRolePos();
                int size = roles.size();
                String[] values = new String[size];
                for (int i = 0; i < size; i++) {
                    values[i] = roles.get(i).getRolename();
                    System.out.println(roles.get(i).getRolename());
                }
                //创建一个角色集合
                return SecurityConfig.createList(values);
            }
        }
//        return SecurityConfig.createList("ROLE_LOGIN");
        return null;
    }

    @Override
    public Collection<ConfigAttribute> getAllConfigAttributes() {
        return null;
    }

    //返回类对象是否支持校验，web项目一般使用FilterInvocation来判断，或者直接返回true。
    @Override
    public boolean supports(Class<?> aClass) {
        return FilterInvocation.class.isAssignableFrom(aClass);
    }
}
