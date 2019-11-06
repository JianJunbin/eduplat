package com.team05.eduplat.controller;

import com.team05.eduplat.repository.CategoryDao;
import com.team05.eduplat.service.CategoryService;
import com.team05.eduplat.utils.Result.ResultMessage;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
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
    @ApiOperation("查询")
    @PostMapping("/listCategory")
    @ResponseBody
    public ResultMessage findAll() throws Exception {
        return categoryService.findAll();
    }
}
