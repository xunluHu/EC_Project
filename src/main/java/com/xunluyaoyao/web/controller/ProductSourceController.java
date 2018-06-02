package com.xunluyaoyao.web.controller;

import com.xunluyaoyao.web.pojo.ProductExtension;
import com.xunluyaoyao.web.service.ProductSourceService;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.List;

@Controller
public class ProductSourceController {
    @Autowired
    ProductSourceService productSourceService;
    @RequestMapping("/addProductSource")
    @ResponseBody
    String addProductSource(HttpServletRequest request, String panSource, MultipartFile file, Integer id) {
        System.out.println(file.getOriginalFilename());
        System.out.println(id);
        String suffix = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf(".") + 1);
        // 判断文件是否为空
        if (!file.isEmpty()) {
            try {
                // 文件保存路径
                String filePath = request.getSession().getServletContext().getRealPath("/") + "images/productsImage/" + id + "." + suffix;
                System.out.println(filePath);
                File path = new File(filePath);
                if (!path.exists()) {
                    path.mkdirs();
                }
                // 转存文件
                file.transferTo(new File(filePath));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        ProductExtension productExtension = new ProductExtension();
        productExtension.setPansource(panSource);
        productExtension.setPid(id);
        productExtension.setTYPE(suffix);
        if (productSourceService.getProductSourceByPid(id).size() == 0) {
            productSourceService.add(productExtension);
        } else {
            productExtension.setId(productSourceService.getProductSourceByPid(id).get(0).getId());
            productSourceService.updateByPrimaryKeySelective(productExtension);
        }
        return "success";
    }

    @RequestMapping("/getProductResource")
    @ResponseBody
    String  getProductResource(Integer id) {
        JSONObject res = new JSONObject();
        List<ProductExtension> list = productSourceService.getProductSourceByPid(id);
        if (list.size() != 0) {
            res.put("suffix", list.get(0).getTYPE());
            res.put("pid", list.get(0).getPid());
            res.put("panSource", list.get(0).getPansource());
        }
        return res.toString();
    }
}
