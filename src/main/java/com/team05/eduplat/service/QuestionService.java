package com.team05.eduplat.service;

import com.team05.eduplat.entity.po.QuestionPo;
import com.team05.eduplat.entity.vo.PageinfoVo;
import com.team05.eduplat.entity.vo.QuestionVo;
import com.team05.eduplat.repository.QuestionDao;
import com.team05.eduplat.utils.PageHelper;
import com.team05.eduplat.utils.Result.ResultEnum;
import com.team05.eduplat.utils.Result.ResultHelper;
import com.team05.eduplat.utils.Result.ResultMessage;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.LinkedList;
import java.util.List;

/**
 * @program: eduplat
 * @description: TODO
 * @author: Jing
 * @create: 2019-11-25 09:39
 **/

@Service
@Transactional
public class QuestionService {
    @Autowired
    QuestionDao questionDao;

    //题目列表
    public ResultMessage ListQuestion(PageinfoVo pageinfoVo){
        Page<QuestionPo> questionPos=questionDao.findAll(PageHelper.initPage(pageinfoVo));
        List<QuestionVo> questionVos=new LinkedList<>();
        questionPos.forEach(q ->{
            QuestionVo questionVo=new QuestionVo();
            BeanUtils.copyProperties(q,questionVo);
            questionVos.add(questionVo);
        });
//        for (QuestionPo q : questionPos){
//            QuestionVo questionVo=new QuestionVo();
//            BeanUtils.copyProperties(q,questionVo);
//            questionVos.add(questionVo);
//        }
        return ResultHelper.result(ResultEnum.SUCCESS)
                .put("question",questionVos);
    }


    public ResultMessage UpdateQuestion(QuestionPo questionPo){
        questionDao.saveAndFlush(questionPo);
        long id=questionPo.getId();
        System.out.println("修改题目id:"+id);
        return ResultHelper.result(ResultEnum.SUCCESS)
                .put("questionID",id);
    }

    public ResultMessage AddQuestion(QuestionPo questionPo){
        questionDao.saveAndFlush(questionPo);
        long id=questionPo.getId();
        System.out.println("添加题目id:"+id);
        return ResultHelper.result(ResultEnum.SUCCESS)
                .put("questionID",id);
    }

    public ResultMessage DeleteQuestion(long id){
        questionDao.deleteQuestion(id);
        return ResultHelper.result(ResultEnum.SUCCESS)
                .put("questionID",id);
    }

    public ResultMessage RecoverQuestion(long id){
        questionDao.recoverQuestion(id);
        return ResultHelper.result(ResultEnum.SUCCESS)
                .put("questionID",id);
    }
}
