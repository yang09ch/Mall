package com.kgc.service;

import com.kgc.pojo.Product;
import com.kgc.util.PageUtil;


import java.math.BigDecimal;
import java.util.List;

public interface ProductService {
    PageUtil<Product> getProductLimit(String productName, BigDecimal firstPrice, BigDecimal lastPrice, Integer productCategoryId, Integer pageIndex, Integer pageSize, Object...productIsEnabled);
    /**
     * 根基 商品类型查询 正则出售或者是促销的商品（显示前8条记录）
     */
    List<Product> getProductArray(Integer productCategoryId);
    /**
     * 轮播  进行绑定数据 展示前六条
     */
    List<Product> getLunPo();
    /**
     * 模糊查询商品
     */
    List<Product> getProductAll(String productName,Integer productCategoryId);
    /*根据id获取商品查询*/
    List<Product> getProductList(Integer productCategoryId);
    /**
     * 根据搜索框输入的商品查询 存在数量
     */
    int getProductNameByCount(String productName);
    /**
     * 根据商品id 获取商品的对象
     */
    Product getByProductId(Integer productId);


}
