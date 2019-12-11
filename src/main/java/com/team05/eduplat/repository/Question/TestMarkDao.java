package com.team05.eduplat.repository.Question;

import com.team05.eduplat.entity.po.Question.TestMarkPo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
* @Author: Jing
* @Date: 2019/12/9
*/
public interface TestMarkDao extends JpaRepository<TestMarkPo,Integer> {
    @Query(value = "select mark from test_mark where test_id=:test_id and user_id=:user_id",nativeQuery = true)
    int findMark(@Param(value = "test_id")Long test_id, @Param(value = "user_id")Long user_id);
}
