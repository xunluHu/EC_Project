package com.xunluyaoyao.web.service;

import com.xunluyaoyao.web.pojo.User;

import java.util.List;

public interface UserService {
    List<User> list(User user);
    int add(User user);
    List<User> listName(User user);
    public User getByName(String name);
}
