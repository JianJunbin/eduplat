package com.team05.eduplat.entity.vo;

import lombok.Data;

/**
 * @program: eduplat
 * @description: 值对象
 * @author: Jing
 * @create: 2019-11-25 10:03
 **/
@Data
public class QuestionVo {
    private Long id;
    private int type;
    private String content;
    private String option1;
    private String option2;
    private String option3;
    private String option4;
    private String answer;
    private String q_description;
    private String tag1;
    private String tag2;
    private String tag3;
    private Long user_id;
    private Long course_id;
    private int isdelete;
}
