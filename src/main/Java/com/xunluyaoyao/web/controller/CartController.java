package com.xunluyaoyao.web.controller;


import com.xunluyaoyao.web.pojo.Order;
import com.xunluyaoyao.web.pojo.OrderItem;
import com.xunluyaoyao.web.pojo.User;
import com.xunluyaoyao.web.service.*;
import com.xunluyaoyao.web.utils.MailQueueProducer;
import com.xunluyaoyao.web.utils.UUIDUtil;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;


@Controller
public class CartController {
    @Autowired
    CategoryService categoryService;
    @Autowired
    ProductService productService;
    @Autowired
    OrderItemService orderItemService;
    @Autowired
    OrderService orderService;
    @Autowired
    UserService userService;
    @Autowired
    ProductSourceService productSourceService;
    @Autowired
    MailQueueProducer mailQueueProducer;

    @RequestMapping("/addCart")
    public void addCart(HttpServletResponse response, HttpSession session, Integer pid, Integer number) throws IOException {
        PrintWriter out = response.getWriter();
        User user = (User) session.getAttribute("user");
        if (user == null) {
            out.write("error");
        }
        OrderItem orderItem = new OrderItem();
        orderItem.setPid(pid);
        orderItem.setUid(user.getId());
        OrderItem result = orderItemService.selectByPidAndUid(orderItem);
        if (result == null) {
            orderItem.setNumber(number);
            orderItemService.add(orderItem);
        } else {
            orderItem.setNumber(number + result.getNumber());
            orderItemService.update(orderItem);
        }
        out.write("success");
    }

    @RequestMapping("/deleteProducts")
    public void deleteCart(HttpSession session, HttpServletResponse response, HttpServletRequest request) throws IOException {
        PrintWriter out = response.getWriter();
        User user = (User)session.getAttribute("user");
        OrderItem orderItem = new OrderItem();
        orderItem.setUid(user.getId());
        System.out.println("uid "+user.getId());
        if (user == null) {
            out.write("error");
        }
        //最原始打印json内是否有数据的方法
        BufferedReader reader = request.getReader();
        String json = "", line = "";
        while((line = reader.readLine()) != null) {
            json +=  line;
        }
        //System.out.println(json);
        reader.close();

        JSONObject jsonObject = new JSONObject(json);
        JSONArray pidArray = jsonObject.getJSONArray("pidArray");
        for (int i = 0; i < pidArray.length(); i++) {
            Integer pid = Integer.parseInt((String) pidArray.get(i));
            orderItem.setPid(pid);
            System.out.println("pid "+ pid);
            orderItemService.deleteById(orderItem);
        }
        out.write("success");
    }

    @RequestMapping("/deleteProduct")
    public void deleteProduct(HttpSession session, HttpServletResponse response, Integer pid) throws IOException {
        OrderItem orderItem = new OrderItem();
        orderItem.setUid(((User)session.getAttribute("user")).getId());
        orderItem.setPid(pid);
        orderItemService.deleteById(orderItem);
        PrintWriter out = response.getWriter();
        out.write("success");
    }

    @RequestMapping("/getIt")
    public void getIt(HttpSession session, HttpServletResponse response, HttpServletRequest request) throws IOException {
        PrintWriter out = response.getWriter();
        User user = userService.getByName(((User)session.getAttribute("user")).getName());

        OrderItem orderItem = new OrderItem();
        Order order = new Order();
        orderItem.setUid(user.getId());
        System.out.println("uid "+user.getId());
        if (user == null) {
            out.write("error");
        }
        BufferedReader reader = request.getReader();
        String json = "", line = "";
        while((line = reader.readLine()) != null) {
            json +=  line;
        }
        reader.close();
        JSONArray jsonArray = new JSONArray(json);
        Order res;
        if (jsonArray.length() > 0) {
            String orderCode = user.getId() + UUIDUtil.getOrderIdByUUId();
            order.setOrderCode(orderCode);
            order.setMobile(user.getMobile());
            order.setEmail(user.getEmail());
            order.setCreateDate(new Date());
            order.setUid(user.getId());
            orderService.createOrder(order);
            res = orderService.selectByOrderCode(orderCode);
            if(res == null) {
                out.write("error");
            }
        } else {
            out.write("error");
            return;
        }
        String emailContext = "<table border=\"1\">";
        for(int i = 0; i < jsonArray.length(); i++) {
            JSONObject object = jsonArray.getJSONObject(i);
            Integer pid = Integer.parseInt((String)object.get("pid"));
            orderItem.setPid(pid);
            orderItem.setNumber(Integer.parseInt((String)object.get("number")));
            orderItem.setOid(res.getId());
            orderItemService.updateOidAndNumber(orderItem);
            emailContext += "<tr>" +
                    "<th>" + productService.selectById(pid).getName() +"</th>" +
                    "<th>" + productSourceService.getProductSourceByPid(pid).get(0).getPansource() + "</th>" +
                    "</tr>";
        }
        emailContext += "</table>";
        System.out.println(emailContext);
        Map<String, String> requestMap = new HashMap<>();
        requestMap.put("email", user.getEmail());
        requestMap.put("code", emailContext);
        mailQueueProducer.sendMap(requestMap);
        out.write("success");
    }
}
