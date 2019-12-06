package com.team05.eduplat.service.point;

import com.team05.eduplat.controller.param.CategoryParam;
import com.team05.eduplat.controller.param.point.ExchangeListParam;
import com.team05.eduplat.entity.po.point.ExchangeListPo;
import com.team05.eduplat.entity.vo.PageinfoVo;
import com.team05.eduplat.entity.vo.point.ExchangeListVo;
import com.team05.eduplat.repository.point.ExchangeListDao;
import com.team05.eduplat.utils.PageHelper;
import com.team05.eduplat.utils.Result.ResultEnum;
import com.team05.eduplat.utils.Result.ResultHelper;
import com.team05.eduplat.utils.Result.ResultMessage;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

/**
 * @program: eduplat
 * @description: TODO
 * @author: chen wenliang
 * @Date 2019/12/3
 **/
@Service
@Transactional
public class ExchangeListService {
    @Autowired
    private ExchangeListDao exchangeListDao;

    public ResultMessage addExchangeList(ExchangeListParam exchangeListParam){
        ExchangeListPo exchangeListPo=new ExchangeListPo();
        exchangeListPo.setViewId(exchangeListParam.getViewId());
        exchangeListPo.setPointPrice(exchangeListParam.getPointPrice());
        exchangeListDao.save(exchangeListPo);
        return ResultHelper.result(ResultEnum.SUCCESS).setMsg("保存成功");
    }
    public ResultMessage queryExchangeList(CategoryParam param){
        //获取页面信息
        PageinfoVo pageinfoVo = param.getPageinfoVo();
        //根据页面信息查询数据
        Page<ExchangeListPo> exchangeListPos=exchangeListDao.findAll(PageHelper.initPage(pageinfoVo));
        List<ExchangeListVo> exchangeListVos = new ArrayList<>();
        exchangeListPos.forEach(e ->{
            ExchangeListVo exchangeListVo = new ExchangeListVo();
            BeanUtils.copyProperties(e,exchangeListVo);
            exchangeListVos.add(exchangeListVo);
        });
        return ResultHelper.result(ResultEnum.SUCCESS).put("exchangeList",exchangeListVos);
    }
    public ResultMessage updateExchangeList(long id,long viewId,int price){
        ExchangeListPo exchangeListPo=exchangeListDao.findById(id);
        exchangeListPo.setViewId(viewId);
        exchangeListPo.setPointPrice(price);
        ExchangeListPo exchangeListPo1=exchangeListDao.save(exchangeListPo);
        if (exchangeListPo1!=null){
            return ResultHelper.result(ResultEnum.SUCCESS).setMsg("更改成功");
        }else {
            return ResultHelper.result(ResultEnum.FAIL).setMsg("更改失败");
        }
    }
}
