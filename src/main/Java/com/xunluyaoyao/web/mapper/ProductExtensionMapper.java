package com.xunluyaoyao.web.mapper;

import com.xunluyaoyao.web.pojo.ProductExtension;
import com.xunluyaoyao.web.pojo.ProductExtensionExample;

import java.util.List;

public interface ProductExtensionMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ProductExtension record);

    int insertSelective(ProductExtension record);

    List<ProductExtension> selectByExample(ProductExtensionExample example);

    ProductExtension selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ProductExtension record);

    int updateByPrimaryKey(ProductExtension record);
}