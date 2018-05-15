package com.xunluyaoyao.web.service;

import com.xunluyaoyao.web.pojo.User;

import java.util.List;

public interface UserService {
    public User getByPasswordAndName(User user);
    public void add(User user);
    public User getByName(String name);
    public User getByCode(String code);
    public void setStatus(String status);
}
