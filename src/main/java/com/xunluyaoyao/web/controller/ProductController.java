package com.xunluyaoyao.web.controller;

import com.xunluyaoyao.web.pojo.Category;
import com.xunluyaoyao.web.pojo.Product;
import com.xunluyaoyao.web.service.CategoryService;
import com.xunluyaoyao.web.service.ProductService;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("")
public class ProductController {
    @Autowired
    ProductService productService;
    @Autowired
    CategoryService categoryService;
    @RequestMapping("/getProducts")
    void getProducts(HttpServletResponse response, String categoryName) throws IOException {
        response.setHeader("Content-Type", "text/html;charset=utf-8");
        PrintWriter out = response.getWriter();
        List<Product> list = null;
        if(categoryName == null) {
            list = productService.getALLProduct() ;
        } else {
            Integer cid = categoryService.selectByName(categoryName).getId();
            list = productService.getProductByCid(cid);
        }
        if(list != null) {
            List array = new ArrayList();
            for (Product item: list) {
                JSONObject object = new JSONObject(item);
                object.put("category", categoryService.selectByPrimaryKey(item.getCid()).getNAME());
                array.add(object);
            }
            JSONArray ja = new JSONArray(array);
            System.out.println(ja.toString());
            out.write(ja.toString());
        } else {
            out.write("fail");
        }
    }

    @RequestMapping("/addProduct")
    @ResponseBody
    String addProduct(Product product, String categoryName) {
        Category category = categoryService.selectByName(categoryName);
        System.out.println(category == null);
        if (category == null) {
           return "category";
        }
        product.setCid(category.getId());
        product.setCreateDate(new Date());
        productService.updateProductById(product);
        return "success";
    }
}
