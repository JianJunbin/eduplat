package com.team05.eduplat.entity.po.user;

import lombok.Data;
import javax.persistence.*;

/**
 * @program: eduplat
 * @description: TODO
 * @author: chen wenliang
 * @Date 2019/11/22
 **/
@Data
@Entity
@Table(name = "role")
public class RolePo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;
    @Column(name = "rolename")
    private String rolename;
    @Column(name = "namezh")
    private String namezh;

}
