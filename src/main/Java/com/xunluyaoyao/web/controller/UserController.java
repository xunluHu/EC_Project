package com.xunluyaoyao.web.controller;

import com.xunluyaoyao.web.pojo.User;
import com.xunluyaoyao.web.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("")
public class UserController {
    @Autowired
    UserService userService;

    @RequestMapping("/user_list")
    public String list(Model model, User user) {
        System.out.println(user.getName() + " " + user.getPassword());
        List<User> us = userService.list(user);
        if(us.isEmpty()) {
            System.out.println("账号或者密码出错");
        }
        return "redirect:/html/login.html";
    }
}
