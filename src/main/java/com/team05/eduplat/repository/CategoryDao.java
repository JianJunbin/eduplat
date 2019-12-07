package com.team05.eduplat.repository;

import com.team05.eduplat.entity.po.CategoryPo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @program: EduPlat
 * @description: 针对Category类的DAO, Integer表示主键是Integer类型。
 * JpaRepository 这个父接口，就提供了CRUD, 分页等等一系列的查询
 * @author: jian'jun'bin
 * @Date 2019-11-6 9:53
 **/
public interface CategoryDao extends JpaRepository<CategoryPo,Integer> {
    @Override
    Page<CategoryPo> findAll(Pageable pageable);
}
