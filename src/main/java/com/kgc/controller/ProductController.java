package com.kgc.controller;

import com.kgc.pojo.Product;
import com.kgc.service.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.util.List;

@Controller
@RequestMapping("product")
public class ProductController  {
    @Resource
    ProductService productService;
    @Resource
    CategoryService categoryService;
    @Resource
    ProductimageService productimageService;
    @Resource
    ProductorderitemService productorderitemService;
    @Resource
    ReviewService reviewService;
    @GetMapping("/product")
    public String getProduct(String productName,Model model){
        model.addAttribute("searchValue",productName);//绑定到搜索框的值
        model.addAttribute("categoryList",categoryService.getCategoryAll());//商品类型
        List<Product> productAll = productService.getProductAll(productName);
        for(int i=0;i<productAll.size();i++){
            Product product = productAll.get(i);
            product.setSingleProductImageList(productimageService.getProductImgeYulan(product.getProductId()));
            product.setProductReviewCount(reviewService.getReviewCount(product.getProductId()));
            product.setProductSaleCount(productorderitemService.getProductorderItemCount(product.getProductId()));
        }
        model.addAttribute("productList",productAll);
        return  "fore/productListPage";
    }


}
