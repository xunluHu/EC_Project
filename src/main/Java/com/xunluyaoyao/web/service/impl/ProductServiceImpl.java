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
    public List<Product> selectById(int cid) {
        return productMapper.selectById(cid);
    }
}
