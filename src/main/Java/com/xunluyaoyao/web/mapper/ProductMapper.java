package com.xunluyaoyao.web.mapper;

import com.xunluyaoyao.web.pojo.Product;

import java.util.List;

public interface ProductMapper {
    public List<Product> selectByCategoryId(int cid);

    public List<Product> selectByContext(String context);

    public Product selectById(int id);

}
