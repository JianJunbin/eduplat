package com.team05.eduplat.service;

import com.team05.eduplat.entity.po.CourseTestPo;
import com.team05.eduplat.entity.vo.CourseTestVo;
import com.team05.eduplat.repository.CourseTestDao;
import com.team05.eduplat.utils.Result.ResultEnum;
import com.team05.eduplat.utils.Result.ResultHelper;
import com.team05.eduplat.utils.Result.ResultMessage;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.LinkedList;
import java.util.List;

/**
 * @program: eduplat
 * @description: TODO
 * @author: Jing
 * @create: 2019-11-27 16:35
 **/
@Service
@Transactional
public class CourseTestService {
    @Autowired
    CourseTestDao courseTestDao;

    public ResultMessage ListTest(long user_id){
        List<CourseTestPo> courseTestPos=courseTestDao.findAllByUser_id(user_id);
        List<CourseTestVo> courseTestVos=new LinkedList<>();
        courseTestPos.forEach(t ->{
            CourseTestVo courseTestVo=new CourseTestVo();
            BeanUtils.copyProperties(t,courseTestVo);
            courseTestVos.add(courseTestVo);
            //还需将课程名以及章节添加至数据中
        });
        return ResultHelper.result(ResultEnum.SUCCESS)
                .put("test",courseTestVos);
    }

    public ResultMessage AddTest(CourseTestPo courseTestPo){
        courseTestDao.saveAndFlush(courseTestPo);
        long id=courseTestPo.getId();
        System.out.println("添加试卷id:"+id);
        return ResultHelper.result(ResultEnum.SUCCESS)
                .put("testId",id);
    }

    public ResultMessage DeleteTest(long id){
        courseTestDao.deleteTest(id);
        return ResultHelper.result(ResultEnum.SUCCESS)
                .put("testID",id);
    }

    public ResultMessage RecoverTest(long id){
        courseTestDao.recoverTest(id);
        return ResultHelper.result(ResultEnum.SUCCESS)
                .put("testID",id);
    }

}
