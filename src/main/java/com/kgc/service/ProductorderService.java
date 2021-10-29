package com.kgc.service;

import com.kgc.pojo.Productorder;
import com.kgc.util.PageUtil;

/**
 * 商品订单 业务
 */
public interface ProductorderService {
    PageUtil<Productorder> getProductorderPage(
            String productorderCode,String productorderPost,Integer pageIndex,Integer pageSize,Object...productorderStatus);
    /**
     * 详情
     */

    /**
     *  分页查询订单 根据状态查询所有订单
     */
    PageUtil<Productorder> getProductorderLimit(String productorderStatus,Integer productorderUserId,Integer pageIndex,Integer pageSize);
}
