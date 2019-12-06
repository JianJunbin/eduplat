package com.team05.eduplat.repository.user;

import com.team05.eduplat.entity.po.user.ResourcePo;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ResourceDao extends JpaRepository<ResourcePo,Long> {
    @Override
    Page<ResourcePo> findAll(Pageable pageable);

    @Override
    List<ResourcePo> findAll();

    ResourcePo findByIdEquals(long id);

    @Override
    void deleteById(Long aLong);

    @Override
    <S extends ResourcePo> S save(S s);
}
