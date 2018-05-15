package com.xunluyaoyao.web.service;

import com.xunluyaoyao.web.pojo.Order;

import java.util.List;

public interface OrderService {
    void createOrder(Order order);
    Order selectByOrderCode(String orderCode);
    List<Order> selectByUid(Integer uid);
}
