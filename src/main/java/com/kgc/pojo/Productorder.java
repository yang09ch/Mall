package com.kgc.pojo;

import lombok.Data;
//商品订单
import java.io.Serializable;
@Data
public class Productorder implements Serializable {
    private Integer productorderId;//主键
            private String  productorderCode;//订单编号
    private String  productorderAddress;//订单地址
            private String  productorderDetailAddress;//订单详细地址
    private String  productorderPost;//邮编
            private String  productorderReceiver;//收件人
    private String  productorderMobile;//收件人电话
            private String productorderPayDate;// 支付日期
    private String productorderDeliveryDate;//运送日期
             private String  productorderConfirmDate;//确认收货日期
    private Integer productorderStatus;//状态
            private Integer productorderUserId;//订单用户
}
