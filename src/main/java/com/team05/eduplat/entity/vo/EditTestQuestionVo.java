package com.team05.eduplat.entity.vo;

import lombok.Data;

/**
 * @program: eduplat
 * @description: 值对象
 * @author: Jing
 * @create: 2019-12-06 09:03
 **/
@Data
public class EditTestQuestionVo {
    private Long id;
    private Long test_id;
    private Long[] questionAdd;
    private Long[] questionDelete;
}
