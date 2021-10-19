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
    Product getProductByCategoryId(Integer productCategoryId);
    /**
     * 轮播  进行绑定数据 展示前六条
     */
    List<Product> getLunPo();
}
