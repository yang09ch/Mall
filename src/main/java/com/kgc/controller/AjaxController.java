package com.kgc.controller;

import com.kgc.pojo.Address;
import com.kgc.pojo.User;
import com.kgc.service.AddressService;
import com.kgc.service.UserService;
import com.kgc.vo.AddressVo;
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
    public Map<String,Object> address(@PathVariable("id") Integer id){
        Map<String,Object> map=new HashMap<>();
        List<Address> addresses = addressService.cityList(id);
        List<Address> districtList = addressService.districtList(id);
       map.put("addressList",addresses);
       map.put("childAddressList",districtList);
        return map;
    }

}
