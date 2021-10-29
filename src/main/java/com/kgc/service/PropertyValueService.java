package com.kgc.service;

import com.kgc.pojo.PropertyValue;

import java.util.List;

public interface PropertyValueService {
    /**
     * 根据商品的 id获取商品的属性值
     * @param productId
     * @return
     */
    List<PropertyValue> getProperValueAllByProductId(Integer productId);
}
