package com.kgc.mapper;

import com.kgc.pojo.PropertyValue;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

//商品属性值
@Mapper
public interface PropertyValueMapper {
    /**
     * 根据商品的 id获取商品的属性值
     * @param productId
     * @return
     */
 List<PropertyValue> getProperValueAllByProductId(Integer productId);
}

