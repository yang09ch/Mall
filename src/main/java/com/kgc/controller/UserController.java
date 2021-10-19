package com.kgc.controller;

import com.kgc.pojo.User;
import com.kgc.service.AddressService;
import com.kgc.service.ProductService;
import com.kgc.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("user")
public class UserController {
    @Resource
    UserService userService;

    @Resource
    AddressService addressService;
    @RequestMapping("")
    public String index(Model model){
        return  "fore/homePage";
    }
    @RequestMapping("/UserLogin")
    public String UserLogin(){
        return "fore/loginPage";
    }
    @RequestMapping("/logout")
    public String logout(Model model,HttpSession session){
        session.removeAttribute("user");
        return "fore/homePage";
    }
    @RequestMapping("/register")
    public String register(Model model){
        model.addAttribute("addressList",addressService.addressList());
        model.addAttribute("cityList",addressService.cityList(110000));
        model.addAttribute("districtList",addressService.districtList(110100));
        return "fore/register";
    }

}
