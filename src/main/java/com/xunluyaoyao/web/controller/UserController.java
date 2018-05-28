package com.xunluyaoyao.web.controller;

import com.xunluyaoyao.web.pojo.Category;
import com.xunluyaoyao.web.pojo.Product;
import com.xunluyaoyao.web.pojo.User;
import com.xunluyaoyao.web.service.CategoryService;
import com.xunluyaoyao.web.service.ProductService;
import com.xunluyaoyao.web.service.UserService;
import com.xunluyaoyao.web.utils.PageResult;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("")
public class UserController {
    @Autowired
    UserService userService;

    @RequestMapping("/getUsers")
    @ResponseBody
    String getUsers(User user, Integer pageNum, Integer pageSize){
        System.out.println("pageNum " + pageNum + " pageSize " + pageSize);
        System.out.println("name" + user.getNAME());
        JSONObject res = new JSONObject();
        PageResult pageResult = null;
        if(user == null || (user != null && user.getNAME() == null && user.getMobile() == null
                && user.getEmail() == null && user.getSTATUS() == null)  ) {
            pageResult = userService.findPage(pageNum, pageSize);
        } else {
            System.out.println("search By content");
            pageResult = userService.findPageByContext(pageNum, pageSize, user);
        }
        res.put("total", pageResult.getTotal());
        res.put("list", pageResult.getRows());
        System.out.println(res.toString());
        return res.toString();
    }

    @RequestMapping("/editUser")
    @ResponseBody
    String editProduct(User user) {
        userService.editUser(user);
        return "success";
    }

    @RequestMapping("/addUser")
    @ResponseBody
    String addProduct(User user) {
        userService.addUser(user);
        return "success";
    }
}
