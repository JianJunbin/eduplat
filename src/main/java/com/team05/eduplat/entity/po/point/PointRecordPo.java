package com.team05.eduplat.entity.po.point;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

/**
 * @program: eduplat
 * @description: TODO
 * @author: chen wenliang
 * @Date 2019/11/29
 **/
@Data
@Entity
@Table(name = "point_record")
public class PointRecordPo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;
    @Column(name = "change_points")
    private int changePoints;
    @Column(name = "change_remark")
    private String changeRemark;
    @Column(name = "change_time")
    private Date changeTime;

    @Column(name = "p_id")
    private long pointId;
}
