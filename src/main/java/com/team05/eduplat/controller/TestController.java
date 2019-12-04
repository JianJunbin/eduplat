package com.team05.eduplat.controller;

import com.team05.eduplat.service.CourseTestService;
import com.team05.eduplat.service.TestQuestionService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
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
}
