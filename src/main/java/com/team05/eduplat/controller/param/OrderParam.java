package com.team05.eduplat.controller.param;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * @program: EduPlat
 * @description: TODO
 * @author: jian'jun'bin
 * @Date 2019-11-29 16:10
 **/
@Data
public class OrderParam {
    @ApiModelProperty("订单状态")
    @NotNull(message = "订单状态不能为空")
    int status;
    @ApiModelProperty("用户id")
    @NotNull(message = "用户id不能为空")
    Long userId;
}
