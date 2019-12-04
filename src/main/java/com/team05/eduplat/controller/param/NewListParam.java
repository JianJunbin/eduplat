package com.team05.eduplat.controller.param;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import net.sf.json.JSONArray;

import javax.validation.constraints.NotNull;

/**
 * @program: EduPlat
 * @description: TODO
 * @author: jian'jun'bin
 * @Date 2019-11-21 14:39
 **/
@Data
public class NewListParam {

    @ApiModelProperty("课程id")
    @NotNull(message = "课程id不能为空")
    Long courseId;

    @ApiModelProperty("课程目录")
    @NotNull(message = "课程目录不能为空")
    JSONArray jsonArray;

}
