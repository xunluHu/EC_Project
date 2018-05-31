package com.xunluyaoyao.web.service;

import com.xunluyaoyao.web.pojo.ProductExtension;

import java.util.List;

public interface ProductSourceService {
    void add(ProductExtension productExtension);

    List<ProductExtension> getProductSourceByPid(Integer pid);

    int updateByPrimaryKeySelective(ProductExtension record);
}
