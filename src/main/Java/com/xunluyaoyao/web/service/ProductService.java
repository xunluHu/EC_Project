package com.xunluyaoyao.web.service;

import com.xunluyaoyao.web.pojo.Product;

import java.util.List;

public interface ProductService {
    public List<Product> selectById(int cid);
}
