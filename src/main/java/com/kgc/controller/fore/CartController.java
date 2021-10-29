package com.kgc.controller.fore;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("cart")
public class CartController {

    @RequestMapping("/cart")
    public String goCart(HttpSession session){
        if (session.getAttribute("user")==null){
            return "redirect:user/UserLogin";
        }
        return "fore/productBuyCarPage";
    }
}
