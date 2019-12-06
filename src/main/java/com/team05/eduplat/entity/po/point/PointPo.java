package com.team05.eduplat.entity.po.point;

import lombok.Data;

import javax.persistence.*;

/**
 * @program: eduplat
 * @description: TODO
 * @author: chen wenliang
 * @Date 2019/11/29
 **/
@Data
@Entity
@Table(name = "point")
public class PointPo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;
    @Column(name = "points")
    private int points;
    @Column(name = "username")
    private String username;

}
