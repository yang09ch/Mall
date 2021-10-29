package com.kgc.mapper;

import com.kgc.pojo.Productorderitem;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

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

    /**
     * 新增进购物车  在购物车中的商品  是未生成订单的 订单为null
     * @param productorderitem
     * @return
     */
    int getProductorderitemInsert(Productorderitem productorderitem);

    /**
     * 更新 已加入购物车中的商品数量 订单为null   根据商品的id和用户的id
     * @return
     */
    int updateProductorderItemUpdate(@Param("number") Integer number,@Param("productId") Integer productId,@Param("userId") Integer userId);
    /**
     * 清空购物车 订单为null
     */
    int removeProductorItem(@Param("productId") Integer productId,@Param("userId") Integer userId);
    /**
     * 查看 用户购物车的商品
     */
    List<Productorderitem> getByProductorItemUserId(Integer userId);

}
