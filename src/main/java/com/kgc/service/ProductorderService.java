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

}
