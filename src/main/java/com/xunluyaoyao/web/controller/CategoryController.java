package com.xunluyaoyao.web.controller;

import com.xunluyaoyao.web.pojo.Category;
import com.xunluyaoyao.web.service.CategoryService;
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
import java.util.List;

@Controller
@RequestMapping("")
public class CategoryController {
    @Autowired
    CategoryService categoryService;
    @RequestMapping("/listRootCategory")
    void listRootCategory(HttpServletResponse response, Integer pcid) throws IOException{
        response.setHeader("Content-Type", "text/html;charset=utf-8");
        PrintWriter out = response.getWriter();
        List<Category> list= categoryService.findNextCategory(pcid);
        List array = new ArrayList();
        for (Category item: list) {
            JSONObject object = new JSONObject(item);
            array.add(object);
        }
        JSONArray ja = new JSONArray(array);
        System.out.println(ja.toString());
        out.write(ja.toString());
    }

    @RequestMapping("/addCategory")
    void addCategory(HttpServletResponse response, Category category) throws IOException{
        response.setHeader("Content-Type", "text/html;charset=utf-8");
        PrintWriter out = response.getWriter();
        categoryService.addCategory(category);
        out.write("success");
    }

    @RequestMapping("/editCategory")
    void editCategory(HttpServletResponse response, Category category) throws IOException{
        response.setHeader("Content-Type", "text/html;charset=utf-8");
        PrintWriter out = response.getWriter();
        categoryService.updateByPrimaryKey(category);
        out.write("success");
    }
}
