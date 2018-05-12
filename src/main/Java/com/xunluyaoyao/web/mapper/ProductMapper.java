package com.xunluyaoyao.web.mapper;

import com.xunluyaoyao.web.pojo.Product;

import java.util.List;

public interface ProductMapper {
    public List<Product> selectById(int cid);

    public List<Product> selectByContext(String context);
}
