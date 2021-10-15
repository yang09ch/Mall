package com.kgc.pojo;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
//订单明细
@Data
public class Productorderitem implements Serializable {
    private Integer productorderitemId;//主键
            private int productorderitemNumber;//数量
    private BigDecimal productorderitemPrice;//价格
            private Integer productorderitemProductId;//商品编号
    private Integer productorderitemOrderId;//订单编号
            private Integer productorderitemUserId;//用户id
    private String productorderitemUserMessage;//备注
}
