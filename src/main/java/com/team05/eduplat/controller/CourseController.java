package com.team05.eduplat.controller;

import com.team05.eduplat.controller.param.NewListParam;
import com.team05.eduplat.entity.vo.CourseVo;
import com.team05.eduplat.service.CourseService;
import com.team05.eduplat.utils.Result.ParamCheckUtil;
import com.team05.eduplat.utils.Result.ResultMessage;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * @program: EduPlat
 * @description: BindingResult用于检错使用可以不填该参数
 * @author: jian'jun'bin
 * @Date 2019-11-21 17:25
 **/
@RestController
@RequestMapping("/course")
@Api(tags = "course")
public class CourseController {
    @Autowired
    CourseService courseService;

    @ApiOperation("添加课程")
    @PostMapping("/createCourse")
    public ResultMessage addCourse(@RequestBody @Validated CourseVo courseVo,BindingResult errors) throws Exception{
        ResultMessage resultMessage = ParamCheckUtil.checkParam(errors);
        if (resultMessage != null) return resultMessage;
        return courseService.createCourse(courseVo);
    }

    @ApiOperation("添加课程目录")
    @PostMapping("/createList")
    public ResultMessage addList(@RequestBody @Validated NewListParam newListParam, BindingResult errors) throws Exception {
        ResultMessage resultMessage = ParamCheckUtil.checkParam(errors);
        if (resultMessage != null) return resultMessage;
        return courseService.createList(newListParam);
    }


}
