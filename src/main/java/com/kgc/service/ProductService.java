package com.kgc.service;

import com.kgc.pojo.Product;
import com.kgc.util.PageUtil;

import java.math.BigDecimal;

public interface ProductService {
    PageUtil<Product> getProductLimit(String productName, BigDecimal firstPrice, BigDecimal lastPrice, Integer productCategoryId, Integer pageIndex, Integer pageSize, Object...productIsEnabled);
}
