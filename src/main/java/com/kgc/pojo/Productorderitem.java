package com.kgc.pojo;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

//订单明细
@Data
public class Productorderitem implements Serializable {
    private Integer productOrderItemId;//主键
    private int productOrderItemNumber;//数量
    private BigDecimal productOrderItemPrice;//价格
    private Integer productOrderItemProductId;//商品编号
    private Integer productOrderItemOrderId;//订单编号
    private Integer productOrderItemUserId;//用户id
    private String productOrderItemUserMessage;//备注
    private Product productOrderItemProduct;//商品对象
    private Boolean isReview;//
}
