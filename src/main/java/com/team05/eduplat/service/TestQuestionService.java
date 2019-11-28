package com.team05.eduplat.service;

import com.team05.eduplat.entity.po.TestQuestionPo;
import com.team05.eduplat.repository.TestQuestionDao;
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

    public void AddQuestion(TestQuestionPo testQuestionPo){
        testQuestionDao.saveAndFlush(testQuestionPo);
    }

    public void UpdateQuestion(){

    }
}
