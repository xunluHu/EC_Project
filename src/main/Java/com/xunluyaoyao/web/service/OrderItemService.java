package com.xunluyaoyao.web.service;

import com.xunluyaoyao.web.pojo.OrderItem;

import java.util.List;

public interface OrderItemService {
    public void add(OrderItem orderItem);
    public OrderItem selectByPidAndUid(OrderItem orderItem);
    public void update(OrderItem orderItem);
    public List<OrderItem> selectByUid(Integer uid);
    public void deleteById(OrderItem orderItem);
}
