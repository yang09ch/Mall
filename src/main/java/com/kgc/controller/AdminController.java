package com.kgc.controller;

import com.kgc.pojo.Admin;
import com.kgc.service.AdminService;
import com.kgc.service.CategoryService;
import com.kgc.service.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.math.BigDecimal;

@Controller
@RequestMapping("admin")
public class AdminController {
    @Resource
    AdminService adminService;
    @RequestMapping("")
    public String index(){
        return "/admin/loginPage";
    }
//管理员登录
    @RequestMapping("/getLogin")
    public String getLogin(String adminName, String adminPassword, HttpSession session){
        Admin adminLogin = adminService.getAdminLogin(adminName, adminPassword);
        if (adminLogin==null){
            return "redirect:/getLogin";
        }
       session.setAttribute("admin",adminLogin);
        return "admin/homePage";
    }

    @Resource
    ProductService productService;//产品
    @Resource
    CategoryService categoryService;//产品类型
    @RequestMapping("/getProductLimit")
    public String getProductLimit(String productName, BigDecimal firstPrice, BigDecimal lastPrice,@RequestParam(value = "productCategoryId",defaultValue = "-1") Integer productCategoryId, @RequestParam(value = "pageIndex",defaultValue = "1") Integer pageIndex, Model model ,@RequestParam(value = "checkbox_product_isEnabled",required = false) Object...productIsEnabled){
      model.addAttribute("productList",productService.getProductLimit(productName,firstPrice,lastPrice,productCategoryId,pageIndex,10,productIsEnabled));
      model.addAttribute("categoryList",categoryService.getCategoryAll());
      return "admin/homePage";
    }

}
