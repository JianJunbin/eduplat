package com.team05.eduplat.repository;

import com.team05.eduplat.entity.po.CoursePo;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @program: EduPlat
 * @description: TODO
 * @author: jian'jun'bin
 * @Date 2019-11-25 21:33
 **/
public interface CourseDao extends JpaRepository<CoursePo,Integer> {
}
