package com.team05.eduplat.controller;

import com.team05.eduplat.entity.po.Question.CourseTestPo;
import com.team05.eduplat.entity.po.Question.TestMarkPo;
import com.team05.eduplat.entity.vo.Question.*;
import com.team05.eduplat.service.CourseTestService;
import com.team05.eduplat.service.TestMarkService;
import com.team05.eduplat.service.TestQuestionService;
import com.team05.eduplat.utils.Result.ParamCheckUtil;
import com.team05.eduplat.utils.Result.ResultMessage;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: eduplat
 * @description: TODO
 * @author: Jing
 * @create: 2019-11-27 20:23
 **/

@RestController
@RequestMapping("/test")
@Api(tags = "test")
public class TestController {
    @Autowired
    CourseTestService courseTestService;
    @Autowired
    TestQuestionService testQuestionService;
    @Autowired
    TestMarkService testMarkService;

    @ApiOperation("添加试卷")
    @PostMapping("/add")
    public ResultMessage add(@RequestBody CourseTestPo courseTestPo, BindingResult errors)throws Exception{
        ResultMessage resultMessage = ParamCheckUtil.checkParam(errors);
        if (resultMessage != null)return resultMessage;
        return courseTestService.AddTest(courseTestPo);
    }

    @ApiOperation("添加试题")
    @PostMapping("/addQuestion")
    public ResultMessage addQuestion(@RequestBody TestQuestionVo testQuestionVo, BindingResult errors)throws Exception{
        ResultMessage resultMessage = ParamCheckUtil.checkParam(errors);
        if (resultMessage != null)return resultMessage;
        Long[] questionSelected = testQuestionVo.getQuestionSelected();
        Long test_id = testQuestionVo.getTest_id();
        System.out.println("控制层test_id"+test_id);
        return testQuestionService.AddQuestion(questionSelected,test_id);
    }

    @ApiOperation("修改试卷")
    @PostMapping("/edit")
    public ResultMessage edit(@RequestBody EditTestVo editTestVo, BindingResult errors)throws Exception{
        ResultMessage resultMessage = ParamCheckUtil.checkParam(errors);
        if (resultMessage != null)return resultMessage;
        return courseTestService.UpdateTest(editTestVo);
    }

    @ApiOperation("修改试题")
    @PostMapping("/editQuestion")
    public ResultMessage editQuestion(@RequestBody EditTestQuestionVo editTestQuestionVo, BindingResult errors)throws Exception{
        ResultMessage resultMessage = ParamCheckUtil.checkParam(errors);
        if (resultMessage != null)return resultMessage;
        Long[] questionAdd = editTestQuestionVo.getQuestionAdd();
        Long[] questionDelete = editTestQuestionVo.getQuestionDelete();
        Long test_id = editTestQuestionVo.getTest_id();
        return testQuestionService.UpdateQuestion(questionAdd,questionDelete,test_id);
    }


    @ApiOperation("查询课程下试卷")
    @PostMapping("/listTest")
    public ResultMessage listTest(@RequestBody Long course_id,BindingResult errors)throws Exception{
        ResultMessage resultMessage = ParamCheckUtil.checkParam(errors);
        if (resultMessage != null)return resultMessage;
        return courseTestService.ListTest(course_id);
    }

    @ApiOperation("显示指定章节的试卷")
    @PostMapping("/showTest")
    public ResultMessage showTest(@RequestBody ShowTestVo showTestVo, BindingResult errors)throws Exception{
        ResultMessage resultMessage = ParamCheckUtil.checkParam(errors);
        if (resultMessage != null)return resultMessage;
        Long course_id = showTestVo.getCourse_id();
        Long chapter = showTestVo.getChapter();
        Long section = showTestVo.getSection();
        return courseTestService.showTest(course_id,chapter,section);
    }

    @ApiOperation("查询试卷题目")
    @PostMapping("/listQuestion")
    public ResultMessage listQuestion(@RequestBody Long test_id,BindingResult errors)throws Exception{
        ResultMessage resultMessage = ParamCheckUtil.checkParam(errors);
        if (resultMessage != null)return resultMessage;
        return courseTestService.ListQuestion(test_id);
    }

    @ApiOperation("删除试卷")
    @PostMapping("/delete")
    public ResultMessage delete(@RequestBody Long test_id,BindingResult errors)throws Exception{
        ResultMessage resultMessage = ParamCheckUtil.checkParam(errors);
        if (resultMessage != null)return resultMessage;
        return courseTestService.DeleteTest(test_id);
    }

    @ApiOperation("恢复试卷")
    @PostMapping("/recover")
    public ResultMessage recover(@RequestBody Long test_id,BindingResult errors)throws Exception{
        ResultMessage resultMessage = ParamCheckUtil.checkParam(errors);
        if (resultMessage != null)return resultMessage;
        return courseTestService.RecoverTest(test_id);
    }

    @ApiOperation("添加成绩")
    @PostMapping("/addMark")
    public ResultMessage addMark(@RequestBody TestMarkPo testMarkPo,BindingResult errors){
        ResultMessage resultMessage = ParamCheckUtil.checkParam(errors);
        if (resultMessage != null)return resultMessage;
        return testMarkService.addMark(testMarkPo);
    }

    @ApiOperation("查询成绩")
    @PostMapping("/findMark")
    public ResultMessage findMark(@RequestBody MarkVo markVo, BindingResult errors){
        ResultMessage resultMessage = ParamCheckUtil.checkParam(errors);
        if (resultMessage != null)return resultMessage;
        return testMarkService.findMark(markVo);
    }
}
