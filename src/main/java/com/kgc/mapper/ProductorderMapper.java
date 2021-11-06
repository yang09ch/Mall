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
    /**
     * 根据订单号 进行删除
     * @param productorderCode
     * @return
     */
    int removeProductor(String productorderCode);
    /**
     * 根据订单号 查询
     */
    Productorder getByProductorCode(@Param("productorderCode")String productorderCode);
    /**
     * 确定收货  将订单状态改为3
     */
    int updateProductorStatus(@Param("productorderCode")String productorderCode);
    /**
     * 订单新增
     * @param productorder
     * @return
     */
    int addProductor(Productorder productorder);
    /**
     *  修改订单信息
     */
    int updateProductor(Productorder productorder);
}
