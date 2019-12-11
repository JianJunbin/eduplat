package com.team05.eduplat.entity.vo.Question;

import lombok.Data;

/**
 * @program: eduplat
 * @description: use to calculate the user's total course score
 * @author: Jing
 * @create: 2019-12-11 09:14
 **/
@Data
public class totalScoreVo {
    private Long user_id;
    private Long course_id;
    private Long chapter;
    private int mark;
}
