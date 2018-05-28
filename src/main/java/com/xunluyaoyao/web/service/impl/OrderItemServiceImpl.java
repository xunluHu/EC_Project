package com.xunluyaoyao.web.service.impl;

import com.xunluyaoyao.web.mapper.OrderItemMapper;
import com.xunluyaoyao.web.pojo.OrderItem;
import com.xunluyaoyao.web.pojo.OrderItemExample;
import com.xunluyaoyao.web.service.OrderItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderItemServiceImpl implements OrderItemService {
    @Autowired
    OrderItemMapper orderItemMapper;
    @Override
    public List<OrderItem> selectOrderItemByOid(Integer oid) {
        OrderItemExample example = new OrderItemExample();
        example.createCriteria().andOidEqualTo(oid);
        return orderItemMapper.selectByExample(example);
    }
}
