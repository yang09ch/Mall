package com.kgc.controller;

import com.kgc.service.CategoryService;
import com.kgc.service.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

@Controller
@RequestMapping("product")
public class ProductController  {
    @Resource
    ProductService productService;
    @Resource
    CategoryService categoryService;
    @GetMapping("/product")
    public String getProduct(String productName,Model model){
        model.addAttribute("searchValue",productName);//绑定到搜索框的值
        model.addAttribute("categoryList",categoryService.getCategoryAll());//商品类型

        for (int i=0;i<)
        model.addAttribute("productList",productService.getProductAll(productName));

        return  "fore/productListPage";
    }


}
