package com.team05.eduplat.controller;

import com.team05.eduplat.controller.param.CategoryParam;
import com.team05.eduplat.service.CategoryService;
import com.team05.eduplat.utils.Result.ParamCheckUtil;
import com.team05.eduplat.utils.Result.ResultMessage;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: EduPlat
 * @description: TODO
 * @author: jian'jun'binx`
 * @Date 2019-11-6 9:54
 **/
@RestController
public class CategoryController {

    @Autowired
    CategoryService categoryService;
    @ApiOperation("分页查询")
    @PostMapping("/pageCategory")
    public ResultMessage pageCategory(@RequestBody @Validated CategoryParam categoryParam, BindingResult errors) throws Exception {
        ResultMessage resultMessage = ParamCheckUtil.checkParam(errors);
        if (resultMessage != null) return resultMessage;
        return categoryService.pageCategory(categoryParam);
    }
}
