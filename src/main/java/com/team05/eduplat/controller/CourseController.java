package com.team05.eduplat.controller;

import com.team05.eduplat.controller.param.NewListParam;
import com.team05.eduplat.controller.param.OrderParam;
import com.team05.eduplat.entity.vo.CourseVo;
import com.team05.eduplat.entity.vo.PageinfoVo;
import com.team05.eduplat.service.CourseService;
import com.team05.eduplat.utils.Result.ParamCheckUtil;
import com.team05.eduplat.utils.Result.ResultMessage;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

    @ApiOperation("分页查询课程")
    @PostMapping("/pageCourse")
    public ResultMessage pageCourse(@RequestBody @Validated PageinfoVo pageinfoVo,BindingResult errors) throws Exception{
        ResultMessage resultMessage = ParamCheckUtil.checkParam(errors);
        if(resultMessage != null) return resultMessage;
        return  courseService.pageCourse(pageinfoVo);
    }

    @ApiOperation("学生在学课程")
    @PostMapping("/onCourse")
    public ResultMessage onCourse(@RequestBody @Validated OrderParam orderParam,BindingResult errors) throws Exception{
        ResultMessage resultMessage = ParamCheckUtil.checkParam(errors);
        if (resultMessage != null) return resultMessage;
        return courseService.findLearningCourse(orderParam);
    }

    @ApiOperation("根据课程id找课程")
    @PostMapping("/courseById")
    public ResultMessage courseById(@RequestBody @Validated Long courseId, BindingResult errors)throws Exception{
        ResultMessage resultMessage = ParamCheckUtil.checkParam(errors);
        if (resultMessage != null) return resultMessage;
        return courseService.findCourseById(courseId);
    }

    @ApiOperation("课程目录查询")
    @PostMapping("/findList")
    public ResultMessage findList(@RequestBody @Validated Long courseId,BindingResult errors) throws Exception{
        ResultMessage resultMessage = ParamCheckUtil.checkParam(errors);
        if(resultMessage != null) return resultMessage;
        return courseService.findList(courseId);
    }

    @ApiOperation("删除目录")
    @PostMapping("deleteList")
    public ResultMessage delList(@RequestBody @Validated Long courseId,BindingResult errors) throws Exception{
        ResultMessage resultMessage = ParamCheckUtil.checkParam(errors);
        if(resultMessage != null) return resultMessage;
        return courseService.deleteList(courseId);
    }
    @ApiOperation("删除课程")
    @PostMapping("deleteCourse")
    public ResultMessage delCourse(@RequestBody @Validated Long courseId,BindingResult errors) throws Exception {
        ResultMessage resultMessage = ParamCheckUtil.checkParam(errors);
        if (resultMessage != null) return resultMessage;
        return courseService.deleteCourse(courseId);
    }
    /**
     * @Description: 试卷添加需要获取当前用户所添加的课程id以及name
     * @Author: Jing
     * @Date: 2019/11/29
     */
    @ApiOperation("用户id查课程")
    @PostMapping("/getCourse")
    public ResultMessage getCourse (@RequestBody @Validated PageinfoVo pageinfoVo, BindingResult errors) throws Exception {
        ResultMessage resultMessage = ParamCheckUtil.checkParam(errors);
        if (resultMessage != null) return resultMessage;
        return courseService.getCourse(pageinfoVo);
    }
}
