package com.xunluyaoyao.web.service.impl;

import com.xunluyaoyao.web.mapper.ProductExtensionMapper;
import com.xunluyaoyao.web.pojo.ProductExtension;
import com.xunluyaoyao.web.pojo.ProductExtensionExample;
import com.xunluyaoyao.web.service.ProductSourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductSourceServiceImpl implements ProductSourceService {
@Autowired
ProductExtensionMapper productExtensionMapper;

    @Override
    public void add(ProductExtension productExtension) {
        productExtensionMapper.insert(productExtension);
    }

    @Override
    public List<ProductExtension> getProductSourceByPid(Integer pid) {
        ProductExtensionExample example = new ProductExtensionExample();
        example.createCriteria().andPidEqualTo(pid);
        return productExtensionMapper.selectByExample(example);
    }

    @Override
    public int updateByPrimaryKeySelective(ProductExtension record) {
        return productExtensionMapper.updateByPrimaryKeySelective(record);
    }
}
