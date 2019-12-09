package com.team05.eduplat.entity.vo.Question;

import lombok.Data;

/**
 * @program: eduplat
 * @description:值对象
 * @author: Jing
 * @create: 2019-11-27 17:23
 **/
@Data
public class TestQuestionVo {
    private Long id;
    private Long test_id;
    private Long[] questionSelected;
//    private int isdelete;
}
