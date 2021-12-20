package com.kgc.pojo;

import lombok.Data;
//商品订单
import java.io.Serializable;
import java.util.List;

@Data
public class Productorder implements Serializable {
    private Integer productOrderId;//主键
            private String  productOrderCode;//订单编号
    private String  productOrderAddress;//订单地址
            private String  productOrderDetailAddress;//订单详细地址
    private String  productOrderPost;//邮编
            private String  productOrderReceiver;//收件人
    private String  productOrderMobile;//收件人电话
            private String productOrderPayDate;// 支付日期
    private String productOrderDeliveryDate;//运送日期
             private String  productOrderConfirmDate;//确认收货日期
    private Integer productOrderStatus;//状态
            private Integer productOrderUserId;//订单用户
    private List<Productorderitem> productOrderItemList;//订单明细集合
    private Integer productOrderCount;
}
