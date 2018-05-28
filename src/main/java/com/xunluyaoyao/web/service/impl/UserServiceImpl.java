package com.xunluyaoyao.web.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.xunluyaoyao.web.mapper.UserMapper;
import com.xunluyaoyao.web.pojo.User;
import com.xunluyaoyao.web.pojo.UserExample;
import com.xunluyaoyao.web.service.UserService;
import com.xunluyaoyao.web.utils.PageResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserMapper userMapper;

    @Override
    public PageResult findPage(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        Page<User> page = (Page<User>)userMapper.selectByExample(null);
        return new PageResult(page.getTotal(), page.getResult());
    }

    @Override
    public PageResult findPageByContext(int pageNum, int pageSize, User user) {
        PageHelper.startPage(pageNum, pageSize);
        UserExample example = new UserExample();
        UserExample.Criteria criteria= example.createCriteria();
        if(user.getNAME() != null) {
            criteria.andNAMELike(user.getNAME());
        }
        if(user.getEmail() != null) {
            criteria.andEmailLike(user.getEmail());
        }
        if(user.getMobile() != null) {
            criteria.andMobileLike(user.getMobile());
        }
        if(user.getSTATUS() != null) {
            criteria.andSTATUSEqualTo(user.getSTATUS());
        }
        Page<User> page = (Page<User>)userMapper.selectByExample(example);
        return new PageResult(page.getTotal(), page.getResult());
    }

    @Override
    public void editUser(User user) {
        userMapper.updateByPrimaryKey(user);
    }

    @Override
    public void addUser(User user) {
        userMapper.insert(user);
    }

    @Override
    public User selectByPrimaryKey(Integer id) {
        return userMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<User> getUserByName(String name) {
        UserExample example = new UserExample();
        UserExample.Criteria criteria= example.createCriteria();
        if(name != null) {
            criteria.andNAMELike(name);
        }
        return userMapper.selectByExample(example);
    }
}
