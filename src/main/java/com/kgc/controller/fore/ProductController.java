package com.kgc.controller.fore;

import com.kgc.pojo.Product;
import com.kgc.pojo.Review;
import com.kgc.service.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import java.util.List;

@Controller
@RequestMapping("product")
public class ProductController  {
    @Resource
    ProductService productService;
    @Resource
    CategoryService categoryService;
    @Resource
    ProductimageService productimageService;
    @Resource
    ProductorderitemService productorderitemService;
    @Resource
    ReviewService reviewService;
    @Resource
    UserService userService;
    @GetMapping("/product")
    public String getProduct(String productName,Integer categoryId
            , Model model){
        model.addAttribute("searchValue",productName);//绑定到搜索框的值
        model.addAttribute("categoryList",categoryService.getCategoryAll());//商品类型
        List<Product> productAll = productService.getProductAll(productName,categoryId);
        for(int i=0;i<productAll.size();i++){
            Product product = productAll.get(i);
            product.setSingleProductImageList(productimageService.getProductImgeYulan(product.getProductId()));
            product.setProductReviewCount(reviewService.getReviewCount(product.getProductId()));
            product.setProductSaleCount(productorderitemService.getProductorderItemCount(product.getProductId()));
            product.setProductCategory(categoryService.getCategoryById(product.getProductCategoryId()));
        }
        model.addAttribute("productList",productAll);
        return  "fore/productListPage";
    }
    @RequestMapping("toGetProduct/{productId}")//进详情页
    public String toGetProduct(@PathVariable("productId") Integer productId,Model model){
        Product product = productService.getByProductId(productId);
        product.setSingleProductImageList(productimageService.getProductImgeYulan(productId));
        product.setProductSaleCount(productorderitemService.getProductorderItemCount(productId));
        product.setProductReviewCount(reviewService.getReviewCount(productId));
        product.setProductCategory(categoryService.getCategoryById(product.getProductCategoryId()));
        product.setReviewList(reviewService.getReviewByProductId(productId));
        product.setDetailProductImageList(productimageService.getProductImageXIan(productId));
        for (int i=0;i<product.getReviewList().size();i++){
            Review review = product.getReviewList().get(i);
            review.setReviewUser(userService.getUserGetById(review.getReviewUserId()));
        }
        model.addAttribute("product",product);
        return "fore/productDetailsPage";
    }

}
