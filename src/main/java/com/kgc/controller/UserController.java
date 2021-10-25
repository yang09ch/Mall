package com.kgc.controller;
import com.kgc.pojo.Address;
import com.kgc.pojo.User;
import com.kgc.service.AddressService;
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
    UserService userService;//用户service
    @Resource
    AddressService addressService;//地址service
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
        session.invalidate();
        return "redirect:/UserLogin";
    }
    @RequestMapping("/register")
    public String register(Model model){
        model.addAttribute("addressList",addressService.addressList());
        model.addAttribute("cityList",addressService.cityList("110000"));
        model.addAttribute("districtList",addressService.districtList("110100"));
        return "fore/register";
    }
    @RequestMapping("/userDetails")
    public String userDetailsc(Model model, HttpSession session){//绑定数据
        User user = (User) session.getAttribute("user");
       if (user!=null){
           String substring = user.getUserAddress().substring(0,2);
           Address address = addressService.getByUserAddress(user.getUserAddress());
           substring+="0000";//省
           model.addAttribute("addressId",substring);
           model.addAttribute("districtAddressId",address.getAddressAreaId());
           model.addAttribute("cityAddressId",address.getAddressRegionId());
           model.addAttribute("addressList",addressService.addressList());
           model.addAttribute("cityList",addressService.cityList(substring));
           model.addAttribute("districtList",addressService.districtList(addressService.cityList(substring).get(0).getAddressAreaId()));
           return "fore/userDetails";
       }
       return "redirect:/user/UserLogin";
    }
}
