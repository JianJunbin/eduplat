package com.team05.eduplat.entity.po.Question;

import javax.persistence.*;

/**
 * @program: eduplat
 * @description: 试卷分数持久类
 * @author: Jing
 * @create: 2019-12-09 09:43
 **/
@Entity
@Table(name = "test_mark")
public class TestMarkPo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "mark_id")
    private Long id;

    @Column(name = "test_id")
    private Long test_id;

    @Column(name = "user_id")
    private Long user_id;

    @Column(name = "mark")
    private int mark;

    @Column(name = "isdelete")
    private int isdelete;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getTest_id() {
        return test_id;
    }

    public void setTest_id(Long test_id) {
        this.test_id = test_id;
    }

    public Long getUser_id() {
        return user_id;
    }

    public void setUser_id(Long user_id) {
        this.user_id = user_id;
    }

    public int getMark() {
        return mark;
    }

    public void setMark(int mark) {
        this.mark = mark;
    }

    public int getIsdelete() {
        return isdelete;
    }

    public void setIsdelete(int isdelete) {
        this.isdelete = isdelete;
    }
}
