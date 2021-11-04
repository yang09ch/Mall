package com.kgc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CeshiController {
    @RequestMapping("/a1")
    public String index(){
        return "fore/productPaySuccessPage";
    }
    @RequestMapping("/a2")
    public String index2(){
        return "fore/productPayPage";
    }
    @RequestMapping("/a3")
    public String index3(){
        return "fore/productBuyPage";
    }
}
