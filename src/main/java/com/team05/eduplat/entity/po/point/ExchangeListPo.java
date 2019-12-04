package com.team05.eduplat.entity.po.point;

import lombok.Data;

import javax.persistence.*;

/**
 * @program: eduplat
 * @description: TODO
 * @author: chen wenliang
 * @Date 2019/12/3
 **/
@Data
@Entity
@Table(name = "exchange_list")
public class ExchangeListPo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;
    @Column(name = "view_id")
    private long viewId;
    @Column(name = "point_price")
    private int pointPrice;
}
