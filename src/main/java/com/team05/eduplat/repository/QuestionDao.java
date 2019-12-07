package com.team05.eduplat.repository;

import com.team05.eduplat.entity.po.QuestionPo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
* @Author: Jing
* @Date: 2019/11/25
*/
public interface QuestionDao extends JpaRepository<QuestionPo,Integer> {
    @Override
    Page<QuestionPo> findAll(Pageable pageable);

    QuestionPo findById(Long question_id);

    @Modifying
    @Query(value = "update questions set isdelete=1 where question_id=:id",nativeQuery=true)
    void deleteQuestion(@Param(value = "id") Long id);


    @Modifying
    @Query(value = "update questions set isdelete=0 where question_id=:id",nativeQuery=true)
    void recoverQuestion(@Param(value = "id")Long id);

}
