package com.team05.eduplat.service.point;

import com.team05.eduplat.entity.po.point.PointPo;
import com.team05.eduplat.entity.po.point.PointRecordPo;
import com.team05.eduplat.repository.point.PointDao;
import com.team05.eduplat.repository.point.PointRecordDao;
import com.team05.eduplat.utils.Result.ResultEnum;
import com.team05.eduplat.utils.Result.ResultHelper;
import com.team05.eduplat.utils.Result.ResultMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Date;

/**
 * @program: eduplat
 * @description: TODO
 * @author: chen wenliang
 * @Date 2019/11/29
 **/
@Service
@Transactional
public class PointService {
    @Autowired
    private PointDao pointDao;
    @Autowired
    private PointRecordDao pointRecordDao;
    //积分获取-存数据
    public ResultMessage gainPoint(int gainPoints, String username){
        PointRecordPo pointRecordPo=new PointRecordPo();
        pointRecordPo.setChangePoints(gainPoints);
        pointRecordPo.setChangeTime(new Date());
        pointRecordPo.setChangeRemark("获得");

        PointPo point=pointDao.findByUsernameEquals(username);

        PointPo pointPo;
        if (point==null){
             pointPo=new PointPo();
        }else {
            pointPo=point;
            gainPoints=gainPoints+point.getPoints();
        }
        pointPo.setPoints(gainPoints);
        pointPo.setUsername(username);
        PointPo pointPo1=pointDao.save(pointPo);
        if (pointPo1!=null){
             pointRecordPo.setPointId(pointPo1.getId());
             pointRecordDao.save(pointRecordPo);
            return ResultHelper.result(ResultEnum.SUCCESS).setMsg("成功");
        }else {
            return ResultHelper.result(ResultEnum.FAIL).setMsg("失败");
        }
    }
    //积分兑换
    public ResultMessage exchangePoint(int point, String username){
        PointPo pointPo=pointDao.findByUsernameEquals(username);
        if (pointPo!=null){
            if (pointPo.getPoints()>point){
                pointPo.setPoints(pointPo.getPoints()-point);
                PointPo pointPo1=pointDao.save(pointPo);
                if (pointPo1!=null){
                    PointRecordPo pointRecordPo=new PointRecordPo();
                    pointRecordPo.setPointId(pointPo1.getId());
                    pointRecordPo.setChangeRemark("兑换");
                    pointRecordPo.setChangeTime(new Date());
                    pointRecordPo.setChangePoints(point);
                    pointRecordDao.save(pointRecordPo);
                    return ResultHelper.result(ResultEnum.SUCCESS).setMsg("兑换成功");
                }else {
                    return ResultHelper.result(ResultEnum.FAIL).setMsg("兑换失败");
                }
            }else {
                return ResultHelper.result(ResultEnum.FAIL).setMsg("积分不足");
            }
        }else {
            return ResultHelper.result(ResultEnum.FAIL).setMsg("暂无积分可用");
        }
    }
}
