package com.kgc.service;

import com.kgc.pojo.Property;

import java.util.List;

public interface PropertyService {
    /**
     * 根据商品id获取 商品属性
     * @param categoryId
     * @return
     */
    List<Property> propertyList(Integer categoryId);
}
