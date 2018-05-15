package com.xunluyaoyao.web.controller;

import com.xunluyaoyao.web.pojo.OrderItem;
import com.xunluyaoyao.web.pojo.User;
import com.xunluyaoyao.web.service.UserService;
import com.xunluyaoyao.web.utils.MailUtil;
import com.xunluyaoyao.web.utils.TestUtil;
import com.xunluyaoyao.web.utils.UUIDUtil;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@Controller
@RequestMapping("")
public class UserController {
    @Autowired
    UserService userService;
    //这个版本require不设置成false通讯异常
    @RequestMapping("/user_login")
    public void list(Model model, User user, @RequestParam(value="isChecked",required = false) boolean isRemember,
                     HttpServletResponse response, HttpSession session)  throws IOException {
        response.setHeader("Content-Type", "text/html;charset=utf-8");
        User res = userService.getByPasswordAndName(user);
        PrintWriter out = response.getWriter();
        if(res == null) {
            out.print("failure");
        } else {
            //TODO：如果有那么带着成功登录的信息去首页
            session.setAttribute("user", res);
            if (isRemember) {
                Cookie token = new Cookie("token", user.getName());
                token.setMaxAge(60 * 60 * 24 * 7);
                token.setPath("/");
                response.addCookie(token);
            }
            out.print("success");
        }
    }

    @RequestMapping("/user_register")
    @ResponseBody
    public void add(HttpSession session, HttpServletResponse response, HttpServletRequest request) throws IOException{
        PrintWriter out = response.getWriter();
        BufferedReader reader = request.getReader();
        String json = "", line = "";
        while((line = reader.readLine()) != null) {
            json +=  line;
        }
        System.out.println(json);
        reader.close();
        JSONObject jsonObject = new JSONObject(json);
        String name = (String)jsonObject.get("name");
        String password = (String)jsonObject.get("password");
        String email = (String)jsonObject.get("email");
        String mobile = (String)jsonObject.get("mobile");
        String verification_code = UUIDUtil.getOrderIdByUUId();
        if(userService.getByName(name) != null) {
            out.write("nameRepeat");
            return;
        }
        User user = new User();
        user.setName(name);
        user.setPassword(password);
        user.setEmail(email);
        if(mobile != null && mobile.length() > 0 && TestUtil.isNumeric(mobile)) {
            user.setMobile(mobile);
        }
        user.setVerification_code(verification_code);
        userService.add(user);
        try {
            new Thread(new MailUtil(email, verification_code)).run();
        } catch (Exception e) {
            out.write("emailError");
            return;
        }
        out.write("success");
    }

    @RequestMapping("/user_checkLogin")
    @ResponseBody
    public void checkLogin(HttpSession session, HttpServletResponse response) throws IOException{
        PrintWriter out = response.getWriter();
        if(session.getAttribute("user") != null) {
            out.write("success");
        } else {
            out.write("error");
        }
    }

    @RequestMapping("/activeUser")
    public void activeUser(Model model, HttpSession session, HttpServletRequest request, HttpServletResponse response) throws IOException{
        response.setContentType("text/html;charset=UTF-8");
        String code = request.getParameter("code");
        User user = (User)userService.getByCode(code);
        PrintWriter out = response.getWriter();
        if (user == null) {
            out.write("验证失败");
            response.setHeader("refresh", "3;url=/");
            return;
        } else if(user.getStatus().contains("normal")) {
            out.write("请勿重复验证");
        } else {
            userService.setStatus(code);
            out.write("邮箱验证通过");
        }
        session.setAttribute("user", user);
        model.addAttribute("user", user);
        response.setHeader("refresh", "3;url=/");
    }
}
