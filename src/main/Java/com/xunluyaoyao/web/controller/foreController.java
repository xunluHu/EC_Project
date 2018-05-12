package com.xunluyaoyao.web.controller;

import com.xunluyaoyao.web.pojo.Category;
import com.xunluyaoyao.web.pojo.User;
import com.xunluyaoyao.web.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Controller
public class foreController {
    @Autowired
    CategoryService categoryService;

    @RequestMapping("forehome")
    public String home(Model model, HttpSession session, HttpServletRequest request) {
        User user = (User) session.getAttribute("user");
        if (user == null) {
            Cookie cookies[] = request.getCookies();
            if (cookies != null) {
                for (Cookie cookie : cookies) {
                    if (cookie.getName().contains("token")) {
                        user = new User();
                        user.setName(cookie.getValue());
                        session.setAttribute("user", user);
                    }
                }
            }
        }
        model.addAttribute("user", user);
        return "fore/home";
    }

    @RequestMapping("forelogout")
    public String logout(Model model, HttpSession session, HttpServletResponse response) {
        session.removeAttribute("user");
        Cookie token = new Cookie("token", "");
        token.setMaxAge(0);
        token.setPath("/");
        response.addCookie(token);
        return "fore/home";
    }

    @RequestMapping("Category")
    public String home(Model model, int id) {
        Category category = categoryService.selectByPrimaryKey(id);
        model.addAttribute("c", category);
        return "fore/category";
    }
}