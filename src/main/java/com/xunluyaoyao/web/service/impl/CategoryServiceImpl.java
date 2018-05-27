package com.xunluyaoyao.web.service.impl;

import com.xunluyaoyao.web.mapper.CategoryMapper;
import com.xunluyaoyao.web.pojo.Category;
import com.xunluyaoyao.web.pojo.CategoryExample;
import com.xunluyaoyao.web.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService{
    @Autowired
    CategoryMapper categoryMapper;
    @Override
    public List<Category> list() {
        CategoryExample categoryExample = new CategoryExample();
        categoryExample.createCriteria().andPcidEqualTo(0);
        return categoryMapper.selectByExample(categoryExample);
    }

    @Override
    public List<Category> findNextCategory(Integer pcid) {
        CategoryExample categoryExample = new CategoryExample();
        categoryExample.createCriteria().andPcidEqualTo(pcid);
        return categoryMapper.selectByExample(categoryExample);
    }

    @Override
    public Category selectByPrimaryKey(Integer id) {
        return categoryMapper.selectByPrimaryKey(id);
    }

    @Override
    public Category selectByName(String name) {
        CategoryExample categoryExample = new CategoryExample();
        categoryExample.createCriteria().andNAMEEqualTo(name);
        return categoryMapper.selectByExample(categoryExample).get(0);
    }

    @Override
    public void addCategory(Category category) {
        categoryMapper.insert(category);
    }

    @Override
    public int updateByPrimaryKey(Category record) {
        return categoryMapper.updateByPrimaryKey(record);
    }
}
