package com.team05.eduplat.repository.user;

import com.team05.eduplat.entity.po.user.UserRolePo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRoleDao extends JpaRepository<UserRolePo,Long> {
    @Override
    <S extends UserRolePo> S save(S s);
}
