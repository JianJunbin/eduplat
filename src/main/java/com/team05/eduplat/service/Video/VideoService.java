package com.team05.eduplat.service.Video;


import com.sun.deploy.security.ruleset.DRSHelper;
import com.team05.eduplat.entity.po.Video.VideoPo;
import com.team05.eduplat.entity.vo.Video.VideoVo;
import com.team05.eduplat.repository.Video.VideoDao;
import com.team05.eduplat.utils.Result.ResultEnum;
import com.team05.eduplat.utils.Result.ResultHelper;
import com.team05.eduplat.utils.Result.ResultMessage;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.http.converter.feed.RssChannelHttpMessageConverter;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.channels.FileChannel;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

@Service
@Transactional
public class VideoService {
    @Autowired
    VideoDao videoDao;
    @Value("${prop.upload-folder}")
    String uploadFolder;

    public ResultMessage add(VideoVo vvo){
        VideoPo videoPo = new VideoPo();
        BeanUtils.copyProperties(vvo, videoPo);
        videoDao.save(videoPo);
        return ResultHelper.result(ResultEnum.SUCCESS);
    }


    public ResultMessage findAll(int userId) {
        List<VideoPo> videoPos = videoDao.findAllById(userId);
        List<VideoVo> videoVos = new LinkedList<>();
        videoPos.forEach(e->{
            System.out.println(e.getName());
            VideoVo videoVo = new VideoVo();
            BeanUtils.copyProperties(e,videoVo);
            videoVos.add(videoVo);
        });
        return ResultHelper.result(ResultEnum.SUCCESS)
                .put("videoVos",videoVos);
    }

}
