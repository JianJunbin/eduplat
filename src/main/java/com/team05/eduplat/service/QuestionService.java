package com.team05.eduplat.service;

import com.team05.eduplat.entity.po.Question.QuestionPo;
import com.team05.eduplat.entity.vo.PageinfoVo;
import com.team05.eduplat.entity.vo.Question.QuestionVo;
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

    /**
    * @Description: 分页查询所有题目
    * @Param:  分页查询请求体
    * @return:  查询成功，返回查询结果
    * @Author: Jing
    * @Date: 2019/12/3
    */
    public ResultMessage ListQuestion(PageinfoVo pageinfoVo){
        Page<QuestionPo> questionPos=questionDao.findAll(PageHelper.initPage(pageinfoVo));
        List<QuestionVo> questionVos=new LinkedList<>();
        questionPos.forEach(q ->{
            QuestionVo questionVo=new QuestionVo();
            BeanUtils.copyProperties(q,questionVo);
            questionVos.add(questionVo);
        });
        return ResultHelper.result(ResultEnum.SUCCESS)
                .put("question",questionVos);
    }

    /**
    * @Description:  修改题目
    * @Param:  传入要修改的题目实体
    * @return:  修改成功，返回说修改的id
    * @Author: Jing
    * @Date: 2019/12/3
    */
    public ResultMessage UpdateQuestion(QuestionPo questionPo){
        questionDao.saveAndFlush(questionPo);
        Long id=questionPo.getId();
        System.out.println("修改题目id:"+id);
        return ResultHelper.result(ResultEnum.SUCCESS)
                .put("questionID",id);
    }

    /**
    * @Description:  添加题目
    * @Param:  传入题目实体对象
    * @return:  添加成功，返回所添加题目id
    * @Author: Jing
    * @Date: 2019/12/3
    */
    public ResultMessage AddQuestion(QuestionPo questionPo){
        questionDao.saveAndFlush(questionPo);
        Long id=questionPo.getId();
        System.out.println("添加题目id:"+id);
        return ResultHelper.result(ResultEnum.SUCCESS)
                .put("questionID",id);
    }

    /**
    * @Description:  题目状态逻辑删除
    * @Param:  传入要删除的题目id
    * @return:  删除成功，返回题目id
    * @Author: Jing
    * @Date: 2019/12/3
    */
    public ResultMessage DeleteQuestion(Long id){
        questionDao.deleteQuestion(id);
        return ResultHelper.result(ResultEnum.SUCCESS)
                .put("questionID",id);
    }

    /**
    * @Description: 题目状态逻辑恢复
    * @Param:  传入要恢复题目id
    * @return:  恢复成功，返回题目id
    * @Author: Jing
    * @Date: 2019/12/3
    */
    public ResultMessage RecoverQuestion(Long id){
        questionDao.recoverQuestion(id);
        return ResultHelper.result(ResultEnum.SUCCESS)
                .put("questionID",id);
    }
}
