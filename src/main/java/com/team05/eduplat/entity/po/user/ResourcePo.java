package com.team05.eduplat.entity.po.user;


import lombok.Data;
import org.springframework.data.jpa.repository.Query;

import javax.persistence.*;
import java.util.List;

/**
 * @program: eduplat
 * @description: TODO
 * @author: chen wenliang
 * @Date 2019/11/22
 **/
@Data
@Entity
@Table(name = "resource")
public class ResourcePo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;
    @Column(name = "path")
    private String path;
    @Column(name = "url")
    private String url;
    @Column(name = "icon")
    private String icon;
    @Column(name = "component")
    private String component;
    @Column(name = "resourcename")
    private String resourcename;
    @Column(name = "requireauth")
    private String requireauth;
    @Column(name = "parent")
    private long parentId;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "role_resource", joinColumns = {@JoinColumn(name = "re_id",referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "ro_id",referencedColumnName = "id")})
    private List<RolePo>rolePos;
}
