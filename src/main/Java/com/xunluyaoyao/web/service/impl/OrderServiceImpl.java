package com.xunluyaoyao.web.service.impl;

import com.xunluyaoyao.web.mapper.OrderMapper;
import com.xunluyaoyao.web.pojo.Order;
import com.xunluyaoyao.web.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    OrderMapper orderMapper;

    @Override
    public void createOrder(Order order) {
        orderMapper.createOrder(order);
    }

    @Override
    public Order selectByOrderCode(String orderCode) {
        return orderMapper.selectByOrderCode(orderCode);
    }

    @Override
    public List<Order> selectByUid(Integer uid) {
        return orderMapper.selectByUid(uid);
    }
}