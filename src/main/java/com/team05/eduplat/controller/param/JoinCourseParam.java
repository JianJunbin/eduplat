package com.team05.eduplat.controller.param;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * @program: EduPlat
 * @description: TODO
 * @author: jian'jun'bin
 * @Date 2019-12-10 9:07
 **/
@Data
public class JoinCourseParam {
    @ApiModelProperty("orderId")
    Long orderId;

    @ApiModelProperty("用户id")
    @NotNull(message = "用户id不能为空")
    Long userId;

    @ApiModelProperty("课程id")
    @NotNull(message = "课程id不能为空")
    Long courseId;

    @ApiModelProperty("订单状态")
    int status;
}
