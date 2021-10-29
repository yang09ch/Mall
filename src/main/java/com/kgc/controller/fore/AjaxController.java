package com.kgc.controller.fore;

import com.kgc.pojo.*;
import com.kgc.service.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//ajax 控制类  所有异步操作在本控制类进行
@RestController
@RequestMapping("ajax")
public class AjaxController {
    @Resource
    UserService userService;
    @Resource
    AddressService addressService;
    @Resource
    CategoryService categoryService;
    @Resource
    ProductService productService;
    @Resource
    ProductorderitemService productorderitem;
    @RequestMapping("/toUserLogin")//登录
    public Map<String,Object> toUserLogin(String username, String password, HttpSession session){
        User userLogin = userService.getUserLogin(username, password);
        Map<String,Object> map=new HashMap<>();
       if (userLogin!=null){
           session.setAttribute("user",userLogin);
           map.put("success",true);

       }else {
           map.put("success",false);
       }
     return map;
    }
    @GetMapping(value = "/address/{id}",produces = {"application/json;charset=utf-8"})
    public Map<String,Object> address(@PathVariable("id") String id){
            Map<String,Object> map=new HashMap<>();
            List<Address> addresses = addressService.cityList(id);
            List<Address> districtList = addressService.districtList(addresses.get(0).getAddressAreaId());
            map.put("addressList",addresses);
            map.put("childAddressList",districtList);
            map.put("success",true);
            return map;
    }/*省 市 区绑定*/

    @RequestMapping("/doRegister")
    public String doRegister(User user){//注册
        return "["+userService.addUser(user)+"]";
    }
  @RequestMapping(value = "/nav/{id}")
    public Map<String,Object> showNav(@PathVariable Integer id){
      List<Category> list = categoryService.getCategoryAll();
      Map<String,Object> map=new HashMap<>();
      Category c=new Category();
      for (int i=0;i<list.size();i++){
          if (list.get(i).getCategoryId()==id){
              c.setComplexProductList(productService.getProductList(id));
          }
      }
      map.put("success",true);
      map.put("category",c);
      return map;


  }
    @RequestMapping("/create/{productId}")//加入购物车
    public Map<String,Object> create(@PathVariable("productId") Integer productId,Integer product_number,HttpSession session){
        User user = (User)session.getAttribute("user");//获取用户
        Map<String,Object> map=new HashMap<>();
        List<Productorderitem> prodList = productorderitem.getByProductorItemUserId(user.getUserId());//获取购物车的集合
        if (prodList.size()>0){//如果用户的购物车中存在商品 首先在购物车中查询
            for (Productorderitem producto1 : prodList) {
                if (productId==producto1.getProductOrderItemProductId()){//当该商品存在 进行数量修改
                    productorderitem.updateProductorderItemUpdate(product_number,productId,user.getUserId());
                    map.put("success",true);
                    return map;
                }
            }
        }
        Productorderitem productItem=new Productorderitem();
        productItem.setProductOrderItemUserId(user.getUserId());
        productItem.setProductOrderItemProductId(productId);
        productItem.setProductOrderItemNumber(product_number);
        Product product = productService.getByProductId(productId);
        productItem.setProductOrderItemPrice(product.getProductSalePrice());
        if (productorderitem.getProductorderitemInsert(productItem)>0){
            map.put("success",true);
        }else {
            map.put("success",false);
        }
        return map;
    }
}
