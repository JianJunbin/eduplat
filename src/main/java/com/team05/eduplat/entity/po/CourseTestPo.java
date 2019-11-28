package com.team05.eduplat.entity.po;

import javax.persistence.*;

/**
 * @program: eduplat
 * @description: 试卷持久对象
 * @author: Jing
 * @create: 2019-11-27 16:17
 **/

@Entity
@Table(name = "course_test")
public class CourseTestPo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "test_id")
    private long id;

    @Column(name = "course_id")
    private long course_id;

    @Column(name = "chapter")
    private int chapter;

    @Column(name = "section")
    private int section;

    @Column(name = "question_num")
    private int question_num;

    @Column(name = "user_id")
    private long user_id;

    @Column(name = "isdelete")
    private int isdelete;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getCourse_id() {
        return course_id;
    }

    public void setCourse_id(long course_id) {
        this.course_id = course_id;
    }

    public int getChapter() {
        return chapter;
    }

    public void setChapter(int chapter) {
        this.chapter = chapter;
    }

    public int getSection() {
        return section;
    }

    public void setSection(int section) {
        this.section = section;
    }

    public int getQuestion_num() {
        return question_num;
    }

    public void setQuestion_num(int question_num) {
        this.question_num = question_num;
    }

    public long getUser_id() {
        return user_id;
    }

    public void setUser_id(long user_id) {
        this.user_id = user_id;
    }

    public int getIsdelete() {
        return isdelete;
    }

    public void setIsdelete(int isdelete) {
        this.isdelete = isdelete;
    }

}
