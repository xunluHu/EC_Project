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
    public List<User> list(User user) {
        return userMapper.list(user);
    }

    @Override
    public int add(User user) {
        return userMapper.add(user);
    }

    @Override
    public List<User> listName(User user) {
        return userMapper.listName(user);
    }

    @Override
    public User getByName(String name) {
        return userMapper.getByName(name);
    }
}
