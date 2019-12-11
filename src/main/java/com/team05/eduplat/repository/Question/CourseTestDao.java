package com.team05.eduplat.repository.Question;

import com.team05.eduplat.entity.po.Question.CourseTestPo;
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

    @Query(value = "select * from course_test where course_id=:course_id",nativeQuery = true)
    List<CourseTestPo> findAllByCourse_id(@Param(value = "course_id")Long course_id);

    @Query(value = "select * from course_test where course_id=:course_id and chapter=:chapter and section=:section",nativeQuery = true)
    CourseTestPo findTest(@Param(value = "course_id")Long course_id,@Param(value = "chapter")Long chapter
            ,@Param(value = "section")Long section);

    @Modifying
    @Query(value = "update course_test set question_num=:question_num where test_id=:test_id",nativeQuery = true)
    void editTest(@Param(value = "test_id")Long test_id,@Param(value = "question_num")int question_num);

    @Modifying
    @Query(value = "update course_test set isdelete=1 where test_id=:id",nativeQuery=true)
    void deleteTest(@Param(value = "id") Long id);

    @Modifying
    @Query(value = "update course_test set isdelete=0 where test_id=:id",nativeQuery=true)
    void recoverTest(@Param(value = "id")Long id);
}
