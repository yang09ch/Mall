package com.kgc.controller.fore;

import com.kgc.pojo.Product;
import com.kgc.pojo.Productorder;
import com.kgc.pojo.Productorderitem;
import com.kgc.pojo.User;
import com.kgc.service.*;
import com.kgc.util.PageUtil;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class OrderController {
    @Resource
    CategoryService categoryService;
    @Resource
    ProductorderService productorderService;
    @Resource
    ProductorderitemService productorderitemService;
    @Resource
    ProductimageService productimageService;
    @Resource
    ProductService productService;
    @Resource
    ReviewService reviewService;
    @RequestMapping("/order/{pageIndex}/{pageSize}")//详情展示
    public String goToOrderList(@PathVariable("pageIndex") Integer pageIndex, @PathVariable("pageSize") Integer pageSize, String status, HttpSession session, Model model){
        User user = (User)session.getAttribute("user");
        if (user==null){
            return "redirect:/user/UserLogin";
        }
        PageUtil<Productorder> pageUtil = productorderService.getProductorderLimit(status,user.getUserId(),pageIndex, pageSize);
        List<Productorder> list = pageUtil.getList();
        for (int i=0;i<list.size();i++){
            Productorder productorder = list.get(i);
            productorder.setProductOrderItemList(productorderitemService.getProductorderItemList(productorder.getProductOrderId()));
            List<Productorderitem> itemList = productorder.getProductOrderItemList();
            for (int j=0;j<itemList.size();j++){
                Productorderitem productorderitem = itemList.get(j);
                productorderitem.setProductOrderItemProduct(productService.getByProductId(productorderitem.getProductOrderItemProductId()));
                Product product = productorderitem.getProductOrderItemProduct();
                product.setSingleProductImageList(productimageService.getProductimgeList(product.getProductId()));
                productorderitem.setIsReview(reviewService.getIsReview(product.getProductId()));
            }
        }
        model.addAttribute("categoryList",categoryService.getCategoryAll());
        model.addAttribute("status",status);
        model.addAttribute("productOrderList",list);
        model.addAttribute("pageUtil",pageUtil);
        return "fore/orderListPage";
    }

    @RequestMapping("/order/create/{productId}")
    public String goToBuyCarPage(@PathVariable("productId") Integer productId,Integer product_number){

        return "";
    }
}
