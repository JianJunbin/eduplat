package com.team05.eduplat.repository.user;

import com.team05.eduplat.entity.po.user.RoleResourcePo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RoleResourceDao extends JpaRepository<RoleResourcePo,Long> {
    @Override
    <S extends RoleResourcePo> S save(S s);

    @Override
    void deleteById(Long aLong);

    RoleResourcePo findByResourceIdIs(long resourceId);

    List<RoleResourcePo> findByRoleId(long id);
}
