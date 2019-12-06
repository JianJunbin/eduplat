package com.team05.eduplat.repository.user;

import com.team05.eduplat.entity.po.user.UserPo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserDao extends JpaRepository<UserPo,Long> {
    @Override
    Page<UserPo> findAll(Pageable pageable);

    UserPo findByUsername(String username);

    UserPo findByMail(String mail);

    @Override
    <S extends UserPo> S save(S s);
}
