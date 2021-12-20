package com.kgc.controller.fore;
import com.kgc.pojo.Product;
import com.kgc.pojo.Property;
import com.kgc.pojo.PropertyValue;
import com.kgc.pojo.Review;
import com.kgc.service.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.annotation.Resource;
import java.util.ArrayList;
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
    @Resource
    PropertyService propertyService;
    @Resource
    PropertyValueService propertyValueService;
    @GetMapping("/product")//搜索
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
        product.setSingleProductImageList(productimageService.getProductImgeYulan(productId));//商品图片集合
        product.setProductSaleCount(productorderitemService.getProductorderItemCount(productId));//购买数量
        product.setProductReviewCount(reviewService.getReviewCount(productId));//评论数量
        product.setProductCategory(categoryService.getCategoryById(product.getProductCategoryId()));//商品类型
        product.setReviewList(reviewService.getReviewByProductId(productId));//评论集合
        product.setDetailProductImageList(productimageService.getProductImageXIan(productId));//详细图片
        for (int i=0;i<product.getReviewList().size();i++){
            Review review = product.getReviewList().get(i);
            review.setReviewUser(userService.getUserGetById(review.getReviewUserId()));//user对象
        }
        //商品参数
        List<Property> propertyList = propertyService.propertyList(product.getProductCategoryId());//商品属性集合
        List<PropertyValue> propertyValues = propertyValueService.getProperValueAllByProductId(productId);//商品属性值集合
        for (int i=0;i<propertyList.size();i++){
            for (Property property : propertyList) {
                List<PropertyValue> list=new ArrayList<>();
                for (PropertyValue value : propertyValues) {
                    if (property.getPropertyId()==value.getPropertyValuePropertyId()){
                        list.add(value);
                    }
                }
                property.setPropertyValueList(list);
            }
        }
        model.addAttribute("product",product);
        model.addAttribute("propertyList",propertyList);
        model.addAttribute("categoryList",categoryService.getCategoryAll());
        return "fore/productDetailsPage";
    }
}
