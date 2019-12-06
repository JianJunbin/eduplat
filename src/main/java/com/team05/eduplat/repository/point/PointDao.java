package com.team05.eduplat.repository.point;

import com.team05.eduplat.entity.po.point.PointPo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PointDao extends JpaRepository<PointPo,Long> {
    @Override
    <S extends PointPo> S save(S s);
    PointPo findByUsernameEquals(String username);
}
