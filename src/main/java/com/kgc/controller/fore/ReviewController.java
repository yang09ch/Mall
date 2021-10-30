package com.kgc.controller.fore;

import com.kgc.pojo.Product;
import com.kgc.pojo.Productorderitem;
import com.kgc.pojo.Review;
import com.kgc.pojo.User;
import com.kgc.service.ProductService;
import com.kgc.service.ProductimageService;
import com.kgc.service.ProductorderitemService;
import com.kgc.service.ReviewService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

@Controller
public class ReviewController {
    @Resource
    ProductorderitemService productorderitemService;
    @Resource
    ProductService productService;
    @Resource
    ProductimageService productimageService;
    @Resource
    ReviewService reviewService;
    @RequestMapping("/review/{itemId}")
    public String toReview(@PathVariable("itemId")Integer itemId, Model model, HttpSession session){
        User user = (User)session.getAttribute("user");
        if (user==null){
            return "redirect:/user/UserLogin";
        }
        //订单对象
        Productorderitem item = productorderitemService.getByProductorderItem(itemId);
        item.setProductOrderItemProduct(productService.getByProductId(item.getProductOrderItemProductId()));
        //获取订单的商品的对象
        Product product = item.getProductOrderItemProduct();
        //商品评价数
        product.setProductReviewCount(reviewService.getReviewCount(product.getProductId()));
        //商品的图片
        product.setSingleProductImageList(productimageService.getProductimgeList(product.getProductId()));
        model.addAttribute("orderItem",item);
        return "fore/addReview";
    }
    @RequestMapping("/review")
    public String doReview(Review review){
        if (reviewService.addReview(review)>0){
            return "redirect:/order/0/10";
        }
        return "redirect:/review/"+review.getReviewOrderItemId();
    }
}
