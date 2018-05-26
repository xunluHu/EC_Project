package com.xunluyaoyao.web.service;

import com.xunluyaoyao.web.pojo.Category;

import java.util.List;

public interface CategoryService {
    List<Category> list();
    List<Category> findNextCategory(Integer pcid);
    void addCategory(Category category);
}
