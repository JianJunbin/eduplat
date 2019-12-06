package com.team05.eduplat.entity.vo.Video;

import lombok.Data;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Data
public class VideoVo {


    @NotNull(message = "名字不能为空")
    public String name;
    public String remark;
    public int course;
    public int chapter;
    public int section;
    @NotNull(message = "名字不能为空")
    public String url;
    public int uid;
}
