package com.team05.eduplat.repository;

import com.team05.eduplat.entity.po.QuestionPo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
* @Author: Jing
* @Date: 2019/11/25
*/
public interface QuestionDao extends JpaRepository<QuestionPo,Integer> {
    @Override
    Page<QuestionPo> findAll(Pageable pageable);

}
