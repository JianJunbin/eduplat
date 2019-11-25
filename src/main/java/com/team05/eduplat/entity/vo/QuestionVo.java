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
    private long id;
    private int type;
    private String content;
    private String option1;
    private String option2;
    private String option3;
    private String option4;
    private String answer;
    private String q_description;
    private int tag1;
    private int tag2;
    private int tag3;
    private long user_id;
    private long course_id;
}
