package com.team05.eduplat.entity.vo.point;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

/**
 * @program: eduplat
 * @description: TODO
 * @author: chen wenliang
 * @Date 2019/11/29
 **/
@Data
public class PointRecordVo {
    private long id;
    private int changePoints;
    private String changeRemark;
    private Date changeTime;
    private long pointId;
}
