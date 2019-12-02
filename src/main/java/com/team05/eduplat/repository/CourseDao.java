package com.team05.eduplat.repository;

import com.team05.eduplat.entity.po.CoursePo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.transaction.annotation.Transactional;

/**
 * @program: EduPlat
 * @description: TODO
 * @author: jian'jun'bin
 * @Date 2019-11-25 21:33
 **/
public interface CourseDao extends JpaRepository<CoursePo,Integer> {
    Page<CoursePo> findByUserId(Pageable pageable,Long userId);

    @Modifying
    @Transactional
    void deleteByCourseId(Long courseId);

    CoursePo findByCourseId(Long courseId);
}
