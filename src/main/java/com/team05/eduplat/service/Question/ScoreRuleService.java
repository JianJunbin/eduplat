package com.team05.eduplat.service.Question;

import com.team05.eduplat.entity.po.Question.ScoreRulePo;
import com.team05.eduplat.repository.CourseListDao;
import com.team05.eduplat.repository.CourseOrderDao;
import com.team05.eduplat.repository.Question.ScoreRuleDao;
import com.team05.eduplat.utils.Result.ResultEnum;
import com.team05.eduplat.utils.Result.ResultHelper;
import com.team05.eduplat.utils.Result.ResultMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

/**
 * @program: eduplat
 * @description: TODO
 * @author: Jing
 * @create: 2019-12-10 17:21
 **/
@Service
@Transactional
public class ScoreRuleService {
    @Autowired
    ScoreRuleDao scoreRuleDao;
    @Autowired
    CourseListDao courseListDao;
    @Autowired
    CourseOrderDao courseOrderDao;

    /**
    * @Description: 设置规则
    * @Param: 规则实体
    * @return:  无
    * @Author: Jing
    * @Date: 2019/12/10
    */
    public ResultMessage setRule(ScoreRulePo scoreRulePo){
        scoreRuleDao.saveAndFlush(scoreRulePo);
        System.out.println("设置规则成功");
        return ResultHelper.result(ResultEnum.SUCCESS);
    }
    /**
    * @Description:  查询规则
    * @Param:  传入课程id，章id
    * @return:  返回视频占分比
    * @Author: Jing
    * @Date: 2019/12/11
    */
    public int getRule(Long course_id,Long chapter){
        int video_proportion = 50; //若查询不到 默认50
        try{
            ScoreRulePo scoreRulePo = scoreRuleDao.getCourseRule(course_id,chapter);
            video_proportion = scoreRulePo.getVideo_proportion();
            System.out.println("视频占分比重"+video_proportion);
            return video_proportion;
        }catch (Exception e){
            System.out.println("视频占分比重"+video_proportion);
            return video_proportion;
        }
    }
//    查询课程节数
    public int getSectionNum(Long course_id){
        return courseListDao.getSectionNum(course_id);
    }
    /**
    * @Description: 更新课程得分
    * @Param:  传入用户id，课程id，已获得课程分
    * @return:  返回更新后课程总分
    * @Author: Jing
    * @Date: 2019/12/11
    */
    public ResultMessage setCourseMark(Long user_id,Long course_id,int totalScore){
        int courseMark = courseOrderDao.findMark(user_id,course_id);    //查询已得课程分数
        courseMark = courseMark +totalScore;
        courseOrderDao.updateCourseMark(user_id,course_id,courseMark);  //更新课程分数
        return ResultHelper.result(ResultEnum.SUCCESS)
                .put("课程总得分",courseMark);
    }
}
