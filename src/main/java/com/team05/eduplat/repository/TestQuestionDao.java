package com.team05.eduplat.repository;

import com.team05.eduplat.entity.po.TestQuestionPo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TestQuestionDao extends JpaRepository<TestQuestionPo,Integer>{
    @Modifying
    @Query(value = "select question_id from test_question where test_id=:test_id",nativeQuery = true)
    List<Integer> findAllByTest_id (@Param(value = "test_id")long test_id);
}
