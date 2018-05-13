package com.xunluyaoyao.web.service.impl;

import com.xunluyaoyao.web.mapper.ProductMapper;
import com.xunluyaoyao.web.pojo.Product;
import com.xunluyaoyao.web.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    ProductMapper productMapper;
    @Override
    public List<Product> selectByCategoryId(int cid) {
        return productMapper.selectByCategoryId(cid);
    }

    @Override
    public List<Product> selectByContext(String context) {
        return productMapper.selectByContext(context);
    }

    @Override
    public Product selectById(int id) {
        return productMapper.selectById(id);
    }
}
