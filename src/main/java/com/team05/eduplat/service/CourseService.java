package com.team05.eduplat.service;

import com.team05.eduplat.controller.param.NewListParam;
import com.team05.eduplat.controller.param.OrderParam;
import com.team05.eduplat.entity.po.CourseListPo;
import com.team05.eduplat.entity.po.CourseOrderPo;
import com.team05.eduplat.entity.po.CoursePo;
import com.team05.eduplat.entity.vo.CourseListVo;
import com.team05.eduplat.entity.vo.CourseVo;
import com.team05.eduplat.entity.vo.PageinfoVo;
import com.team05.eduplat.repository.CourseDao;
import com.team05.eduplat.repository.CourseListDao;
import com.team05.eduplat.repository.CourseOrderDao;
import com.team05.eduplat.utils.PageHelper;
import com.team05.eduplat.utils.Result.ResultEnum;
import com.team05.eduplat.utils.Result.ResultHelper;
import com.team05.eduplat.utils.Result.ResultMessage;
import net.sf.json.JSONArray;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.LinkedList;
import java.util.List;

/**
 * @program: EduPlat
 * @description: 课程相关业务逻辑
 * @author: jian'jun'bin
 * @Date 2019-11-22 17:28
 **/
@Service
@Transactional
public class CourseService {
    @Autowired
    CourseListDao courseListDao;
    @Autowired
    CourseDao courseDao;
    @Autowired
    CourseOrderDao courseOrderDao;
    /*创建课程目录，NewListParam为页面传入的目录数据，遍历循环转换成courselistPo并存入数据库*/
    public ResultMessage createList(NewListParam newListParam){
        String nodeName;
        Long courseId;
        Long nodeId;
        Long pid;
        courseId = newListParam.getCourseId();
        JSONArray jsonArray = newListParam.getJsonArray();
        for (int i=0;i<jsonArray.size();i++){
            CourseListPo courseListPo = new CourseListPo();
            courseListPo.setCourseId(courseId);
            JSONArray childArray = jsonArray.getJSONObject(i).getJSONArray("children");
            System.out.println("第"+i+"章的childs"+childArray);
            int childSize = childArray.size();
            if(childArray.size()>0){
                for (int j=0;j<=childSize-1;j++){
                    CourseListPo courseListPo1 = new CourseListPo();
                    courseListPo1.setCourseId(courseId);
                    nodeName = childArray.getJSONObject(j).getString("name");
                    nodeId = childArray.getJSONObject(j).getLong("id");
                    pid = childArray.getJSONObject(j).getLong("pid");
                    courseListPo1.setNodeId(nodeId);
                    courseListPo1.setPid(pid);
                    courseListPo1.setNodeName(nodeName);
                    System.out.println("第"+j+"节的courseListPo::"+courseListPo1);
                    System.out.println("nodeID::"+courseListPo1.getNodeId()+"::pid::"+courseListPo1.getPid());
                    courseListDao.saveAndFlush(courseListPo1);
                    //entityManager.clear();
                   /* JpaTransactionManager txManager = new JpaTransactionManager();
                    Session session = (Session) txManager.getEntityManagerFactory();
                    session.evict(courseListPo);*/
                }
            }
            nodeName = jsonArray.getJSONObject(i).getString("name");
            nodeId = jsonArray.getJSONObject(i).getLong("id");
            pid = Long.valueOf(0);
            courseListPo.setNodeId(nodeId);
            courseListPo.setPid(pid);
            courseListPo.setNodeName(nodeName);
            System.out.println("第"+i+"章的courseListPo::"+courseListPo);
            courseListDao.saveAndFlush(courseListPo);
            //entityManager.clear();
        }
        return ResultHelper.result(ResultEnum.SUCCESS);
    }

    /*根据用户id和课程状态查找正在学习的课程*/
    public ResultMessage findLearningCourse(OrderParam orderParam){
        Long param_id = orderParam.getUserId();
        int param_status = orderParam.getStatus();
        List<CourseOrderPo> courseOrderPos;
        courseOrderPos = courseOrderDao.findByUserIdAndStatus(param_id,param_status);
        List<CourseVo> courseVos = new LinkedList<>();
        courseOrderPos.forEach(e->{
            CoursePo coursePo = courseDao.findByCourseId(e.getCourseId());
            CourseVo courseVo = new CourseVo();
            BeanUtils.copyProperties(coursePo,courseVo);
            courseVos.add(courseVo);
        });
        return ResultHelper.result(ResultEnum.SUCCESS)
                .put("courseVos",courseVos);
    }
    /*查找课程目录*/
    public ResultMessage findList(Long courseId){
        List<CourseListPo> courseListPos;
        courseListPos = courseListDao.findByCourseId(courseId);
        List<CourseListVo> courseListVos = new LinkedList<>();
        courseListPos.forEach(e->{
            CourseListVo courseListVo = new CourseListVo();
            courseListVo.setListId(e.getListId());
            courseListVo.setCourseId(e.getCourseId());
            courseListVo.setId(e.getNodeId());
            courseListVo.setName(e.getNodeName());
            courseListVo.setPid(e.getPid());
            courseListVos.add(courseListVo);
        });
        return ResultHelper.result(ResultEnum.SUCCESS).put("treeData",courseListVos);
    }

    /*创建课程，CourseVo为页面传入的课程实体类，BeanUtils转换后存入数据库*/
    public ResultMessage createCourse(CourseVo courseVo){
        CoursePo coursePo = new CoursePo();
        BeanUtils.copyProperties(courseVo,coursePo);
        courseDao.save(coursePo);
        return ResultHelper.result(ResultEnum.SUCCESS)
                .put("courseId",coursePo.getCourseId());
    }

    public ResultMessage pageCourse(PageinfoVo pageinfoVo){
        Page<CoursePo> coursePos;
        coursePos = courseDao.findByUserId(PageHelper.initPage(pageinfoVo),pageinfoVo.getUserId());
        List<CourseVo> courseVos = new LinkedList<>();
        coursePos.forEach(e->{
            CourseVo courseVo = new CourseVo();
            BeanUtils.copyProperties(e,courseVo);
            courseVos.add(courseVo);
        });
        return ResultHelper.result(ResultEnum.SUCCESS)
                .put("courseVos",courseVos);
    }

    public ResultMessage deleteList(Long courseId){
        courseListDao.deleteAllByCourseId(courseId);
        return ResultHelper.result(ResultEnum.SUCCESS);
    }

    public ResultMessage deleteCourse(Long courseId){
        courseDao.deleteByCourseId(courseId);
        return ResultHelper.result(ResultEnum.SUCCESS);
    }

}
