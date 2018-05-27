package com.xunluyaoyao.web.service.impl;

import com.xunluyaoyao.web.mapper.ProductMapper;
import com.xunluyaoyao.web.pojo.Product;
import com.xunluyaoyao.web.pojo.ProductExample;
import com.xunluyaoyao.web.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    ProductMapper productMapper;
    @Override
    public List<Product> getALLProduct() {
        ProductExample example = new ProductExample();
        example.createCriteria().andIdIsNotNull();
        return productMapper.selectByExample(example);
    }

    @Override
    public List<Product> getProductByCid(Integer cid) {
        ProductExample example = new ProductExample();
        example.createCriteria().andCidEqualTo(cid);
        return productMapper.selectByExample(example);
    }

    @Override
    public void updateProductById(Product product) {
        productMapper.updateByPrimaryKey(product);
    }

    @Override
    public void insertProduct(Product product) {
        productMapper.insert(product);
    }

    @Override
    public void deleteByPrimaryKey(Integer id) {
        productMapper.deleteByPrimaryKey(id);
    }
}
