package com.xunluyaoyao.web.mapper;

import com.xunluyaoyao.web.pojo.Category;

import java.util.List;

public interface CategoryMapper {

    Category selectByPrimaryKey(Integer id);

    int delete(Category category);

    int insert(Category category);

    int update(Category category);
}
