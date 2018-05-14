package com.xunluyaoyao.web.controller;

import com.xunluyaoyao.web.pojo.Category;
import com.xunluyaoyao.web.pojo.OrderItem;
import com.xunluyaoyao.web.pojo.Product;
import com.xunluyaoyao.web.pojo.User;
import com.xunluyaoyao.web.service.CategoryService;
import com.xunluyaoyao.web.service.OrderItemService;
import com.xunluyaoyao.web.service.ProductService;
import com.xunluyaoyao.web.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class ForeController {
    @Autowired
    CategoryService categoryService;
    @Autowired
    ProductService productService;
    @Autowired
    UserService userService;
    @Autowired
    OrderItemService orderItemService;

    @RequestMapping("forehome")
    public String home(Model model, HttpSession session, HttpServletRequest request) {
        User user = (User) session.getAttribute("user");
        if (user == null) {
            Cookie cookies[] = request.getCookies();
            if (cookies != null) {
                for (Cookie cookie : cookies) {
                    if (cookie.getName().contains("token")) {
                        user = userService.getByName(cookie.getValue());
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
    public String categoryMove(Model model, int id) {
        Category category = categoryService.selectByPrimaryKey(id);
        model.addAttribute("c", category);
        return "fore/category";
    }

    @RequestMapping("productSearch")
    public String productSearch(Model model, String context) {
        model.addAttribute("products", productService.selectByContext(context));
        return "fore/productSearch";
    }

    @RequestMapping("foreProduct")
    public String productPage(Model model, Integer pid) {
        System.out.println("id value is" + pid);
        model.addAttribute("p", productService.selectById(pid));
        return "fore/product";
    }

    @RequestMapping("foreCart")
    public String fortCart(Model model, HttpSession session) {
        User user = (User)session.getAttribute("user");
        if(user == null) {
            return "redirect:/html/login.html";
        }
        List<OrderItem> listOrder = orderItemService.selectByUid(user.getId());
        model.addAttribute("os", listOrder);
        return "fore/cart";
    }
}
