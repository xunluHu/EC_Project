package com.xunluyaoyao.web.service;

import com.xunluyaoyao.web.pojo.OrderItem;

import java.util.List;

public interface OrderItemService {
    List<OrderItem> selectOrderItemByOid(Integer oid);
}
