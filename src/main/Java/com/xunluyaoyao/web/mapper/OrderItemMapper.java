package com.xunluyaoyao.web.mapper;

import com.xunluyaoyao.web.pojo.OrderItem;
import org.springframework.core.annotation.Order;

import java.util.List;

public interface OrderItemMapper {
    public void add(OrderItem orderItem);
    public OrderItem selectByPidAndUid(OrderItem orderItem);
    public void update(OrderItem orderItem);
    public List<OrderItem> selectByUid(Integer uid);
    public void deleteById(OrderItem orderItem);
}

