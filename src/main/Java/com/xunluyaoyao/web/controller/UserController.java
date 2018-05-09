package com.xunluyaoyao.web.controller;

import com.xunluyaoyao.web.pojo.User;
import com.xunluyaoyao.web.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@Controller
@RequestMapping("")
public class UserController {
    @Autowired
    UserService userService;

    @RequestMapping("/user_login")
    public void list(Model model, User user, HttpServletResponse response)  throws IOException {
        List<User> us = userService.list(user);            response.setHeader("Content-Type", "text/html;charset=utf-8");
        PrintWriter out = response.getWriter();
        if( us.size() == 0) {
            out.print("failure");
        } else {
            //TODO：如果有那么带着成功登录的信息去首页
            out.print("success");
        }
    }

    @RequestMapping("/user_register")
    @ResponseBody
    public User add(User user) {
        //数据库的username设置unique约束直接插入会抛出异常
        System.out.println(user.getName() + " " + user.getPassword());
        List<User> us = userService.listName(user);
        if (us.size() == 0) {
            userService.add(user);
        } else {
            System.out.println("有同名用户不允许插入");
            user.setName("");
        }
        return user;
    }
}