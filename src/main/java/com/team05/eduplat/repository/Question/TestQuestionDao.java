package com.team05.eduplat.repository.Question;

import com.team05.eduplat.entity.po.Question.TestQuestionPo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.List;

public interface TestQuestionDao extends JpaRepository<TestQuestionPo,Integer>{
    @Modifying
    @Query(value = "select question_id from test_question where test_id=:test_id",nativeQuery = true)
    List<Long> findAllByTest_id (@Param(value = "test_id")Long test_id);

    @Modifying
    @Transactional
    @Query(value = "delete from test_question where question_id=:question_id and test_id=:test_id",nativeQuery = true)
    void deleteTestQuestion(@Param(value = "test_id")Long test_id,@Param(value = "question_id")Long question_id);
}
