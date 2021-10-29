package com.kgc.mapper;

import com.kgc.pojo.Productorder;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

//商品订单
@Mapper
public interface ProductorderMapper {
    /**
     * 分页条件查询 订单 根据商品的状态  productorderStatus订单状态
     */
    int getProductorderCount(@Param("productorderStatus") String productorderStatus,@Param("productorderUserId") Integer productorderUserId);
    List<Productorder> getProductorderList(@Param("productorderStatus") String productorderStatus,@Param("productorderUserId") Integer productorderUserId,@Param("pageIndex") Integer pageIndex,@Param("pageSize")Integer pageSize);
}
