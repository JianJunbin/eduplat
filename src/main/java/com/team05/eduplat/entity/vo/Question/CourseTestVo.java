package com.team05.eduplat.entity.vo.Question;

import lombok.Data;

/**
 * @program: eduplat
 * @description: 值对象
 * @author: Jing
 * @create: 2019-12-04 09:19
 **/
@Data
public class CourseTestVo {
    private Long id;
    private Long course_id;
    private String chapter;
    private String section;
    private int question_num;
    private int isdelete;
}
