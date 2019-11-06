package com.team05.eduplat.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: EduPlat
 * @description: TODO
 * @author: jian'jun'bin
 * @Date 2019-11-6 9:21
 **/
@RestController
public class HelloController {

    /**
     * @Author jianjunbin
     * @Description //TODO
     * @Date 9:25 2019-11-6
     * @Param
     * @return
     */
    @RequestMapping("/hello")
    public String Hello(){
        return "hello";
    }
}
