package com.team05.eduplat.entity.po.user;

import lombok.Data;

import javax.persistence.*;

/**
 * @program: eduplat
 * @description: TODO
 * @author: chen wenliang
 * @Date 2019/11/26
 **/
@Data
@Entity
@Table(name = "role_resource")
public class RoleResourcePo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;
    @Column(name = "ro_id")
    private long roleId;
    @Column(name = "re_id")
    private long resourceId;
}
