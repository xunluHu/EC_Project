package com.xunluyaoyao.web.service;

import com.xunluyaoyao.web.pojo.Product;
import com.xunluyaoyao.web.utils.PageResult;

import java.util.List;

public interface ProductService {
    List<Product> getALLProduct();
    List<Product> getProductByCid(Integer cid);
    void updateProductById(Product product);
    void insertProduct(Product product);
    void deleteByPrimaryKey(Integer id);
    PageResult findPage(int pageNum, int pageSize);
    PageResult findPageByCid(int pageNum, int pageSize, Integer cid);
}
