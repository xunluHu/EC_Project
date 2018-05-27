package com.xunluyaoyao.web.service;

import com.xunluyaoyao.web.pojo.Category;

import java.util.List;

public interface CategoryService {
    List<Category> list();
    List<Category> findNextCategory(Integer pcid);
    Category selectByPrimaryKey(Integer id);
    Category selectByName(String name);
    void addCategory(Category category);
    int updateByPrimaryKey(Category record);
}
