package com.team05.eduplat.service;

import com.team05.eduplat.entity.po.CategoryPo;
import com.team05.eduplat.entity.vo.CategoryVo;
import com.team05.eduplat.repository.CategoryDao;
import com.team05.eduplat.utils.Result.ResultEnum;
import com.team05.eduplat.utils.Result.ResultHelper;
import com.team05.eduplat.utils.Result.ResultMessage;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.LinkedList;
import java.util.List;

/**
 * @program: EduPlat
 * @description: TODO
 * @author: jian'jun'bin
 * @Date 2019-11-6 9:59
 **/
@Service
@Transactional
public class CategoryService {
    @Autowired
    CategoryDao categoryDao;
    public ResultMessage findAll() {
        List<CategoryVo> categoryVos = new LinkedList<CategoryVo>();
        List<CategoryPo> categoriePos = categoryDao.findAll();
        categoriePos.forEach(e -> {
            CategoryVo categoryVo = new CategoryVo();
            BeanUtils.copyProperties(e,categoryVo);
            categoryVos.add(categoryVo);
        });
        return ResultHelper.result(ResultEnum.SUCCESS)
                .put("category", categoryVos);
    }
}
