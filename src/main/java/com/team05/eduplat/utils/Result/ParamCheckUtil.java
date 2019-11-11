package com.team05.eduplat.utils.Result;

import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;

import java.util.stream.Collectors;

/**
 * @program: EduPlat
 * @description: TODO
 * @author: jian'jun'bin
 * @Date 2019-11-11 10:16
 **/
public class ParamCheckUtil {
    // 表单参数校验
    public static ResultMessage checkParam(BindingResult errors) {
        return errors.hasErrors() ?
                ResultHelper.result(ResultEnum.PARAM_ERROR)
                        .put("errors", errors.getAllErrors().stream().map(ObjectError::getDefaultMessage).collect(Collectors.toList())) : null;
    }
}
