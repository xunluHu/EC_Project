package com.xunluyaoyao.web.service.impl;

import com.xunluyaoyao.web.mapper.UserMapper;
import com.xunluyaoyao.web.pojo.User;
import com.xunluyaoyao.web.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    UserMapper userMapper;

    @Override
    public User getByPasswordAndName(User user) {
        return userMapper.getByPasswordAndName(user);
    }

    @Override
    public void add(User user) {
        userMapper.add(user);
    }

    @Override
    public User getByName(String name) {
        return userMapper.getByName(name);
    }

    @Override
    public User getByCode(String code) {
        return userMapper.getByCode(code);
    }

    @Override
    public void setStatus(String status) {
        userMapper.setStatus(status);
    }
}
