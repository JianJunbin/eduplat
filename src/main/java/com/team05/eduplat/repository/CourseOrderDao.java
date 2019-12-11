package com.team05.eduplat.repository;

import com.team05.eduplat.entity.po.CourseOrderPo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * @program: EduPlat
 * @description: TODO
 * @author: jian'jun'bin
 * @Date 2019-11-29 16:13
 **/
public interface CourseOrderDao extends JpaRepository<CourseOrderPo,Integer> {
    List<CourseOrderPo> findByUserIdAndStatus(Long userId,int status);

    //查询已获得分数
    @Query(value = "select course_mark from course_order where user_id=:user_id and course_id=:course_id",nativeQuery = true)
    int findMark(@Param(value = "user_id")Long user_id,@Param(value = "course_id")Long course_id);

    //修改分数
    @Modifying
    @Query(value = "update course_order set course_mark=:course_mark where user_id=:user_id and course_id=:course_id"
            ,nativeQuery = true)
    void updateCourseMark(@Param(value = "user_id")Long user_id,@Param(value = "course_id")Long course_id
            ,@Param(value = "course_mark")int course_mark);
}
