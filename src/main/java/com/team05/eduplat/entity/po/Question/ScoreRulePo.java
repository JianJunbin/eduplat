package com.team05.eduplat.entity.po.Question;

import javax.persistence.*;

/**
 * @program: eduplat
 * @description: 持久类
 * @author: Jing
 * @create: 2019-12-10 17:11
 **/
@Entity
@Table(name = "score_rule")
public class ScoreRulePo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "rule_id")
    private Long id;

    @Column(name = "user_id")
    private Long user_id;

    @Column(name = "course_id")
    private Long course_id;

    @Column(name = "chapter")
    private Long chapter;

    @Column(name = "video_proportion")
    private int video_proportion;

    @Column(name = "question_proportion")
    private int question_proportion;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUser_id() {
        return user_id;
    }

    public void setUser_id(Long user_id) {
        this.user_id = user_id;
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

    public int getVideo_proportion() {
        return video_proportion;
    }

    public void setVideo_proportion(int video_proportion) {
        this.video_proportion = video_proportion;
    }

    public int getQuestion_proportion() {
        return question_proportion;
    }

    public void setQuestion_proportion(int question_proportion) {
        this.question_proportion = question_proportion;
    }
}
