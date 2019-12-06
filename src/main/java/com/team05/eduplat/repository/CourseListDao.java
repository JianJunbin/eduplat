package com.team05.eduplat.repository;

import com.team05.eduplat.entity.po.CourseListPo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * @program: EduPlat
 * @description: TODO
 * @author: jian'jun'bin
 * @Date 2019-11-25 10:32
 **/
public interface CourseListDao extends JpaRepository<CourseListPo,Integer> {
    @Query(value = "select *from course_list where course_id=?1 order by pid,node_id",nativeQuery = true)
    List<CourseListPo> findByCourseId(Long courseId);

    @Query(value = "select node_name from course_list where course_id=:course_id and node_id=:node_id",nativeQuery = true)
    String getNodeName(@Param(value = "course_id")Long course_id, @Param(value = "node_id")Long node_id);
}
