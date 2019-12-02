package com.team05.eduplat.repository;

import com.team05.eduplat.entity.po.CourseOrderPo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @program: EduPlat
 * @description: TODO
 * @author: jian'jun'bin
 * @Date 2019-11-29 16:13
 **/
public interface CourseOrderDao extends JpaRepository<CourseOrderPo,Integer> {
    List<CourseOrderPo> findByUserIdAndStatus(Long userId,int status);
}
