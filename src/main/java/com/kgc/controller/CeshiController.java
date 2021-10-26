package com.kgc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CeshiController {
    @RequestMapping("/aaaaa")
    public String index(){
        return "fore/productDetailsPage";
    }
}
