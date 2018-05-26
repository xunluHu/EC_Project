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
    @RequestMapping("/listCategory")
    void listCategory(HttpServletResponse response) throws IOException{
        response.setHeader("Content-Type", "text/html;charset=utf-8");
        PrintWriter out = response.getWriter();
        List<Category> list= categoryService.list();
        List array = new ArrayList();
        for (Category item: list) {
            JSONObject object = new JSONObject(item);
            array.add(object);
        }
        JSONArray ja = new JSONArray(array);
        System.out.println(ja.toString());
        out.write(ja.toString());
    }

    @RequestMapping("/findNextCategory")
    void findNextCategory(HttpServletResponse response, Integer id) throws IOException{
        response.setHeader("Content-Type", "text/html;charset=utf-8");
        PrintWriter out = response.getWriter();
        List<Category> list= categoryService.findNextCategory(id);
        List array = new ArrayList();
        for (Category item: list) {
            JSONObject object = new JSONObject(item);
            array.add(object);
        }
        JSONArray ja = new JSONArray(array);
        System.out.println(ja.toString());
        out.write(ja.toString());
    }
}
