package com.team05.eduplat.entity.po;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 * @program: eduplat
 * @description: 题目持久对象
 * @author: Jing
 * @create: 2019-11-18 11:38
 **/
@Entity
@Table(name="questions")
public class QuestionPo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "question_id")
    private long id;

    @Column(name = "question_type")
    private int type;

    @Column(name = "question_content")
    private String content;

    @Column(name = "question_option1")
    private String option1;
    @Column(name = "question_option2")
    private String option2;
    @Column(name = "question_option3")
    private String option3;
    @Column(name = "question_option4")
    private String option4;

    @Column(name = "question_answer")
    private String answer;

    @Column(name = "question_description")
    private String q_description;

    @Column(name = "question_tag1")
    private  int tag1;
    @Column(name = "question_tag2")
    private  int tag2;
    @Column(name = "question_tag3")
    private  int tag3;

    @Column(name = "user_id")
    private long user_id;

    @Column(name = "course_id")
    private long course_id;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getOption1() {
        return option1;
    }

    public void setOption1(String option1) {
        this.option1 = option1;
    }

    public String getOption2() {
        return option2;
    }

    public void setOption2(String option2) {
        this.option2 = option2;
    }

    public String getOption3() {
        return option3;
    }

    public void setOption3(String option3) {
        this.option3 = option3;
    }

    public String getOption4() {
        return option4;
    }

    public void setOption4(String option4) {
        this.option4 = option4;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public String getQ_description() {
        return q_description;
    }

    public void setQ_description(String q_description) {
        this.q_description = q_description;
    }

    public int getTag1() {
        return tag1;
    }

    public void setTag1(int tag1) {
        this.tag1 = tag1;
    }

    public int getTag2() {
        return tag2;
    }

    public void setTag2(int tag2) {
        this.tag2 = tag2;
    }

    public int getTag3() {
        return tag3;
    }

    public void setTag3(int tag3) {
        this.tag3 = tag3;
    }

    public long getUser_id() {
        return user_id;
    }

    public void setUser_id(long user_id) {
        this.user_id = user_id;
    }

    public long getCourse_id() {
        return course_id;
    }

    public void setCourse_id(long course_id) {
        this.course_id = course_id;
    }
}
