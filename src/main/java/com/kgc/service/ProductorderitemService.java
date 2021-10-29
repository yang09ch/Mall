package com.kgc.service;

import com.kgc.pojo.Productorderitem;

import java.util.List;

public interface ProductorderitemService {
    /**
     * 计算商品销售数量 根据商品的id
     */
    int getProductorderItemCount(Integer productorId);
    /**
     * 根据订单id 获取订单明细数据
     */
    List<Productorderitem> getProductorderItemList(Integer productorderitemOrderId);
}
