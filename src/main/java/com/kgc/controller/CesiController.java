package com.kgc.controller;

import com.kgc.service.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

@Controller
public class CesiController {
    @Resource
    ProductService productService;

    @RequestMapping("/u")
    public String index8(Model model){
        return "admin/homePage";
    }

}
