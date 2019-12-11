package com.team05.eduplat.controller;

import lombok.Data;

import java.math.BigDecimal;

/**
 * @program: EduPlat
 * @description: TODO
 * @author: jian'jun'bin
 * @Date 2019-12-10 21:58
 **/
@Data
public class AlipayParam {
    private Long userId;
    private Long courseId;
    private String intoduction;
    private String name;
    private BigDecimal price;
}
