package com.kgc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CesiController {

    //订单
    @RequestMapping("/c")
    public String index3(){
        return "admin/orderManagePage";
    }
    //产品
    @RequestMapping("/d")
    public String index4(){
        return "admin/productManagePage";
    }
    //用户查询 用户列表
    @RequestMapping("/e")
    public String index5(){
        return "admin/userManagePage";
    }
    //分类查询
    @RequestMapping("/f")
    public String index6(){
        return "admin/categoryManagePage";
    }
    //管理员 详细信息  修改密码
    @RequestMapping("/g")
    public String index7(){
        return "admin/accountManagePage";
    }

    //
    @RequestMapping("/u")
    public String index8(){
        return "admin/homePage";
    }
    //首页
    @RequestMapping("/")
    public String index0(){
        return "fore/homePage";
    }
}
