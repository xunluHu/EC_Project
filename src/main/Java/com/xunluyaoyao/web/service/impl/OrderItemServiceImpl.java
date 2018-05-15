package com.xunluyaoyao.web.service.impl;

import com.xunluyaoyao.web.mapper.OrderItemMapper;
import com.xunluyaoyao.web.pojo.OrderItem;
import com.xunluyaoyao.web.service.OrderItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderItemServiceImpl implements OrderItemService {
    @Autowired
    OrderItemMapper orderItemMapper;
    @Override
    public void add(OrderItem orderItem) {
        orderItemMapper.add(orderItem);
    }

    @Override
    public OrderItem selectByPidAndUid(OrderItem orderItem) {
        return orderItemMapper.selectByPidAndUid(orderItem);
    }

    @Override
    public void update(OrderItem orderItem) {
        orderItemMapper.update(orderItem);
    }

    @Override
    public List<OrderItem> selectByUid(Integer uid) {
        return orderItemMapper.selectByUid(uid);
    }

    @Override
    public void deleteById(OrderItem orderItem) {
        orderItemMapper.deleteById(orderItem);
    }

    @Override
    public List<OrderItem> selectByUidInCart(Integer uid) {
        return orderItemMapper.selectByUidInCart(uid);
    }

    @Override
    public void updateOidAndNumber(OrderItem orderItem) {
        orderItemMapper.updateOidAndNumber(orderItem);
    }

    @Override
    public List<OrderItem> selectByOid(Integer oid) {
        return orderItemMapper.selectByOid(oid);
    }
}
