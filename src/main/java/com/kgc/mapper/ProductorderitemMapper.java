package com.kgc.mapper;

import org.apache.ibatis.annotations.Mapper;
//订单明细
@Mapper
public interface ProductorderitemMapper {
    /**
     * 计算商品销售数量 根据商品的id
     */
    int getProductorderItemCount(Integer productorId);
}
