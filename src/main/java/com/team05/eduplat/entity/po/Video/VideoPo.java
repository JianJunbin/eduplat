package com.team05.eduplat.entity.po.Video;

import javax.persistence.*;

@Entity
@Table(name = "video")
public class VideoPo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "video_id")
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "remark")
    private String remark;

    @Column(name = "course")
    private int course;

    @Column(name = "chapter")
    private int chapter;

    @Column(name = "section")
    private int section;

    @Column(name = "video_url")
    private String url;

    @Column(name = "owner_id")
    private int uid;

    @Column(name = "flag",nullable = false)
    private Boolean flag;

    public Boolean getFlag() {
        return flag;
    }

    public void setFlag(Boolean flag) {
        this.flag = flag;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public int getCourse() {
        return course;
    }

    public void setCourse(int course) {
        this.course = course;
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

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

}