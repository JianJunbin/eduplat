package com.team05.eduplat.repository;

import com.team05.eduplat.entity.po.CourseTestPo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * @Author: Jing
 * @Date: 2019/11/27
 */
public interface CourseTestDao extends JpaRepository<CourseTestPo,Integer> {
//    @Override
//    Page<CourseTestPo> findAll(Pageable pageable);

    @Modifying
    @Query(value = "select * from course_test where user_id=:user_id",nativeQuery = true)
    List<CourseTestPo> findAllByUser_id(@Param(value = "user_id")long user_id);

    @Modifying
    @Query(value = "update course_test set isdelete=1 where test_id=:id",nativeQuery=true)
    void deleteTest(@Param(value = "id") long id);

    @Modifying
    @Query(value = "update course_test set isdelete=0 where test_id=:id",nativeQuery=true)
    void recoverTest(@Param(value = "id")long id);
}
