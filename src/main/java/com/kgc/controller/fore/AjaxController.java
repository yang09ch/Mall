package com.kgc.controller.fore;

import com.alibaba.fastjson.JSON;
import com.kgc.pojo.Address;
import com.kgc.pojo.Category;
import com.kgc.pojo.Product;
import com.kgc.pojo.User;
import com.kgc.service.AddressService;
import com.kgc.service.CategoryService;
import com.kgc.service.ProductService;
import com.kgc.service.UserService;
import org.apache.ibatis.jdbc.Null;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
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
    @RequestMapping("/toUserLogin")//登录
    public String toUserLogin(String username, String password, HttpSession session){
        User userLogin = userService.getUserLogin(username, password);
       if (userLogin!=null){
           session.setAttribute("user",userLogin);
           return "ok";
       }
       return "no";
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
    public String doRegister(User user){
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
}
