package com.team05.eduplat.service;

import com.team05.eduplat.entity.po.CourseTestPo;
import com.team05.eduplat.entity.po.QuestionPo;
import com.team05.eduplat.entity.vo.CourseTestVo;
import com.team05.eduplat.entity.vo.EditTestVo;
import com.team05.eduplat.entity.vo.QuestionVo;
import com.team05.eduplat.repository.CourseListDao;
import com.team05.eduplat.repository.CourseTestDao;
import com.team05.eduplat.repository.QuestionDao;
import com.team05.eduplat.repository.TestQuestionDao;
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
    @Autowired
    CourseListDao courseListDao;
    @Autowired
    TestQuestionDao testQuestionDao;
    @Autowired
    QuestionDao questionDao;

    /**
    * @Description: 查询课程下的试卷
    * @Param:  传入课程id
    * @return:  查询成功，返回该课程下的试卷id
    * @Author: Jing
    * @Date: 2019/12/3
    */
    public ResultMessage ListTest(Long course_id){
        List<CourseTestPo> courseTestPos = courseTestDao.findAllByCourse_id(course_id);//获取所有试卷
        List<CourseTestVo> courseTestVos = new LinkedList<>();
        courseTestPos.forEach(t ->{
            String chapter=courseListDao.getNodeName(t.getCourse_id(),t.getChapter());
            String section=courseListDao.getNodeName(t.getCourse_id(),t.getSection());
            CourseTestVo courseTestVo = new CourseTestVo();
            courseTestVo.setId(t.getId());
            courseTestVo.setCourse_id(t.getCourse_id());
            courseTestVo.setChapter(chapter);
            courseTestVo.setSection(section);
            courseTestVo.setQuestion_num(t.getQuestion_num());
            courseTestVo.setIsdelete(t.getIsdelete());
            courseTestVos.add(courseTestVo);
            });
        return ResultHelper.result(ResultEnum.SUCCESS)
                .put("tests",courseTestVos);
    }
    /**
    * @Description:  查找指定章节视频下的试卷id
    * @Param: 传入课程id,章,节
    * @return:  返回试卷ID
    * @Author: Jing
    * @Date: 2019/12/6
    */
    public ResultMessage findTest(Long course_id, Long chapter, Long section){
        CourseTestPo courseTestPo = courseTestDao.findTest(course_id,chapter,section);
        String chapterName=courseListDao.getNodeName(course_id,chapter);
        String sectionName=courseListDao.getNodeName(course_id,section);
        CourseTestVo courseTestVo = new CourseTestVo();
        courseTestVo.setId(courseTestPo.getId());
        courseTestVo.setCourse_id(courseTestPo.getCourse_id());
        courseTestVo.setChapter(chapterName);
        courseTestVo.setSection(sectionName);
        courseTestVo.setQuestion_num(courseTestPo.getQuestion_num());
        courseTestVo.setIsdelete(courseTestPo.getIsdelete());
        return ResultHelper.result(ResultEnum.SUCCESS)
                .put("test",courseTestVo);
    }

    /**
    * @Description: 显示一份试卷中的所有题目
    * @Param:  传入试卷id
    * @return:  返回List<QuestionVo>
    * @Author: Jing
    * @Date: 2019/12/6
    */
    public ResultMessage ListQuestion(Long test_id){
        List<Long> questions = testQuestionDao.findAllByTest_id(test_id);//获取一份试卷中的所有题目id
        List<QuestionVo> questionVos = new LinkedList<>();
        questions.forEach(q ->{     //获取试卷中的所有题目
            QuestionPo questionPo = questionDao.findById(q);
            QuestionVo questionVo=new QuestionVo();
            BeanUtils.copyProperties(questionPo,questionVo);
            questionVos.add(questionVo);
        });
        return ResultHelper.result(ResultEnum.SUCCESS)
                .put("questions",questionVos);
    }
    /**
    * @Description: 添加试题
    * @Param:  传入课程试题对象
    * @return:  返回添加后的id
    * @Author: Jing
    * @Date: 2019/12/6
    */
    public ResultMessage AddTest(CourseTestPo courseTestPo){
        courseTestDao.saveAndFlush(courseTestPo);
        Long id = courseTestPo.getId();
        System.out.println("添加试卷id:"+id);
        return ResultHelper.result(ResultEnum.SUCCESS)
                .put("testID",id);
    }
    /**
    * @Description: 修改课程试题
    * @Param:  传入课程试题对象
    * @return:  返回修改的试题id
    * @Author: Jing
    * @Date: 2019/12/6
    */
    public ResultMessage UpdateTest(EditTestVo editTestVo){
        Long test_id = editTestVo.getTest_id();
        int question_num = editTestVo.getQuestion_num();
        courseTestDao.editTest(test_id,question_num);
        System.out.println("修改试卷id:"+test_id);
        return ResultHelper.result(ResultEnum.SUCCESS)
                .put("testID",test_id);
    }

    public ResultMessage DeleteTest(Long id){
        courseTestDao.deleteTest(id);
        return ResultHelper.result(ResultEnum.SUCCESS)
                .put("testID",id);
    }

    public ResultMessage RecoverTest(Long id){
        courseTestDao.recoverTest(id);
        return ResultHelper.result(ResultEnum.SUCCESS)
                .put("testID",id);
    }

}
