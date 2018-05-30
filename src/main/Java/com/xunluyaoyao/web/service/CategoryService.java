package com.xunluyaoyao.web.service;

import com.xunluyaoyao.web.pojo.Category;

import java.util.List;

public interface CategoryService {
    Category selectByPrimaryKey(Integer id);
    List<Category> getParentCategorys();
    List<Category> getNextCategorys(Integer pcid);
    List<Category> findParentAndNextCategorys(Integer id);
}
