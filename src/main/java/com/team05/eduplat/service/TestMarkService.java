package com.team05.eduplat.service;

import com.team05.eduplat.entity.po.Question.TestMarkPo;
import com.team05.eduplat.entity.vo.Question.MarkVo;
import com.team05.eduplat.repository.TestMarkDao;
import com.team05.eduplat.utils.Result.ResultEnum;
import com.team05.eduplat.utils.Result.ResultHelper;
import com.team05.eduplat.utils.Result.ResultMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

/**
 * @program: eduplat
 * @description: TODO
 * @author: Jing
 * @create: 2019-12-09 09:50
 **/
@Service
@Transactional
public class TestMarkService {
    @Autowired
    TestMarkDao testMarkDao;
    /**
    * @Description: 添加成绩
    * @Param:  成绩实体
    * @return:  无
    * @Author: Jing
    * @Date: 2019/12/9
    */
    public ResultMessage addMark(TestMarkPo testMarkPo){
        testMarkDao.saveAndFlush(testMarkPo);
        System.out.println("添加成绩成功");
        return ResultHelper.result(ResultEnum.SUCCESS);
    }

    /**
    * @Description:  查找成绩
    * @Param:  传入markVO（试卷id，用户id）
    * @return:  若存在返回成绩，若不存在，返回-1
    * @Author: Jing
    * @Date: 2019/12/9
    */
    public ResultMessage findMark(MarkVo markVo){
        Long test_id = markVo.getTest_id();
        Long user_id = markVo.getUser_id();
        int mark=-1;
        try{
            mark = testMarkDao.findMark(test_id,user_id);
            return ResultHelper.result(ResultEnum.SUCCESS)
                    .put("mark",mark);
        }catch(Exception e){
            return ResultHelper.result(ResultEnum.SUCCESS)
                    .put("mark",mark);
        }

    }
}
