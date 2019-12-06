package com.team05.eduplat.entity.po;

import javax.persistence.*;

/**
 * @program: EduPlat
 * @description: 课程订单实体类
 * @author: jian'jun'bin
 * @Date 2019-11-29 15:57
 **/
@Entity
@Table(name = "course_order")
public class CourseOrderPo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id")
    private Long orderId;
    @Column(nullable = false)
    private Long userId;
    @Column(nullable = false)
    private Long courseId;
    private int status;
    private int courseMark;

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getCourseId() {
        return courseId;
    }

    public void setCourseId(Long courseId) {
        this.courseId = courseId;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getCourseMark() {
        return courseMark;
    }

    public void setCourseMark(int courseMark) {
        this.courseMark = courseMark;
    }
}
