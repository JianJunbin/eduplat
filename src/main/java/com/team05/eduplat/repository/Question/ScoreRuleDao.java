package com.team05.eduplat.repository.Question;

import com.team05.eduplat.entity.po.Question.ScoreRulePo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ScoreRuleDao extends JpaRepository<ScoreRulePo,Integer> {
//    查询课程规则
    @Query(value = "select * from score_rule where course_id=:course_id and  chapter=:chapter",nativeQuery = true)
    ScoreRulePo getCourseRule(@Param(value = "course_id")Long course_id,@Param(value = "chapter")Long chapter);
}
