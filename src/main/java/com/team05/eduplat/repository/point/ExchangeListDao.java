package com.team05.eduplat.repository.point;

import com.team05.eduplat.entity.po.point.ExchangeListPo;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExchangeListDao extends JpaRepository<ExchangeListPo,Long> {
    @Override
    <S extends ExchangeListPo> S save(S s);

    @Override
     Page<ExchangeListPo> findAll(Pageable pageable);
    ExchangeListPo findById(long id);

}
