package com.xunluyaoyao.web.service;

import com.xunluyaoyao.web.pojo.User;
import com.xunluyaoyao.web.utils.PageResult;

import java.util.List;

public interface UserService {
    PageResult findPage(int pageNum, int pageSize);
    PageResult findPageByContext(int pageNum, int pageSize, User user);
    void editUser(User user);
    void addUser(User user);
}
