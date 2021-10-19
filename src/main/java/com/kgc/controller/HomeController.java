package com.kgc.controller;

import com.kgc.pojo.Category;
import com.kgc.pojo.Product;
import com.kgc.service.CategoryService;
import com.kgc.service.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.util.Map;

@Controller
public class HomeController {
    @Resource
    CategoryService categoryService;
    @Resource
    ProductService productService;
    //首页
    @RequestMapping("/")
    public String index0(Map<String,Object> map, Model model){
        model.addAttribute("categoryList",categoryService.getCategoryAll());
        model.addAttribute("specialProductList",productService.getLunPo());//轮播
        return "fore/homePage";
    }

}
