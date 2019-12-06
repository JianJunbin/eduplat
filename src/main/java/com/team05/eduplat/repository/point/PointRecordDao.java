package com.team05.eduplat.repository.point;

import com.team05.eduplat.entity.po.point.PointRecordPo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PointRecordDao extends JpaRepository<PointRecordPo,Long> {
    @Override
    <S extends PointRecordPo> S save(S s);
    Page<PointRecordPo> findByPointId(long p_id,Pageable pageable);
}
