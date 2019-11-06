package com.team05.eduplat.entity.po;

import javax.persistence.*;

/**
 * @program: EduPlat
 * @description: pojo
 * @author: jian'jun'bin
 * @Date 2019-11-6 9:47
 **/
@Entity
@Table(name = "category")
public class CategoryPo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


}
