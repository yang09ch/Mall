package com.kgc.mapper;

import com.kgc.pojo.Property;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

//商品属性
@Mapper
public interface PropertyMapper {
    /**
     * 根据商品id获取 商品属性
     * @param categoryId
     * @return
     */
    List<Property> propertyList(Integer categoryId);
}
