package com.team05.eduplat.entity.po;

import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;

/**
 * @program: EduPlat
 * @description: TODO
 * @author: jian'jun'bin
 * @Date 2019-11-11 9:17
 **/
public class PageinfoPo {
    @NotNull(message = "分页单页条目数不得为null")
    @ApiModelProperty("分页单页条目数")
    private Integer size;

    @NotNull(message = "当前页不能为空")
    @ApiModelProperty("当前页码")
    private Integer indexPageNum;

    @NotNull(message = "排序列表不为空")
    @ApiModelProperty("true为正序，false为倒序")
    private Boolean order;

    public PageinfoPo(){

    }

    public PageinfoPo(Integer size, Integer indexPageNum, Boolean order) {
        this.size = size;
        this.indexPageNum = indexPageNum;
        this.order = order;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public Integer getIndexPageNum() {
        return indexPageNum;
    }

    public void setIndexPageNum(Integer indexPageNum) {
        this.indexPageNum = indexPageNum;
    }

    public Boolean getOrder() {
        return order;
    }

    public void setOrder(Boolean order) {
        this.order = order;
    }
}
