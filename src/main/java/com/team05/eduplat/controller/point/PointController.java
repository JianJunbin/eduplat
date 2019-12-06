package com.team05.eduplat.controller.point;

import com.team05.eduplat.controller.param.CategoryParam;
import com.team05.eduplat.controller.param.point.ExchangeListParam;
import com.team05.eduplat.service.point.ExchangeListService;
import com.team05.eduplat.service.point.PointRecordService;
import com.team05.eduplat.service.point.PointService;
import com.team05.eduplat.utils.Result.ParamCheckUtil;
import com.team05.eduplat.utils.Result.ResultEnum;
import com.team05.eduplat.utils.Result.ResultHelper;
import com.team05.eduplat.utils.Result.ResultMessage;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: eduplat
 * @description: TODO
 * @author: chen wenliang
 * @Date 2019/11/29
 **/
@RestController
public class PointController {
    @Autowired
    private PointService pointService;
    @Autowired
    private PointRecordService pointRecordService;
    @Autowired
    private ExchangeListService exchangeListService;
    //获取积分
    @ApiOperation("获取积分")
    @PostMapping("/gainPoint")
    public ResultMessage gainPoint(Long viewDuration,String username) throws Exception{
        if (viewDuration==null || viewDuration==0 || viewDuration<0 || viewDuration>Long.MAX_VALUE){
            return ResultHelper.result(ResultEnum.FAIL).setMsg("时长为零");
        }
        int time= (int) (viewDuration/60000);
        if (time>0){
            return pointService.gainPoint(time,username);
        }else {
            return ResultHelper.result(ResultEnum.FAIL).setMsg("获取积分为零");
        }

    }
    //积分兑换
    @ApiOperation("积分兑换")
    @PostMapping("/exchangePoint")
    public ResultMessage exchangePoint(int point ,String username) throws Exception{
        return pointService.exchangePoint(point,username);
    }
    //根据用户名查询积分获取与花费记录
    @ApiOperation("根据用户名查询积分获取与花费记录")
    @PostMapping("/queryPoints")
    public ResultMessage queryPoints(@RequestBody @Validated CategoryParam categoryParam,String username, BindingResult errors) throws Exception{
        ResultMessage resultMessage = ParamCheckUtil.checkParam(errors);
        if (resultMessage != null) return resultMessage;
        return pointRecordService.queryPoints(categoryParam,username);
    }


    //-------------------------------
    @ApiOperation("增加积分兑换列表")
    @PostMapping("/addExchangeList")
    public ResultMessage addExchangeList(@RequestBody @Validated ExchangeListParam exchangeListParam, BindingResult errors) throws Exception{
        ResultMessage resultMessage = ParamCheckUtil.checkParam(errors);
        if (resultMessage != null) return resultMessage;
        return exchangeListService.addExchangeList(exchangeListParam);
    }

    @ApiOperation("查询积分兑换列表")
    @PostMapping("/queryExchangeList")
    public ResultMessage queryExchangeList(@RequestBody @Validated CategoryParam categoryParam, BindingResult errors) throws Exception{
        ResultMessage resultMessage = ParamCheckUtil.checkParam(errors);
        if (resultMessage != null) return resultMessage;
        return exchangeListService.queryExchangeList(categoryParam);
    }

    @ApiOperation("根据id更新积分兑换列表")
    @PostMapping("/updateExchangeList")
    public ResultMessage updateExchangeList(long id,long viewId,int price) throws Exception{
        return exchangeListService.updateExchangeList(id,viewId,price);
    }

}
