package com.xunluyaoyao.web.controller;

import com.xunluyaoyao.web.pojo.Order;
import com.xunluyaoyao.web.pojo.OrderItem;
import com.xunluyaoyao.web.pojo.User;
import com.xunluyaoyao.web.service.OrderItemService;
import com.xunluyaoyao.web.service.OrderService;
import com.xunluyaoyao.web.service.ProductService;
import com.xunluyaoyao.web.service.UserService;
import com.xunluyaoyao.web.utils.PageResult;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
public class OrderController {
    @Autowired
    ProductService productService;
    @Autowired
    UserService userService;
    @Autowired
    OrderService orderService;
    @Autowired
    OrderItemService orderItemService;

    @RequestMapping("/getOrders")
    @ResponseBody
    String getOrders(Integer pageNum, Integer pageSize, String userName, String orderCode) {
        JSONObject res = new JSONObject();
        JSONArray resList = null;
        PageResult pageResult = null;
        List<Order>  orderList = null;
        if(userName == null && orderCode == null) {
            pageResult = orderService.findPage(pageNum, pageSize);
        } else {
            List<User> userList = userService.getUserByName(userName);
            //模糊搜索用户名，遍历出所有可能的id
            List<Integer> ids = new ArrayList<Integer>();
            for(User user : userList) {
                ids.add(user.getId());
            }
            pageResult = orderService.findPageByContext(pageNum, pageSize, ids, orderCode);
        }
        res.put("total", pageResult.getTotal());
        orderList = pageResult.getRows();
        resList = new JSONArray(orderList);
        for (int i = 0; i < resList.length(); ++i) {
            JSONObject tmp = resList.getJSONObject(i);
            Integer uid = (Integer) tmp.get("uid");
            Integer oid = (Integer) tmp.get("id");
            String name = userService.selectByPrimaryKey(uid).getNAME();
            List<OrderItem> orderItems = orderItemService.selectOrderItemByOid(oid);
            List<String> orderItemNames = new ArrayList<String>();
            for(OrderItem orderItem : orderItems) {
                orderItemNames.add(productService.selectByPrimaryKey(orderItem.getPid()).getNAME());
            }
            tmp.put("userName", name);
            tmp.put("orderItemNames", orderItemNames);
            resList.put(i, tmp);
        }
        res.put("list", resList);
        System.out.println(res.toString());
        return res.toString();
    }

}
