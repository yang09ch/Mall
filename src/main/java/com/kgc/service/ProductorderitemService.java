package com.kgc.service;

public interface ProductorderitemService {
    /**
     * 计算商品销售数量 根据商品的id
     */
    int getProductorderItemCount(Integer productorId);
}
