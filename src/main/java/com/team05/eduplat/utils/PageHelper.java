package com.team05.eduplat.utils;

import com.team05.eduplat.entity.vo.PageinfoVo;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: EduPlat
 * @description: TODO
 * @author: jian'jun'bin
 * @Date 2019-11-11 10:55
 **/
public class PageHelper {
    public static Pageable initPage(PageinfoVo pageinfoVo){

        List<Sort.Order> list = new ArrayList<>();
        if (pageinfoVo.getOrder()) {
            for (String sortFieldName : pageinfoVo.getSortFieldNames()) {
                list.add(Sort.Order.asc(sortFieldName));
            }
        } else {
            for (String sortFieldName : pageinfoVo.getSortFieldNames()) {
                list.add(Sort.Order.desc(sortFieldName));
            }
        }
        return PageRequest.of(pageinfoVo.getIndexPageNum() - 1, pageinfoVo.getSize(), Sort.by(list));
    }
}
