package com.xunluyaoyao.web.mapper;

import com.xunluyaoyao.web.pojo.User;

import java.util.List;

public interface UserMapper {
    public List<User> list(User user);
    public int add(User user);
    public List<User> listName(User user);
}
