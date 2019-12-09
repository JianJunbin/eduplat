package com.team05.eduplat.entity.vo.Question;


import lombok.Data;

/**
 * @program: eduplat
 * @description:获取课程id及名字
 * @author: Jing
 * @create: 2019-11-27 16:27
 **/
@Data
public class CourseNameVo {
    //课程id以及名字
    private Long courseId;
    private String name;
}
