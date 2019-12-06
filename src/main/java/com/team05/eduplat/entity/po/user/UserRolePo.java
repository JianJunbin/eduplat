package com.team05.eduplat.entity.po.user;

import lombok.Data;

import javax.persistence.*;

/**
 * @program: eduplat
 * @description: TODO
 * @author: chen wenliang
 * @Date 2019/11/26
 **/
@Entity
@Data
@Table(name = "user_role")
public class UserRolePo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;
    @Column(name = "u_id")
    private long u_id;
    @Column(name = "r_id")
    private long r_id;
}
