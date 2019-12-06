package com.team05.eduplat.service.point;

import com.team05.eduplat.controller.param.CategoryParam;
import com.team05.eduplat.entity.po.point.PointPo;
import com.team05.eduplat.entity.po.point.PointRecordPo;
import com.team05.eduplat.entity.vo.PageinfoVo;
import com.team05.eduplat.entity.vo.point.PointRecordVo;
import com.team05.eduplat.repository.point.PointDao;
import com.team05.eduplat.repository.point.PointRecordDao;
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
 * @Date 2019/11/29
 **/
@Service
@Transactional
public class PointRecordService {
    @Autowired
    private PointRecordDao pointRecordDao;
    @Autowired
    private PointDao pointDao;
    //查询
    public ResultMessage queryPoints(CategoryParam categoryParam,String username){
        //获取页面信息
        PageinfoVo pageinfoVo = categoryParam.getPageinfoVo();
        //根据页面信息查询数据
        PointPo pointPo=pointDao.findByUsernameEquals(username);
        if (pointPo!=null){
            Page<PointRecordPo> pointRecordPos=pointRecordDao.findByPointId(pointPo.getId(), PageHelper.initPage(pageinfoVo));
            if (pointRecordPos!=null){
                return ResultHelper.result(ResultEnum.SUCCESS).put("pointRecordPos",pointRecordPos);
            }else {
                return ResultHelper.result(ResultEnum.FAIL).setMsg("暂无积分记录");
            }
        }else {
            return ResultHelper.result(ResultEnum.FAIL).setMsg("暂无积分");
        }
    }
}
