package com.team05.eduplat.controller;

import com.team05.eduplat.entity.po.Question.CourseTestPo;
import com.team05.eduplat.entity.po.Question.ScoreRulePo;
import com.team05.eduplat.entity.po.Question.TestMarkPo;
import com.team05.eduplat.entity.vo.Question.*;
import com.team05.eduplat.service.Question.CourseTestService;
import com.team05.eduplat.service.Question.ScoreRuleService;
import com.team05.eduplat.service.Question.TestMarkService;
import com.team05.eduplat.service.Question.TestQuestionService;
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
    @Autowired
    ScoreRuleService scoreRuleService;

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

    @ApiOperation("查找指定课程章节是否存在试卷")
    @PostMapping("/findTest")
    public ResultMessage findTest(@RequestBody ShowTestVo showTestVo, BindingResult errors){
        ResultMessage resultMessage = ParamCheckUtil.checkParam(errors);
        if (resultMessage !=null)return  resultMessage;
        Long course_id = showTestVo.getCourse_id();
        Long chapter = showTestVo.getChapter();
        Long section = showTestVo.getSection();
        return courseTestService.findTest(course_id,chapter,section);
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

    @ApiOperation("设置规则")
    @PostMapping("/setRule")
    public ResultMessage setRule(@RequestBody ScoreRulePo scoreRulePo,BindingResult errors){
        ResultMessage resultMessage = ParamCheckUtil.checkParam(errors);
        if (resultMessage != null)return resultMessage;
        return scoreRuleService.setRule(scoreRulePo);
    }

    @ApiOperation("计算总分")
    @PostMapping("/totalScore")
    public ResultMessage totalScore(@RequestBody totalScoreVo totalScoreVo,BindingResult errors){
        ResultMessage resultMessage = ParamCheckUtil.checkParam(errors);
        if (resultMessage != null)return resultMessage;
        Long user_id = totalScoreVo.getUser_id();
        Long course_id = totalScoreVo.getCourse_id();
        Long chapter = totalScoreVo.getChapter();
        int mark = totalScoreVo.getMark();                                  //本次试卷得分
        int video_proportion = scoreRuleService.getRule(course_id,chapter); //获取该章节打分规则中视频占分比
        int question_proportion = 100 - video_proportion;                   //题目占分比 = 100 - 视频占分比
        int num = scoreRuleService.getSectionNum(course_id);                //获取课程节数
        int totalScore = (video_proportion+question_proportion*mark/100)/num;//课程分数计算
        System.out.println("本次学习获得课程分数："+totalScore);
        return scoreRuleService.setCourseMark(user_id,course_id,totalScore);
    }
}
