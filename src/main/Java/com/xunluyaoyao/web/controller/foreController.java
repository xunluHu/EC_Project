package com.xunluyaoyao.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class foreController {
    @RequestMapping("forehome")
    public String home(Model model) {
        return "fore/home";
    }
}
