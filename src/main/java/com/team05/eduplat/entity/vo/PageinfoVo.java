package com.team05.eduplat.entity.vo;

import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * @program: EduPlat
 * @description: TODO
 * @author: jian'jun'bin
 * @Date 2019-11-11 9:25
 **/
@Data
public class PageinfoVo {

        @NotNull(message = "分页单页条目数, 不得为null.")
        private Integer size;
        @NotNull(message = "当前页码, 不得为null.")
        private Integer indexPageNum;
        @NotNull(message = "true 为正序 false为倒序, 不得为null.")
        private Boolean order;
        @NotNull(message = "排序字段名列表, 不得为null, 根据排序字段先后顺序作排序优先级.")
        private String[] sortFieldNames;

}
