package com.kgc.controller;

import com.kgc.pojo.User;
import com.kgc.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("user")
public class UserController {
    @Resource
    UserService userService;
    @RequestMapping("")
    public String index(){
        return  "fore/homePage";
    }

    @RequestMapping("/toUserLogin")
    public String toUserLogin(String userName, String userPassword, HttpSession session){
        User userLogin = userService.getUserLogin(userName, userPassword);
        if (userLogin==null){
            return "redirect:/toUserLogin";
        }
        session.setAttribute("user",userLogin);
        return "fore/";
    }
}
