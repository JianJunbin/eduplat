package com.team05.eduplat.entity.po;

import javax.persistence.*;

/**
 * @program: eduplat
 * @description: 试卷题目持久对象
 * @author: Jing
 * @create: 2019-11-27 17:19
 **/
@Entity
@Table(name = "test_question")
public class TestQuestionPo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "test_id")
    private long test_id;

    @Column(name = "question_id")
    private long question_id;

//    @Column(name = "isdelete")
//    private int isdelete;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getTest_id() {
        return test_id;
    }

    public void setTest_id(long test_id) {
        this.test_id = test_id;
    }

    public long getQuestion_id() {
        return question_id;
    }

    public void setQuestion_id(long question_id) {
        this.question_id = question_id;
    }

//    public int getIsdelete() {
//        return isdelete;
//    }
//
//    public void setIsdelete(int isdelete) {
//        this.isdelete = isdelete;
//    }
}
