package com.xunluyaoyao.web.service;

import com.xunluyaoyao.web.pojo.Order;
import com.xunluyaoyao.web.utils.PageResult;

import java.util.List;

public interface OrderService {
    PageResult findPage(Integer pageNum, Integer pageSize);
    PageResult findPageByContext(Integer pageNum, Integer pageSize, List<Integer> uids, String orderCode);
}
