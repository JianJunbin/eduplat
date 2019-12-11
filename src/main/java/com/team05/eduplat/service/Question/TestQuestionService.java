package com.team05.eduplat.service.Question;

import com.team05.eduplat.entity.po.Question.TestQuestionPo;
import com.team05.eduplat.repository.Question.TestQuestionDao;
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
 * @create: 2019-11-27 17:30
 **/
@Service
@Transactional
public class TestQuestionService {
    @Autowired
    TestQuestionDao testQuestionDao;
    /**
    * @Description: 试卷中添加题目
    * @Param:  传入试卷id,题目id数组
    * @Author: Jing
    * @Date: 2019/12/6
    */
    public ResultMessage AddQuestion(Long[] questionSelected, Long test_id){
        System.out.println("业务层接收到test_id"+test_id);
        int len = questionSelected.length;
        for (Long q : questionSelected) {
            TestQuestionPo testQuestionPo = new TestQuestionPo();
            testQuestionPo.setQuestion_id(q);
            testQuestionPo.setTest_id(test_id);
            System.out.println("添加题目id:"+q);
            testQuestionDao.saveAndFlush(testQuestionPo);
        }
        return ResultHelper.result(ResultEnum.SUCCESS)
                .put("question_num",len);
    }
    /**
    * @Description:  修改试卷中题目
    * @Param:  传入新增的题目id，要删除的题目id，试卷id
    * @Author: Jing
    * @Date: 2019/12/6
    */
    public ResultMessage UpdateQuestion(Long[] questionAdd,Long[] questionDelete,Long test_id){
        AddQuestion(questionAdd,test_id);
        for (Long q :questionDelete){
            testQuestionDao.deleteTestQuestion(test_id,q);
            System.out.println("删除题目id:"+q);
        }
        return ResultHelper.result(ResultEnum.SUCCESS)
                .put("testID",test_id);

    }
}
