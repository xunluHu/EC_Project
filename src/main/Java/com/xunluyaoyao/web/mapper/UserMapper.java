package com.xunluyaoyao.web.mapper;

import com.xunluyaoyao.web.pojo.User;


public interface UserMapper {
    public User getByPasswordAndName(User user);
    public void add(User user);
    public User getByName(String name);
    public User getByCode(String code);
    public void setStatus(String status);
}
