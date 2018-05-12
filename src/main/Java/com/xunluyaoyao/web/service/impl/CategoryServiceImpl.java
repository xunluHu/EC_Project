package com.xunluyaoyao.web.service.impl;

import com.xunluyaoyao.web.mapper.CategoryMapper;
import com.xunluyaoyao.web.pojo.Category;
import com.xunluyaoyao.web.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    CategoryMapper categoryMapper;
    public Category selectByPrimaryKey(Integer id) {
        return categoryMapper.selectByPrimaryKey(id);
    }
}
