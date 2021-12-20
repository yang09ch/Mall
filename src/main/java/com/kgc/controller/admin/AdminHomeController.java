package com.kgc.controller.admin;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import com.kgc.pojo.Admin;
import com.kgc.pojo.Productorder;
import com.kgc.service.AdminService;
import com.kgc.service.ProductService;
import com.kgc.service.ProductorderService;
import com.kgc.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * 后台管理-主页*/


@Controller
public class AdminHomeController {
  @Resource
  private AdminService adminService;
  @Resource
  private ProductorderService productOrderService;
  @Resource
  private ProductService productService;
  @Resource
  private UserService userService;

  //转到后台管理-主页
  @RequestMapping(value = "admin", method = RequestMethod.GET)
  public String goToPage(HttpSession session, Map<String, Object> map) throws ParseException {
/*    logger.info("检查管理员权限");*/
    Object adminId =session.getAttribute("admin");
    if (adminId == null) {
      return "redirect:/admin/login";
    }

   /* logger.info("获取管理员信息");*/
    Admin admin = (Admin) session.getAttribute("admin");
    map.put("admin", admin);
   /* logger.info("获取统计信息");*/
    Integer productTotal = productService.getTotal(null, new Byte[]{0, 2});
    Integer userTotal = userService.getTotal(null);
    Integer orderTotal = productOrderService.getTotal(null, new Byte[]{3});
 /*   logger.info("获取图表信息");*/
    map.put("jsonObject", getChartData(null,null));
    map.put("productTotal", productTotal);
    map.put("userTotal", userTotal);
    map.put("orderTotal", orderTotal);

/*    logger.info("转到后台管理-主页");*/
    return "admin/homePage";
  }

  //转到后台管理-主页-ajax
  @RequestMapping(value = "admin/home", method = RequestMethod.GET)
  public String goToPageByAjax(HttpSession session, Map<String, Object> map) throws ParseException {
 /*   logger.info("检查管理员权限");*/
      Object adminId =session.getAttribute("admin");
    if (adminId == null) {
      return "admin/include/loginMessage";
    }

/*    logger.info("获取管理员信息");*/
      Admin admin = (Admin) session.getAttribute("admin");
    map.put("admin", admin);
   /* logger.info("获取统计信息");*/
    Integer productTotal = productService.getTotal(null, new Byte[]{0, 2});
    Integer userTotal = userService.getTotal(null);
    Integer orderTotal = productOrderService.getTotal(null, new Byte[]{3});
    /*logger.info("获取图表信息");*/
    map.put("jsonObject", getChartData(null, null));
/*    logger.info("获取图表信息");*/
    map.put("jsonObject", getChartData(null,null));
    map.put("productTotal", productTotal);
    map.put("userTotal", userTotal);
    map.put("orderTotal", orderTotal);
/*    logger.info("转到后台管理-主页-ajax方式");*/
    return "admin/homeManagePage";
  }

  //按日期查询图表数据-ajax
  @ResponseBody
  @RequestMapping(value = "admin/home/charts", method = RequestMethod.GET, produces = "application/json;charset=utf-8")
  public String getChartDataByDate(@RequestParam(required = false) String beginDate, @RequestParam(required = false) String endDate) throws ParseException {
    if (beginDate != null && endDate != null) {
      SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
      return getChartData(simpleDateFormat.parse(beginDate), simpleDateFormat.parse(endDate)).toJSONString();
    } else {
      return getChartData(null, null).toJSONString();
    }
  }

  //获取图表的JSON数据
  private JSONObject getChartData(Date beginDate,Date endDate) throws ParseException {
    JSONObject jsonObject = new JSONObject();
    SimpleDateFormat time = new SimpleDateFormat("yyyy-MM-dd", Locale.UK);
    SimpleDateFormat timeSpecial = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.UK);
    if (beginDate == null || endDate == null) {
      Calendar cal = Calendar.getInstance();
      cal.add(Calendar.DATE, -7);
      beginDate = time.parse(time.format(cal.getTime()));
      cal = Calendar.getInstance();
      cal.add(Calendar.DATE, -1);
      endDate = timeSpecial.parse(time.format(cal.getTime()) + " 23:59:59");
    } else {
      beginDate = time.parse(time.format(beginDate));
      endDate = timeSpecial.parse(time.format(endDate) + " 23:59:59");
    }
    String[] dateStr = new String[7];
    SimpleDateFormat time2 = new SimpleDateFormat("MM/dd", Locale.UK);
   /* logger.info("获取时间段数组");*/
    for (int i = 0; i < dateStr.length; i++) {
      Calendar cal = Calendar.getInstance();
      cal.setTime(beginDate);
      cal.add(Calendar.DATE, i);
      dateStr[i] = time2.format(cal.getTime());
    }
/*    logger.info("获取总交易额订单列表");*/
      // 开始时间  结束时间
    List<Productorder> orderGroupList = productOrderService.getTotalByDate(beginDate, endDate);
    /*logger.info("根据订单状态分类");*/
    int[] orderTotalArray = new int[7];//总交易订单数组
    int[] orderUnpaidArray = new int[7];//未付款订单数组
    int[] orderNotShippedArray = new int[7];//未发货订单叔祖
    int[] orderUnconfirmedArray = new int[7];//未确认订单数组
    int[] orderSuccessArray = new int[7];//交易成功数组
    for (Productorder orderGroup : orderGroupList) {

     //String timeequals= time2.format(orderGroup.getProductOrderPayDate());
      int index = 0;
      for (int j = 0; j < dateStr.length; j++) {
        if (dateStr[j].equals(time2.format(orderGroup.getProductOrderPayDate()))) {
          index = j;
        }
      }
      switch (orderGroup.getProductOrderStatus()) {
        case 0:
          orderUnpaidArray[index] = orderGroup.getProductOrderCount();////未付款
          break;
        case 1:
          orderNotShippedArray[index] = orderGroup.getProductOrderCount();////未发货
          break;
        case 2:
          orderUnconfirmedArray[index] = orderGroup.getProductOrderCount();//未确认
          break;
        case 3:
          orderSuccessArray[index] = orderGroup.getProductOrderCount();//交易成功
          break;
      }
    }
/*    logger.info("获取总交易订单数组");*/
    for (int i = 0; i < dateStr.length; i++) {
      orderTotalArray[i] = orderUnpaidArray[i] + orderNotShippedArray[i] + orderUnconfirmedArray[i] + orderSuccessArray[i];
    }
/*    logger.info("返回结果集map");*/
    jsonObject.put("orderTotalArray", JSONArray.parseArray(JSON.toJSONString(orderTotalArray)));
    jsonObject.put("orderUnpaidArray", JSONArray.parseArray(JSON.toJSONString(orderUnpaidArray)));
    jsonObject.put("orderNotShippedArray", JSONArray.parseArray(JSON.toJSONString(orderNotShippedArray)));
    jsonObject.put("orderUnconfirmedArray", JSONArray.parseArray(JSON.toJSONString(orderUnconfirmedArray)));
    jsonObject.put("orderSuccessArray", JSONArray.parseArray(JSON.toJSONString(orderSuccessArray)));
    jsonObject.put("dateStr",JSONArray.parseArray(JSON.toJSONString(dateStr)));
    return jsonObject;
  }
}
