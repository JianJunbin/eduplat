package com.team05.eduplat.repository.Video;

import com.team05.eduplat.entity.po.Video.VideoPo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface  VideoDao extends  JpaRepository<VideoPo, Integer>{
}
