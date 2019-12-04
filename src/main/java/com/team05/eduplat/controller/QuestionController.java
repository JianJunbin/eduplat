package com.team05.eduplat.controller;

import com.team05.eduplat.entity.po.QuestionPo;
import com.team05.eduplat.entity.vo.PageinfoVo;
import com.team05.eduplat.service.QuestionService;
import com.team05.eduplat.utils.Result.ParamCheckUtil;
import com.team05.eduplat.utils.Result.ResultMessage;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * @program: eduplat
 * @description: TODO
 * @author: Jing
 * @create: 2019-11-25 09:36
 **/

@RestController
@RequestMapping("/question")
@Api(tags="question")
public class QuestionController {
    @Autowired
    QuestionService questionService;
    @ApiOperation("分页查询")
    @PostMapping("/list")
    public ResultMessage list(@RequestBody @Validated PageinfoVo pageinfoVo
            , BindingResult errors)throws Exception{
        ResultMessage resultMessage= ParamCheckUtil.checkParam(errors);
        if (resultMessage != null) return resultMessage;
        return questionService.ListQuestion(pageinfoVo);
    }

    @ApiOperation("题目修改")
    @PostMapping("/edit")
    public ResultMessage edit(@RequestBody QuestionPo questionPo,BindingResult errors)throws Exception{
        ResultMessage resultMessage= ParamCheckUtil.checkParam(errors);
        if (resultMessage != null) return resultMessage;
        return questionService.UpdateQuestion(questionPo);
    }

    @ApiOperation("添加题目")
    @PostMapping("/add")
    public ResultMessage add(@RequestBody QuestionPo questionPo,BindingResult errors)throws Exception{
        ResultMessage resultMessage= ParamCheckUtil.checkParam(errors);
        if (resultMessage!=null) return resultMessage;
        return questionService.AddQuestion(questionPo);
    }

    @ApiOperation("删除题目")
    @PostMapping("/delete")
    public ResultMessage delete(@RequestBody long id,BindingResult errors)throws Exception{
        ResultMessage resultMessage=ParamCheckUtil.checkParam(errors);
        if (resultMessage!=null) return resultMessage;
        return questionService.DeleteQuestion(id);
    }

    @ApiOperation("恢复题目")
    @PostMapping("/recover")
    public ResultMessage recover(@RequestBody long id,BindingResult errors)throws Exception{
        ResultMessage resultMessage=ParamCheckUtil.checkParam(errors);
        if (resultMessage!=null) return resultMessage;
        return questionService.RecoverQuestion(id);
    }
}
