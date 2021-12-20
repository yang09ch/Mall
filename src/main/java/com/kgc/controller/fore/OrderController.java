package com.kgc.controller.fore;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.kgc.pojo.*;
import com.kgc.service.*;
import com.kgc.util.PageUtil;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.math.BigDecimal;
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
    @Resource
    AddressService addressService;
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
    @RequestMapping("/order/create/byCart")
    public String toByPage(String order_item_list,HttpSession session,Model model){
        User user = (User)session.getAttribute("user");
        String substring = user.getUserAddress().substring(0, 2);
        Address address = addressService.getByUserAddress(user.getUserAddress());
        substring += "0000";//省
        model.addAttribute("addressId", substring);
        model.addAttribute("districtAddressId", address.getAddressAreaId());
        model.addAttribute("cityAddressId", address.getAddressRegionId());
        model.addAttribute("addressList", addressService.addressList());
        model.addAttribute("cityList", addressService.cityList(substring));
        model.addAttribute("order_receiver",user.getUserNickName());
        model.addAttribute("districtList", addressService.districtList(addressService.cityList(substring).get(0).getAddressAreaId()));
        List<Productorderitem> productorderitemList =JSONArray.parseArray(order_item_list,Productorderitem.class);
        BigDecimal orderTotalPrice=new BigDecimal(0);
        for (Productorderitem productorderitem : productorderitemList) {
            productorderitem.setProductOrderItemProduct(productService.getByProductId(productorderitem.getProductOrderItemProductId()));
            Product product = productorderitem.getProductOrderItemProduct();
            product.setSingleProductImageList(productimageService.getProductimgeList(product.getProductId()));
            product.setProductCategory(categoryService.getCategoryById(product.getProductCategoryId()));
            //计算 商品价格
            int number = productorderitem.getProductOrderItemNumber();
            BigDecimal nb=new BigDecimal(number);
            orderTotalPrice=orderTotalPrice.add(productorderitem.getProductOrderItemPrice().multiply(nb));
        }
        model.addAttribute("orderTotalPrice",orderTotalPrice);
        model.addAttribute("orderItemList",productorderitemList);
        return "fore/productBuyPage";
    }
    @RequestMapping("/order/pay/{productOrderCode}")//立即付款
    public String toPay(@PathVariable("productOrderCode") String productOrderCode,Model model){
        Productorder byProductorCode = productorderService.getByProductorCode(productOrderCode);
        byProductorCode.setProductOrderItemList(productorderitemService.getProductorderItemList(byProductorCode.getProductOrderId()));
        BigDecimal orderTotalPrice=new BigDecimal(0);
        List<Productorderitem> orderItemList = byProductorCode.getProductOrderItemList();
        for (Productorderitem productorderitem : orderItemList) {
            int itemNumber = productorderitem.getProductOrderItemNumber();
            BigDecimal itemPrice = productorderitem.getProductOrderItemPrice();
            orderTotalPrice=orderTotalPrice.add(itemPrice.multiply(new BigDecimal(itemNumber)));
        }
        model.addAttribute("orderTotalPrice",orderTotalPrice);
        model.addAttribute("productOrder",byProductorCode);
        return "fore/productPayPage";
    }
   /* @RequestMapping("/order/delivery/{productOrderCode}")//提醒发货
    public String delivery(@PathVariable("productOrderCode") String productOrderCode){
        return "";
    }*/
    @RequestMapping("/order/confirm")//确认收货
    public String confirm(@RequestParam("productOrderCode") String productOrderCode, Model model){
        Productorder productorder = productorderService.getByProductorCode(productOrderCode);
        productorder.setProductOrderItemList(productorderitemService.getProductorderItemList(productorder.getProductOrderId()));
        List<Productorderitem> itemList = productorder.getProductOrderItemList();
        BigDecimal price=new BigDecimal(0);
        for (Productorderitem productorderitem : itemList) {
            productorderitem.setProductOrderItemProduct(productService.getByProductId(productorderitem.getProductOrderItemProductId()));
            price=price.add(productorderitem.getProductOrderItemPrice());
            Product product = productorderitem.getProductOrderItemProduct();
            product.setSingleProductImageList(productimageService.getProductimgeList(product.getProductId()));
        }
        model.addAttribute("orderTotalPrice",price);
        model.addAttribute("productOrder",productorder);
        return "fore/orderConfirmPage";
    }
    @RequestMapping("/order/success")//交易成功
    public String success(@RequestParam("productOrderCode") String productOrderCode,Model model){//完成订单
        Productorder productorder = productorderService.getByProductorCode(productOrderCode);
        productorder.setProductOrderItemList(productorderitemService.getProductorderItemList(productorder.getProductOrderId()));
        List<Productorderitem> itemList = productorder.getProductOrderItemList();
        if (itemList.size()==1){
            for (int i=0;i<itemList.size();i++){
                Productorderitem productorderitem = itemList.get(i);
                productorderitem.setProductOrderItemProduct(productService.getByProductId(productorderitem.getProductOrderItemProductId()));
                Product product = productorderitem.getProductOrderItemProduct();
                product.setSingleProductImageList(productimageService.getProductimgeList(product.getProductId()));
                model.addAttribute("product",product);
                model.addAttribute("orderItem",productorderitem);
            }
        }
        return "fore/orderSuccessPage";
    }
    @RequestMapping("/order/pay/success/{code}")
    public String PaySuccess(@PathVariable String code,Model model){
        Productorder productorder = productorderService.getByProductorCode(code);
        productorder.setProductOrderItemList(productorderitemService.getProductorderItemList(productorder.getProductOrderId()));
        List<Productorderitem> itemList = productorder.getProductOrderItemList();
        BigDecimal orderTotalPrice=new BigDecimal(0);
        for (Productorderitem productorderitem : itemList) {
            int itemNumber = productorderitem.getProductOrderItemNumber();
            BigDecimal itemPrice = productorderitem.getProductOrderItemPrice();
            orderTotalPrice=orderTotalPrice.add(itemPrice.multiply(new BigDecimal(itemNumber)));
        }
        model.addAttribute("orderTotalPrice",orderTotalPrice);
        model.addAttribute("productOrder",productorder);
        model.addAttribute("categoryList",categoryService.getCategoryAll());
        return "fore/productPaySuccessPage";
    }
}
