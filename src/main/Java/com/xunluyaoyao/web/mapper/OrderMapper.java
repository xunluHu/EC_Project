package com.xunluyaoyao.web.mapper;


import com.xunluyaoyao.web.pojo.Order;

import java.util.List;

public interface OrderMapper {
    void createOrder(Order order);
    Order selectByOrderCode(String orderCode);
    List<Order> selectByUid(Integer uid);
}
