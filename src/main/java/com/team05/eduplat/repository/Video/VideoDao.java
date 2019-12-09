package com.team05.eduplat.repository.Video;

import com.team05.eduplat.entity.po.Video.VideoPo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface VideoDao extends JpaRepository<VideoPo,Integer>{
    @Query(value = "select *from video where owner_id=?1",nativeQuery = true)
    List<VideoPo> findAllById(int userId);

}