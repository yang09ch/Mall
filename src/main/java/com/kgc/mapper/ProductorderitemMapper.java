package com.kgc.mapper;

import com.kgc.pojo.Productorderitem;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

//订单明细
@Mapper
public interface ProductorderitemMapper {
    /**
     * 计算商品销售数量 根据商品的id
     */
    int getProductorderItemCount(Integer productorId);
    /**
     * 根据订单id 获取订单明细数据
     */
    List<Productorderitem> getProductorderItemList(Integer productorderitemOrderId);
}
