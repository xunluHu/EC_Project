package com.xunluyaoyao.web.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.xunluyaoyao.web.mapper.OrderMapper;
import com.xunluyaoyao.web.pojo.Order;
import com.xunluyaoyao.web.pojo.OrderExample;
import com.xunluyaoyao.web.service.OrderService;
import com.xunluyaoyao.web.utils.PageResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService{
    @Autowired
    OrderMapper orderMapper;

    @Override
    public PageResult findPage(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        Page<Order> page = (Page<Order>)orderMapper.selectByExample(null);
        return new PageResult(page.getTotal(), page.getResult());
    }

    @Override
    public PageResult findPageByContext(Integer pageNum, Integer pageSize, List<Integer> uids, String orderCode) {
        PageHelper.startPage(pageNum, pageSize);
        OrderExample example = new OrderExample();
        OrderExample.Criteria criteria = example.createCriteria();
        if (uids != null) {
            criteria.andUidIn(uids);
        }
        if (orderCode != null) {
            criteria.andOrderCodeLike(orderCode);
        }
        Page<Order> page = (Page<Order>)orderMapper.selectByExample(example);
        return new PageResult(page.getTotal(), page.getResult());
    }
}
