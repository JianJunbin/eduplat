package com.team05.eduplat.repository.user;

import com.team05.eduplat.entity.po.user.RolePo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RoleDao extends JpaRepository<RolePo,Long> {
    @Override
    <S extends RolePo> S save(S s);

    @Override
    void deleteById(Long aLong);

    @Override
    List<RolePo> findAll();

    RolePo findByRolenameEquals(String role);
}
