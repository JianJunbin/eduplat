package com.team05.eduplat.entity.po.Question;

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
    private Long id;

    @Column(name = "course_id")
    private Long course_id;

    @Column(name = "chapter")
    private Long chapter;

    @Column(name = "section")
    private Long section;

    @Column(name = "question_num")
    private int question_num;

    @Column(name = "user_id")
    private Long user_id;

    @Column(name = "isdelete")
    private int isdelete;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCourse_id() {
        return course_id;
    }

    public void setCourse_id(Long course_id) {
        this.course_id = course_id;
    }

    public Long getChapter() {
        return chapter;
    }

    public void setChapter(Long chapter) {
        this.chapter = chapter;
    }

    public Long getSection() {
        return section;
    }

    public void setSection(Long section) {
        this.section = section;
    }

    public int getQuestion_num() {
        return question_num;
    }

    public void setQuestion_num(int question_num) {
        this.question_num = question_num;
    }

    public Long getUser_id() {
        return user_id;
    }

    public void setUser_id(Long user_id) {
        this.user_id = user_id;
    }

    public int getIsdelete() {
        return isdelete;
    }

    public void setIsdelete(int isdelete) {
        this.isdelete = isdelete;
    }

}
