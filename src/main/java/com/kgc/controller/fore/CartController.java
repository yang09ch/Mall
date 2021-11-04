package com.kgc.controller.fore;
import com.kgc.pojo.Product;
import com.kgc.pojo.Productorderitem;
import com.kgc.pojo.User;
import com.kgc.service.CategoryService;
import com.kgc.service.ProductService;
import com.kgc.service.ProductimageService;
import com.kgc.service.ProductorderitemService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.List;
@Controller
@RequestMapping("cart")
public class CartController {
    @Resource
    CategoryService categoryService;
    @Resource
    ProductorderitemService productorderitemService;
    @Resource
    ProductService productService;
    @Resource
    ProductimageService productimageService;
    @RequestMapping("/cart")//购物车展示
    public String goCart(Model model, HttpSession session){
        User user = (User)session.getAttribute("user");
        if (user==null){
            return "redirect:/user/UserLogin";
        }
        int getCount=0;
        //获取所有购物车商品
        List<Productorderitem> productorderitemList = productorderitemService.getByProductorItemUserId(user.getUserId());
        for (Productorderitem productorderitem : productorderitemList) {
            productorderitem.setProductOrderItemProduct(productService.getByProductId(productorderitem.getProductOrderItemProductId()));
            Product product = productorderitem.getProductOrderItemProduct();
            product.setProductCategory(categoryService.getCategoryById(product.getProductCategoryId()));
            product.setSingleProductImageList(productimageService.getProductimgeList(product.getProductId()));
            getCount++;
        }
        model.addAttribute("orderItemTotal",getCount);
        model.addAttribute("orderItemList",productorderitemList);
        model.addAttribute("categoryList",categoryService.getCategoryAll());
        return "fore/productBuyCarPage";
    }
}
