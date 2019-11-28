package com.team05.eduplat.controller.param;

import com.team05.eduplat.entity.vo.PageinfoVo;
import lombok.Data;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

/**
 * @program: EduPlat
 * @description: TODO
 * @author: jian'jun'bin
 * @Date 2019-11-11 10:11
 **/
@Data
public class CategoryParam {
        /*
         * 还可以存放页面的一些状态，如登陆状态,id等
         * */
        @Valid
        @NotNull(message = "分页信息不能为空")
        PageinfoVo pageinfoVo;
}
