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
    /**
     * 查看 用户购物车的商品
     */
    List<Productorderitem> getByProductorItemUserId(Integer userId);
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
    int updateProductorderItemUpdate( Integer number, Integer productId, Integer userId);
    /**
     * 清空购物车 订单为null
     */
    int removeProductorItem(Integer productorderitemId);
}
