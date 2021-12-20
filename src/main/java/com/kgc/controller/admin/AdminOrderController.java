package com.kgc.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
public class AdminOrderController {


    @RequestMapping("/order")
    public String getToPage(){
        return "admin/orderManagePage";
    }
}
