package com.team05.eduplat.utils.Result;

import java.util.Map;

/**
 * @program: gdouStadium
 * @description:
 * @author: $(USER)
 * @create: $(TIME)
 **/
public class ResultHelper {
    public ResultHelper() {
    }


    public static ResultMessage result(ResultInfo result, Map<String, Object> data) {
        ResultMessage rs = new ResultMessage();
        rs.setCode(result.getCode());
        rs.setMsg(result.getMsg());
        rs.setData(data);
        return rs;
    }

    public static ResultMessage result(int code, String message) {
        ResultMessage rs = new ResultMessage();
        rs.setCode(code);
        rs.setMsg(message);
        return rs;
    }

    public static ResultMessage result(ResultInfo resultInfo) {
        return result(resultInfo, null);
    }

    public static ResultMessage ok() {
        return result(ResultEnum.SUCCESS);
    }

    public static ResultMessage bad() {
        return result(ResultEnum.PARAM_ERROR);
    }


}
