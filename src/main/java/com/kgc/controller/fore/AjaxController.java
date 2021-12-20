package com.kgc.controller.fore;
import com.alibaba.fastjson.JSON;
import com.kgc.pojo.*;
import com.kgc.service.*;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.*;

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
    @Resource
    ProductorderService productorderService;
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
    @RequestMapping("/orderItem/{productOrderItemId}")//清除购物车
    public Map<String,Object> orderItem(@PathVariable("productOrderItemId") Integer productOrderItemId,HttpSession session){
            User user = (User) session.getAttribute("user");
            Map<String,Object> map=new HashMap<>();
        List<Productorderitem> productorderitemList = productorderitem.getByProductorItemUserId(user.getUserId());
        for (Productorderitem productord: productorderitemList) {
            if (productOrderItemId.equals(productord.getProductOrderItemId())){
                productorderitem.removeProductorItem(productOrderItemId);
                map.put("success",true);
            }
        }
        return  map;
    }
    @RequestMapping("/orderItem")
    public Map<String,Object> orderItem(String orderItemMap){
        Map jsonObject = JSON.parseObject(orderItemMap);
        List<Productorderitem> productorderitemList = new ArrayList<>();
        for (Object obj : jsonObject.keySet()) {
            Productorderitem byProductorderItem = productorderitem.getByProductorderItem(Integer.valueOf(obj.toString()));
            productorderitemList.add(byProductorderItem);
        }
        Map<String,Object> map=new HashMap<>();
        map.put("orderItemIDArray",productorderitemList);
       if (JSON.toJSONString(productorderitemList)!=null){
           map.put("success",true);
       }else{
           map.put("success",false);
       }
        return map;
    }
    @RequestMapping("/close/{code}")//取消订单
    public Map<String,Object> adsff(@PathVariable String code){
        Map<String,Object> map=new HashMap<>();
        if (productorderService.removeProductor(code)>0){
            map.put("success",true);
        }
        return map;
    }
    @RequestMapping("/success")//确认收货 修改状态
    public Map<String,Object> success( String productOrderCode){
        Map<String,Object> map=new HashMap<>();
        //修改状态
        int i = productorderService.updateProductorStatus(productOrderCode);
        if (i>0){
            map.put("success",true);
        }else{
            map.put("success",false);
        }
        return  map;
    }
    @RequestMapping("/order/list")//新增订单
    public Map<String,Object> list(String addressId,String cityAddressId,String districtAddressId,String productOrderDetailAddress,String productOrderPost,
                                   String productOrderReceiver,String productOrderMobile,String orderItemJSON,HttpSession session){
        Map<String,Object> map=new HashMap<>();
        User user = (User) session.getAttribute("user");
        String format=new SimpleDateFormat("yyyyMMddHHmmss").format(new Date())+"0"+user.getUserId();//生成订单号
        Productorder productorder=new Productorder();
        productorder.setProductOrderUserId(user.getUserId());//用户id
        productorder.setProductOrderCode(format);//订单号
        productorder.setProductOrderStatus(0);//状态
        productorder.setProductOrderMobile(productOrderMobile);//手机号
        productorder.setProductOrderDetailAddress(productOrderDetailAddress);//详细地址
        productorder.setProductOrderReceiver(productOrderReceiver);//收货人姓名
        productorder.setProductOrderPost(productOrderPost);//邮编
        productorder.setProductOrderAddress(districtAddressId);//地址
        productorder.setProductOrderPayDate(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
        if (productorderService.addProductor(productorder)>0){//当为 true 说明订单生成成功
            Map object = JSON.parseObject(orderItemJSON);
            for (Object obj : object.keySet()) {//获取 订单明细表的id map 放入备注和订单
                Productorderitem productorderItem = productorderitem.getByProductorderItem(Integer.valueOf(obj.toString()));
                productorderItem.setProductOrderItemUserMessage(object.get(obj).toString());//备注
                //根据 生成的订单号获取订单的id
                productorderItem.setProductOrderItemOrderId(productorderService.getByProductorCode(format).getProductOrderId());
                productorderitem.getUpdateProductorderItem(productorderItem);
            }
            map.put("url","pay/"+format);
            map.put("success",true);
        }
        return map;
    }
    @RequestMapping("/pay/{code}")
    public Map<String,Object> getPay(@PathVariable("code") String code){
        Map<String,Object> map=new HashMap<>();
        Productorder byProductorCode = productorderService.getByProductorCode(code);
        byProductorCode.setProductOrderStatus(1);
        if (productorderService.updateProductor(byProductorCode)>0){
            map.put("success",true);
            map.put("url","/pay/success/"+code);
        }
        return map;
    }
}
