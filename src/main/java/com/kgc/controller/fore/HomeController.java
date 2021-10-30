package com.kgc.controller.fore;

import com.kgc.pojo.Category;
import com.kgc.pojo.Product;
import com.kgc.service.CategoryService;
import com.kgc.service.ProductService;
import com.kgc.service.ProductimageService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Controller
public class HomeController {
    @Resource
    CategoryService categoryService;
    @Resource
    ProductService productService;
    @Resource
    ProductimageService productimageService;
    @RequestMapping("/")
    public String index(){
        return "redirect:/home";
    }
    //首页
    @RequestMapping("/home")
    public String index0(Model model){
        List<Category> categoryList = categoryService.getCategoryAll();//商品类型集合
     for (int i=0;i<categoryList.size();i++){
            Category category=categoryList.get(i);
            category.setProductList(productService.getProductArray(category.getCategoryId()));
         for (int j=0;j<category.getProductList().size();j++){
             Product product = category.getProductList().get(j);
                product.setSingleProductImageList(productimageService.getProductimgeList(product.getProductId()));
            }
        }
        model.addAttribute("categoryList",categoryList);
        model.addAttribute("specialProductList",productService.getLunPo());//轮播
        return "fore/homePage";
    }


}
