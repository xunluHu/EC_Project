package com.xunluyaoyao.web.controller;

import com.xunluyaoyao.web.pojo.Category;
import com.xunluyaoyao.web.pojo.Product;
import com.xunluyaoyao.web.service.CategoryService;
import com.xunluyaoyao.web.service.ProductService;
import com.xunluyaoyao.web.utils.PageResult;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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
public class ProductController {
    @Autowired
    ProductService productService;
    @Autowired
    CategoryService categoryService;
    @RequestMapping("/getProducts")
    void getProducts(HttpServletResponse response, Integer pageNum, Integer pageSize, String categoryName) throws IOException {
        System.out.println("pageNum " + pageNum + " pageSize " + pageSize);
        response.setHeader("Content-Type", "text/html;charset=utf-8");
        PrintWriter out = response.getWriter();
        List<Product> list = null;
        JSONObject res = new JSONObject();
        PageResult pageResult = null;
        if(categoryName == null) {
            pageResult = productService.findPage(pageNum, pageSize);
            list = pageResult.getRows();
            res.put("total", pageResult.getTotal());
        } else {
            Category category = categoryService.selectByName(categoryName);
            if (category == null) {
                out.write(res.toString());
                return;
            }
            Integer cid = category.getId();
            pageResult = productService.findPageByCid(pageNum, pageSize,cid);
            list = pageResult.getRows();
            res.put("total", pageResult.getTotal());
        }
        if(list != null) {
            List array = new ArrayList();
            for (Product item: list) {
                JSONObject object = new JSONObject(item);
                object.put("category", categoryService.selectByPrimaryKey(item.getCid()).getNAME());
                array.add(object);
            }
            JSONArray ja = new JSONArray(array);
            res.put("list", ja);
            System.out.println(res.toString());
            out.write(res.toString());
        } else {
            out.write("fail");
        }
    }

    @RequestMapping("/editProduct")
    @ResponseBody
    String editProduct(Product product, String categoryName) {
        Category category = categoryService.selectByName(categoryName);
        if (category == null) {
           return "category";
        }
        product.setCid(category.getId());
        product.setCreateDate(new Date());
        productService.updateProductById(product);
        return "success";
    }

    @RequestMapping("/addProduct")
    @ResponseBody
    String addProduct(Product product, String categoryName) {
        Category category = categoryService.selectByName(categoryName);
        if (category == null) {
            return "category";
        }
        product.setCid(category.getId());
        product.setCreateDate(new Date());
        productService.insertProduct(product);
        return "success";
    }

    @RequestMapping("/deleteProduct")
    @ResponseBody
    String deleteProduct(@RequestParam(value = "selectIds[]") Integer[] selectIds) {
        for(Integer id : selectIds) {
            productService.deleteByPrimaryKey(id);
        }
        return "success";
    }
}
